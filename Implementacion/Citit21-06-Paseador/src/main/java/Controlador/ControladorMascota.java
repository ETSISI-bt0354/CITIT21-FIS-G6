package Controlador;

import Modelo.Exotico;
import Modelo.Id;
import Modelo.Mascota;
import Modelo.Responsable;
import Repositorio.GlobalRepository;
import Repositorio.IRepository;
import Vista.VistaMascota;

import java.io.IOException;
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
        Mascota mascota = crearMascota(params);
        repositorioMascota.crear(mascota);
        vista.registrarMascota(mascota);
    }

    public void registrarMascotaExotica(HashMap<String, String> params) {
        Exotico exotico = crearMascotaExotica(params);
        repositorioMascotaExotica.crear(exotico);
        vista.registrarMascota(exotico);
    }

    public Exotico crearMascotaExotica(HashMap<String, String> params) {
        int codigoPostal;
        try {
            codigoPostal = Integer.parseInt(params.get("codigo-postal"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Codigo postal no valido");
        }
        Mascota mascota;
        try {
            mascota = repositorioMascota.obtener(Integer.parseInt(params.get("mascota")));
        } catch (Exception e) {
            throw new IllegalArgumentException("Mascota no valida");
        }
        String nombre;
        try {
            nombre = params.get("nombre");
        } catch (Exception e) {
            throw new IllegalArgumentException("Nombre no valido");
        }
        String descripcion;
        try {
            descripcion = params.get("descripcion");
        } catch (Exception e) {
            throw new IllegalArgumentException("Descripcion no valida");
        }
        int responsableId;
        try {
            responsableId = Integer.parseInt(params.get("responsable"));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Responsable no existe");
        } catch (Exception e) {
            throw new IllegalArgumentException("Responsable no valido");
        }
        Responsable responsable;
        try {
            responsable = ControladorUsuario.getInstance()
                    .obtenerResponsable(responsableId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Responsable no existe");
        }
        Path permiso;
        try {
            permiso = Path.of(params.get(""));
        } catch (Exception e) {
            throw new IllegalArgumentException("Permiso no valido");
        }
        Path clegal;
        try {
            clegal = Path.of(params.get(""));
        } catch (Exception e) {
            throw new IllegalArgumentException("Certificado legal no valido");
        }
        Path csalud;
        try {
            csalud = Path.of(params.get(""));
        } catch (Exception e) {
            throw new IllegalArgumentException("Certificado de salud no valido");
        }

        return new Exotico(idAssigner.nextId(), nombre, codigoPostal, descripcion, responsable, permiso, clegal, csalud);
    }

    public Mascota crearMascota(HashMap<String, String> params) {
        int codigoPostal;
        try {
            codigoPostal = Integer.parseInt(params.get("codigo-postal"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Codigo postal no valido");
        }
        int responsableId;
        try {
            responsableId = Integer.parseInt(params.get("responsable"));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Responsable no existe");
        } catch (Exception e) {
            throw new IllegalArgumentException("Responsable no valido");
        }
        Responsable responsable;
        try {
            responsable = ControladorUsuario.getInstance()
                    .obtenerResponsable(responsableId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Responsable no existe");
        }
        String nombre;
        try {
            nombre = params.get("nombre");
        } catch (Exception e) {
            throw new IllegalArgumentException("Nombre no valido");
        }
        String descripcion;
        try {
            descripcion = params.get("descripcion");
        } catch (Exception e) {
            throw new IllegalArgumentException("Descripcion no valida");
        }

        return new Mascota(idAssigner.nextId(), nombre, codigoPostal, descripcion, responsable);
    }

    public void listarMascotas() {
        vista.listarMascotas(repositorioMascota.obtenerTodos());
    }

    public void mostrarMascota(Mascota mascota) {
        vista.mostrarMascota(mascota);
    }

    protected Mascota obtenerMascota(int id) {
        return repositorioMascota.obtener(id);
    }
}
