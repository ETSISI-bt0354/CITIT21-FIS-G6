package Repositorio;

import Modelo.Mascota;
import Modelo.Responsable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioMascota {
    private final List<Mascota> repositorio;
    private final RepositorioResponsable responsables;
    private int maxId;

    public RepositorioMascota(RepositorioResponsable responsables) {
        this.repositorio = new ArrayList<>();
        this.responsables = responsables;
        this.maxId = 0;
    }

    public Mascota crear(HashMap<String, String> mascota) {
        int codigoPostal;
        try {
            codigoPostal = Integer.parseInt(mascota.get("codigo-postal"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Codigo postal no valido");
        }
        Responsable responsable;
        try {
            responsable = responsables.obtener(Integer.parseInt(mascota.get("responsable")));
        } catch (Exception e) {
            throw new IllegalArgumentException("Responsable no valido");
        }
        String nombre;
        try {
            nombre = mascota.get("nombre");
        } catch (Exception e) {
            throw new IllegalArgumentException("Nombre no valido");
        }
        String descripcion;
        try {
            descripcion = mascota.get("descripcion");
        } catch (Exception e) {
            throw new IllegalArgumentException("Descripcion no valida");
        }
        Mascota m = new Mascota(assignId(), nombre, codigoPostal,
                descripcion, responsable);

        repositorio.add(m);

        return m;
    }

    public Mascota obtener(int id) {
        return repositorio.stream()
                .filter(mascota -> mascota.getId() == id)
                .findAny()
                .orElseThrow();
    }

    public void actualizar(Mascota mascota) {
        // TODO: Implementar
    }

    public void borrar(int id) {
        repositorio.remove(
                repositorio.stream()
                        .filter(mascota -> mascota.getId() == id)
                        .findAny()
                        .orElseThrow());
    }

    private int assignId() {
        return maxId++;
    }
}
