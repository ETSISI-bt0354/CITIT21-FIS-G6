package Controlador;

import Excepciones.*;
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

    public void registrarCuidado(HashMap<String, String> params) {
        Cuidado cuidado;
        try {
            cuidado = crearCuidadoMascota(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (FechaInvalida e) {
            vista.fechaInvalida(e.getFecha());
            return;
        } catch (DuracionInvalida e) {
            vista.duracionInvalida(e.getDuracion());
            return;
        } catch (IdInvalido e) {
            vista.idInvalido(e.getId());
            return;
        } catch (NotFound e) {
            vista.mascotaNoExistente();
            return;
        }

        try {
            repositorioCuidado.crear(cuidado);
        } catch (AlreadyExist e) {
            vista.cuidadoExistente();
            return;
        }
        vista.cuidadoCreado(cuidado);
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

    private Cuidado crearCuidadoMascota(HashMap<String, String> params)
            throws FechaInvalida, DuracionInvalida, CampoNoExistente, IdInvalido, NotFound {
        Cuidado cuidado;
        int mascotaId;

        cuidado = crearCuidado(params);

        if (!params.containsKey("mascota")) {
            throw new CampoNoExistente("mascota");
        }
        try {
            mascotaId = Integer.parseInt(params.get("mascota"));
        } catch (NumberFormatException e) {
            throw new IdInvalido(params.get("mascota"));
        }

        cuidado.setMascota(ControladorMascota.getInstance()
                                   .obtenerMascota(mascotaId));

        return cuidado;
    }
}
