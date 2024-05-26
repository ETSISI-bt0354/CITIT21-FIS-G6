package Controlador;

import Excepciones.*;
import Modelo.Cuidador;
import Modelo.Id;
import Modelo.Responsable;
import Modelo.TPlataforma;
import Repositorio.GlobalRepository;
import Repositorio.IRepository;
import Vista.VistaUsuario;
import servidor.ExternalRRSS;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.stream.Stream;

public class ControladorUsuario {
    private static ControladorUsuario instance = null;

    private final IdAssigner idAssigner;
    private final VistaUsuario vista;
    private final IRepository<Responsable> repositorioResponsable;
    private final IRepository<Cuidador> repositorioCuidador;

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario(GlobalRepository.getResponsables(), GlobalRepository.getCuidadores());
        }

        return instance;
    }

    private ControladorUsuario(IRepository<Responsable> repositorioResponsable,
                               IRepository<Cuidador> repositorioCuidador) {
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
        Responsable responsable;
        try {
            responsable = crearResponsable(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (PlataformaInvalida e) {
            vista.plataformaInvalida(e.getPlataforma());
            return;
        }

        try {
            repositorioResponsable.crear(responsable);
        } catch (AlreadyExist e) {
            vista.usuarioExistente();
            return;
        }
        vista.usuarioCreado(responsable);
    }

    public void registrarCuidador(HashMap<String, String> params) {
        Cuidador cuidador;
        try {
            cuidador = crearCuidador(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (PlataformaInvalida e) {
            vista.plataformaInvalida(e.getPlataforma());
            return;
        } catch (TarifaInvalida e) {
            vista.tarifaInvalida(e.getTarifa());
            return;
        } catch (HorarioInvalido e) {
            vista.horarioInvalido(e.getHorario());
            return;
        }

        try {
            repositorioCuidador.crear(cuidador);
        } catch (AlreadyExist e) {
            vista.usuarioExistente();
            return;
        }

        vista.usuarioCreado(cuidador);
    }

    public Responsable crearResponsable(HashMap<String, String> params)
            throws CampoNoExistente, PlataformaInvalida {
        String nombre = params.get("nombre");
        if (nombre == null) {
            throw new CampoNoExistente("nombre");
        }

        if (!params.containsKey("plataforma")) {
            throw new CampoNoExistente("plataforma");
        }
        TPlataforma plataforma = TPlataforma.parse(params.get("plataforma"));

        String codigoPlataforma = ExternalRRSS.LoginRRSS();

        return new Responsable(idAssigner.nextId(), codigoPlataforma, plataforma, nombre);
    }

    public Cuidador crearCuidador(HashMap<String, String> params)
            throws CampoNoExistente, TarifaInvalida, HorarioInvalido, PlataformaInvalida {
        String descripcion = params.get("descripcion");
        if (descripcion == null) {
            throw new CampoNoExistente("descripcion");
        }

        double tarifa;
        try {
            tarifa = Double.parseDouble(params.get("tarifa"));
        } catch (NullPointerException e) {
            throw new CampoNoExistente("tarifa");
        } catch (NumberFormatException e) {
            throw new TarifaInvalida(params.get("tarifa"));
        }


        if (!params.containsKey("horario")) {
            throw new CampoNoExistente("horario");
        }
        LocalDateTime horario;
        try {
            horario = LocalDateTime.parse(params.get("horario"));
        } catch (DateTimeParseException e) {
            throw new HorarioInvalido(params.get("horario"));
        }

        String nombre = params.get("nombre");
        if (nombre == null) {
            throw new CampoNoExistente("nombre");
        }

        if (!params.containsKey("plataforma")) {
            throw new CampoNoExistente("plataforma");
        }
        TPlataforma plataforma = TPlataforma.parse(params.get("plataforma"));

        String codigoPlataforma = ExternalRRSS.LoginRRSS();

        return new Cuidador(0, descripcion, tarifa, horario, nombre, idAssigner.nextId(), plataforma, codigoPlataforma);
    }

    protected Responsable obtenerResponsable(int id) throws NotFound {
        return repositorioResponsable.obtener(id);
    }

    protected Cuidador obtenerCuidador(int id) throws NotFound {
        return repositorioCuidador.obtener(id);
    }
}
