package Controlador;

import Modelo.Exotico;
import Modelo.Id;
import Modelo.Mascota;
import Repositorio.RepositorioMascota;
import Repositorio.RepositorioMascotaExotica;
import Repositorio.Repository;
import Vista.VistaMascota;

import java.util.HashMap;
import java.util.stream.Stream;

public class ControladorMascota {
    private static final int MIN_REG_NO_EXOTICO_PARAMS = 4;
    private static final int MIN_REG_EXOTICO_PARAMS = 7;
    private final IdAssigner idAssigner;
    private final Repository<Mascota> repositorioMascota;
    private final Repository<Exotico> repositorioMascotaExotica;
    private final VistaMascota vista;

    public ControladorMascota(Repository<Mascota> repositorioMascota,
                              Repository<Exotico> repositorioMascotaExotica) {
        this.repositorioMascota = repositorioMascota;
        this.repositorioMascotaExotica = repositorioMascotaExotica;
        this.vista = new VistaMascota();

        this.idAssigner = new IdAssigner(Stream.concat(repositorioMascota.obtenerTodos(),
                        repositorioMascotaExotica.obtenerTodos())
                .map(Id::getId)
                .max(Integer::compareTo).map(id -> id + 1)
                .orElse(0));
    }

    public void registrarMascota(HashMap<String, String> params) {
        if (params.size() < MIN_REG_NO_EXOTICO_PARAMS)
            throw new IllegalArgumentException("Faltan parametros para registrar la mascota.");

        vista.registrarMascota(repositorioMascota.crear(params));
    }

    public void registrarMascotaExotica(HashMap<String, String> params) {
        if (params.size() < MIN_REG_EXOTICO_PARAMS)
            throw new IllegalArgumentException("Faltan parametros para registrar la mascota exotica.");

        vista.registrarMascota(repositorioMascotaExotica.crear(params));
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
        Int responsable;

        return new Exotico(idAssigner.nextId(), nombre, codigoPostal, descripcion, responsable, permiso, clegal, csalud);
    }

    public void listarMascotas() {
        vista.listarMascotas(repositorioMascota.obtenerTodos());
    }

    public void mostrarMascota(Mascota mascota) {
        vista.mostrarMascota(mascota);
    }
}
