package Controlador;

import Excepciones.CampoNoExistente;
import Excepciones.DuracionInvalida;
import Excepciones.FechaInvalida;
import Modelo.Cuidado;
import Modelo.Id;
import Repositorio.GlobalRepository;
import Repositorio.IRepository;
import Vista.VistaCuidado;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class ControladorCuidado {
    private final VistaCuidado vista;
    private final IdAssigner idAssigner;
    private final IRepository<Cuidado> repositorioCuidado;
    private static ControladorCuidado instance;

    private ControladorCuidado(IRepository<Cuidado> repositorioCuidado) {
        this.repositorioCuidado = repositorioCuidado;
        this.vista = new VistaCuidado();
        this.idAssigner = new IdAssigner(repositorioCuidado.obtenerTodos()
                                                 .map(Id::getId)
                                                 .max(Integer::compareTo)
                                                 .map(x -> x + 1)
                                                 .orElse(0));
    }

    public static ControladorCuidado getInstance() {
        if (instance == null)
            instance = new ControladorCuidado(GlobalRepository.getCuidados());

        return instance;
    }

    private Cuidado crearCuidado(HashMap<String, String> params)
            throws CampoNoExistente, FechaInvalida, DuracionInvalida {
        LocalDateTime fecha;
        Duration duracion;

        if (!params.containsKey("fecha")) {
            throw new CampoNoExistente("fecha");
        }
        try {
            fecha = LocalDateTime.parse(params.get("fecha"));
        } catch (DateTimeParseException e) {
            throw new FechaInvalida(params.get("fecha"));
        }

        if (!params.containsKey("duracion")) {
            throw new CampoNoExistente("duracion");
        }
        try {
            duracion = Duration.parse(params.get("duracion"));
        } catch (DateTimeParseException e) {
            throw new DuracionInvalida(params.get("duracion"));
        }

        return new Cuidado(fecha, duracion, idAssigner.nextId());
    }

    public void crearCuidadoMascota(HashMap<String, String> params) {
        Cuidado cuidado;
        int id;

        try {
            cuidado = crearCuidado(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (FechaInvalida e) {
            vista.fechaInvalida(e.getFecha());
            return;
        } catch (DuracionInvalida e) {
            vista.duracionInvalida(e.getDuracion());
            return;
        }

        try {
            id = Integer.parseInt(params.get("masccota"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta la mascota del cuidado.\n");
        }

        cuidado.setMascota(ControladorMascota.getInstance()
                                   .obtenerMascota(id));

    }
}
