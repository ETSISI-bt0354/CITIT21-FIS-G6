package Repositorio;

import Modelo.Exotico;
import Modelo.Mascota;
import Modelo.Responsable;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioMascotaExotica {
    private final List<Exotico> repositorio;
    private final RepositorioResponsable responsables;
    private int maxId;

    public RepositorioMascotaExotica(RepositorioResponsable responsables) {
        repositorio = new ArrayList<>();
        this.responsables = responsables;
        maxId = 0;
    }

    public Mascota obtener(int id) {
        return repositorio.stream()
                .filter(exotico -> exotico.getId() == id)
                .findAny()
                .orElseThrow();
    }

    public void actualizar(Exotico exotico) {
        // TODO: Implementar
    }

    public void borrar(int id) {
        repositorio.remove(
                repositorio.stream()
                        .filter(exotico -> exotico.getId() == id)
                        .findAny()
                        .orElseThrow());
    }

    private int assignId() {
        return maxId++;
    }
}