package Controlador;

import Excepciones.*;
import Modelo.Exotico;
import Modelo.Id;
import Modelo.Mascota;
import Modelo.Responsable;
import Repositorio.GlobalRepository;
import Repositorio.IRepository;
import Vista.VistaMascota;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Stream;

public class ControladorMascota {
    private final IdAssigner idAssigner;
    private final IRepository<Mascota> repositorioMascota;
    private final IRepository<Exotico> repositorioMascotaExotica;
    private final VistaMascota vista;
    private static ControladorMascota instance;

    private ControladorMascota(IRepository<Mascota> repositorioMascota,
                               IRepository<Exotico> repositorioMascotaExotica) {
        this.repositorioMascota = repositorioMascota;
        this.repositorioMascotaExotica = repositorioMascotaExotica;
        this.vista = new VistaMascota();

        this.idAssigner = new IdAssigner(Stream.concat(repositorioMascota.obtenerTodos(),
                                                       repositorioMascotaExotica.obtenerTodos())
                                                 .map(Id::getId)
                                                 .max(Integer::compareTo)
                                                 .map(id -> id + 1)
                                                 .orElse(0));
    }

    public static ControladorMascota getInstance() {
        if (instance == null) {
            instance = new ControladorMascota(GlobalRepository.getMascotas(), GlobalRepository.getExoticos());
        }

        return instance;
    }

    public void registrarMascota(HashMap<String, String> params) {
        Mascota mascota;
        try {
            mascota = crearMascota(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (CodigoPostalInvalido e) {
            vista.codigoPostalInvalido(e.getCodigoPostal());
            return;
        } catch (UsuarioNoConectado e) {
            vista.usuarioNoConectado();
            return;
        } catch (NotFound e) {
        vista.usuarioNoResponsable();
        return;
        }

        try {
            repositorioMascota.crear(mascota);
        } catch (AlreadyExist e) {
            vista.mascotaExistente();
            return;
        }
        vista.registrarMascota(mascota);
    }

    public void registrarMascotaExotica(HashMap<String, String> params) {
        Exotico exotico;
        try {
            exotico = crearMascotaExotica(params);
        } catch (CampoNoExistente e) {
            vista.campoNoExistente(e.getCampo());
            return;
        } catch (CodigoPostalInvalido e) {
            vista.codigoPostalInvalido(e.getCodigoPostal());
            return;
        } catch (UsuarioNoConectado e) {
            vista.usuarioNoConectado();
            return;
        } catch (NotFound e) {
            vista.usuarioNoResponsable();
            return;
        }

        try {
            repositorioMascotaExotica.crear(exotico);
        } catch (AlreadyExist e) {
            vista.mascotaExistente();
            return;
        }
        vista.registrarMascota(exotico);
    }

    public Exotico crearMascotaExotica(HashMap<String, String> params)
            throws CampoNoExistente, CodigoPostalInvalido, UsuarioNoConectado, NotFound {
        if (!params.containsKey("codigoPostal")) {
            throw new CampoNoExistente("codigoPostal");
        }
        int codigoPostal;
        try {
            codigoPostal = Integer.parseInt(params.get("codigoPostal"));
        } catch (NumberFormatException e) {
            throw new CodigoPostalInvalido(params.get("codigoPostal"));
        }

        String nombre = params.get("nombre");
        if (nombre == null) {
            throw new CampoNoExistente("nombre");
        }

        String descripcion = params.get("descripcion");
        if (descripcion == null) {
            throw new CampoNoExistente("descripcion");
        }

        int responsableId = LoginController.getInstance().getLogInUser().orElseThrow(UsuarioNoConectado::new);
        Responsable responsable = ControladorUsuario.getInstance()
                    .obtenerResponsable(responsableId);

        if (!params.containsKey("permiso")) {
            throw new CampoNoExistente("permiso");
        }
        Path permiso = Path.of(params.get("permiso"));

        if (!params.containsKey("certificadoLegal")) {
            throw new CampoNoExistente("certificadoLegal");
        }
        Path certificadoLegal = Path.of(params.get("certificadoLegal"));

        if (!params.containsKey("certificadoSalud")) {
            throw new CampoNoExistente("certificadoSalud");
        }
        Path certificadoSalud = Path.of(params.get(""));

        return new Exotico(idAssigner.nextId(), nombre, codigoPostal, descripcion, responsable, permiso, certificadoLegal, certificadoSalud);
    }

    public Mascota crearMascota(HashMap<String, String> params)
            throws CampoNoExistente, CodigoPostalInvalido, UsuarioNoConectado, NotFound {
        if (!params.containsKey("codigoPostal")) {
            throw new CampoNoExistente("codigoPostal");
        }
        int codigoPostal;
        try {
            codigoPostal = Integer.parseInt(params.get("codigoPostal"));
        } catch (NumberFormatException e) {
            throw new CodigoPostalInvalido(params.get("codigoPostal"));
        }

        String nombre = params.get("nombre");
        if (nombre == null) {
            throw new CampoNoExistente("nombre");
        }

        String descripcion = params.get("descripcion");
        if (descripcion == null) {
            throw new CampoNoExistente("descripcion");
        }

        int responsableId = LoginController.getInstance().getLogInUser().orElseThrow(UsuarioNoConectado::new);
        Responsable responsable = ControladorUsuario.getInstance()
                    .obtenerResponsable(responsableId);

        return new Mascota(idAssigner.nextId(), nombre, codigoPostal, descripcion, responsable);
    }

    public void listarMascotas() {
        vista.listarMascotas(Stream.concat(repositorioMascota.obtenerTodos(),
                repositorioMascotaExotica.obtenerTodos()));
    }

    protected Mascota obtenerMascota(int id) throws NotFound {
        try {
            return repositorioMascota.obtener(id);
        } catch (NotFound ignored) {}

        return repositorioMascotaExotica.obtener(id);
    }
}
