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
