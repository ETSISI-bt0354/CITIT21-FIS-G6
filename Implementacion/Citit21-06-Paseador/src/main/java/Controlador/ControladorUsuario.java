package Controlador;

import Modelo.*;
import Repositorio.FileRepository;
import Repositorio.Repository;
import Vista.VistaUsuario;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.stream.Stream;

public class ControladorUsuario {
    private static final ControladorUsuario instance = null;

    private final IdAssigner idAssigner;
    private final VistaUsuario vista;
    private final Repository<Responsable> repositorioResponsable;
    private final Repository<Cuidador> repositorioCuidador;

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }

        return instance;
    }

    private ControladorUsuario(Repository<Responsable> repositorioResponsable,
                              Repository<Cuidador> repositorioCuidador) {
        this.repositorioResponsable = repositorioResponsable;
        this.repositorioCuidador = repositorioCuidador;
        this.vista = new VistaUsuario();

        this.idAssigner = new IdAssigner(Stream.concat(repositorioResponsable.obtenerTodos(), repositorioCuidador.obtenerTodos())
                .map(Id::getId)
                .max(Integer::compareTo)
                .map(id -> id + 1)
                .orElse(0)
        );
    }

    public void registrarResponsable(HashMap<String, String> params) {
        Responsable responsable = crearResponsable(params);
        repositorioResponsable.crear(responsable);
        vista.usuarioCreado(responsable);
    }

    public void registrarCuidador(HashMap<String, String> params) {
        Cuidador cuidador = crearCuidador(params);
        repositorioCuidador.crear(cuidador);
        vista.usuarioCreado(cuidador);
    }

    public void mostrarUsuario(Usuario usuario) {
        vista.mostrarUsuario(usuario);
    }

    public Responsable crearResponsable(HashMap<String, String> params) {
        String nombre;
        try {
            nombre = params.get("nombre");
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta el nombre del responsable.");
        }
        TPlataforma plataforma = TPlataformaCheck(params);

        return new Responsable(idAssigner.nextId(), plataforma, nombre);
    }

    private TPlataforma TPlataformaCheck(HashMap<String, String> params) {
        return switch (params.get("plataforma")) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };
    }

    public Cuidador crearCuidador(HashMap<String, String> params) {
        String descripcion;
        try {
            descripcion = params.get("descripcion");
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta la descripcion del cuidador.");
        }
        double tarifa;
        try {
            tarifa = Double.parseDouble(params.get("tarifa"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta la tarifa del cuidador.");
        }
        LocalDateTime horario;
        try {
            horario = LocalDateTime.parse(params.get("horario"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta el horario del cuidador.");
        }
        String nombre;
        try {
            nombre = params.get("nombre");
        } catch (Exception e) {
            throw new IllegalArgumentException("Falta el nombre del cuidador.");
        }
        TPlataforma plataforma = TPlataformaCheck(params);

        return new Cuidador(0, descripcion, tarifa, horario, nombre, idAssigner.nextId(), plataforma);
    }

    public Responsable obtenerResponsable(int id) {
        return repositorioResponsable.obtener(id);
    }

    public Cuidador obtenerCuidador(int id) {
        return repositorioCuidador.obtener(id);
    }
}
