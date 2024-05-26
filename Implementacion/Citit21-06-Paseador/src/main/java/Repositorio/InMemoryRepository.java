package Repositorio;

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
    public void crear(T t) {
        repo.add(t);
    }

    @Override
    public T obtener(int id) {
        return repo.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Stream<T> obtenerTodos() {
        return repo.stream();
    }

    @Override
    public void actualizar(T t) {
    }

    @Override
    public void eliminar(T t) {
        repo.remove(t);
    }
}
