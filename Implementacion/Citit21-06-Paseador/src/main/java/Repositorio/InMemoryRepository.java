package Repositorio;

import Modelo.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class InMemoryRepository<T extends Id> {
    private final List<T> repo;

    public InMemoryRepository() {
        this.repo = new ArrayList<>();
    }

    public void crear(T t) {
        repo.add(t);
    }

    public T obtener(int id) {
        return repo.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public Stream<T> obtenerTodos() {
        return repo.stream();
    }

    public void actualizar(T t) {
    }

    public void eliminar(T t) {
        repo.remove(t);
    }
}
