package Repositorio;

import Modelo.Id;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

public class Repository<T extends Id> implements IRepository<T> {
    private final FileRepository<T> persistance;
    private final InMemoryRepository<T> memory;

    public Repository(FileRepository<T> persistance) {
        this.persistance = persistance;
        this.memory = new InMemoryRepository<>();

        try {
            this.persistance.obtenerTodos()
                    .forEach(memory::crear);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void crear(T t) {
        memory.crear(t);
        try {
            persistance.crear(t);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public T obtener(int id) {
        return memory.obtener(id);
    }
    @Override
    public Stream<T> obtenerTodos() {
        return memory.obtenerTodos();
    }

    @Override
    public void actualizar(T t) {
        memory.actualizar(t);
        try {
            persistance.actualizar(t);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void eliminar(T t) {
        memory.eliminar(t);
        try {
            persistance.eliminar(t);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
