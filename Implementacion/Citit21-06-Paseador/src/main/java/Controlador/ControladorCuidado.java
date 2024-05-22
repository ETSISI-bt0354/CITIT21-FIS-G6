package Controlador;

import Modelo.Cuidado;
import Modelo.Id;
import Repositorio.Repository;
import Vista.VistaCuidado;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ControladorCuidado {
    private final VistaCuidado vista;
    private final IdAssigner idAssigner;
    private final Repository<Cuidado> repositorioCuidado;
    private static final ControladorCuidado instance;

    private ControladorCuidado(Repository<Cuidado> repositorioCuidado) {
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
            return new ControladorCuidado();

        return instance;
    }

    private Cuidado crearCuidado(HashMap<String, String> params) {
        LocalDateTime fecha;
        Duration duracion;

        try {
            fecha = LocalDateTime.parse(params.get("fecha"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta la fecha del cuidado.\n");
        }

        try {
            duracion = Duration.parse(params.get("duracion"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta la duracion del cuidado.\n");
        }

        return new Cuidado(fecha, duracion, idAssigner.nextId());
    }

    public void crearCuidadoMascota(HashMap<String, String> params) {
        Cuidado cuidado;

        try {
            cuidado = crearCuidado(params);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        cuidado.setMascota();

    }

    public void crearCuidadoCuidador(HashMap<String, String> params) {
        Cuidado cuidado;

        try {
            cuidado = crearCuidado(params);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        cuidado.setCuidador();
    }
}
