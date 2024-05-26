package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;
import Modelo.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class InMemoryRepository<T extends Id> implements IRepository<T> {
    private final List<T> repo;

    public InMemoryRepository() {
        this.repo = new ArrayList<>();
    }

    @Override
    public void crear(T t) throws AlreadyExist {
        if (repo.stream().anyMatch(x -> x.getId() == t.getId())) {
            throw new AlreadyExist(t.getId());
        }

        repo.add(t);
    }

    @Override
    public T obtener(int id) throws NotFound {
        return repo.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFound(id));
    }

    @Override
    public Stream<T> obtenerTodos() {
        return repo.stream();
    }

    @Override
    public void actualizar(T t) throws NotFound {
        if (repo.stream().noneMatch(x -> x.getId() == t.getId())) {
            throw new NotFound(t.getId());
        }
    }

    @Override
    public void eliminar(T t) throws NotFound {
        if (!repo.remove(t)) {
            throw new NotFound(t.getId());
        }
    }
}
