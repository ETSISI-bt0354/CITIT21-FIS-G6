package Controlador;

import Modelo.*;
import Repositorio.InMemoryRepository;
import Vista.VistaUsuario;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ControladorUsuario {
    private static final int MIN_REG_CUIDADOR_PARAMS = 5;
    private static final int MIN_REG_RESPONSABLE_PARAMS = 2;
    // private static Usuario loggedUser = null;
    private final IdAssigner idAssigner;
    private final VistaUsuario vista;
    private final InMemoryRepository<Responsable> repositorioResponsable;
    private final InMemoryRepository<Cuidador> repositorioCuidador;

    public ControladorUsuario(InMemoryRepository<Responsable> repositorioResponsable,
                              InMemoryRepository<Cuidador> repositorioCuidador) {
        this.repositorioResponsable = repositorioResponsable;
        this.repositorioCuidador = repositorioCuidador;
        this.vista = new VistaUsuario();

        this.idAssigner = new IdAssigner(repositorioResponsable.obtenerTodos().map(Id::getId).max(Integer::compareTo).map(x -> x + 1).orElse(0));
    }

    public void registrarCuidador(HashMap<String, String> params) {
        if (params.size() < MIN_REG_CUIDADOR_PARAMS)
            throw new IllegalArgumentException(
                    "Faltan parametros para registrar el cuidador."); // TODO: Should we specify which
        // parameters are missing?
        Responsable responsable = crearResponsable(params);
        repositorioResponsable.crear(responsable);
        vista.usuarioCreado(responsable);
    }

    public void registrarResponsable(HashMap<String, String> params) {
        if (params.size() < MIN_REG_RESPONSABLE_PARAMS)
            throw new IllegalArgumentException(
                    "Faltan parametros para registrar el responsable."); // TODO: Should we specify which
        // parameters are missing?
        Cuidador cuidador = crearCuidador(params);
        repositorioCuidador.crear(cuidador);
        vista.usuarioCreado(cuidador);
    }

    public void mostrarUsuario(Usuario usuario) {
        vista.mostrarUsuario(usuario);
    }

    public Responsable crearResponsable(HashMap<String, String> params) {
        TPlataforma plataforma = switch (params.get("plataforma")) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };

        return new Responsable(idAssigner.nextId(), plataforma, params.get("nombre"));
    }

    public Cuidador crearCuidador(HashMap<String, String> params) {
        TPlataforma plataforma = switch (params.get("plataforma")) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };

        return new Cuidador(0, params.get("descripcion"),
                            Double.parseDouble(params.get("tarifa")), LocalDateTime.parse(params.get("horario")),
                            params.get("nombre"), idAssigner.nextId(), plataforma);
    }
}
