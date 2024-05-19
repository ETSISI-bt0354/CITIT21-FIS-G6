package Repositorio;

import Modelo.Entidad;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class InMemoryRepository<T extends Entidad>
{
    private int id;
    private final List<T> memory;
    private final FileRepository<T> repo;

    public InMemoryRepository(FileRepository<T> repo) throws IOException
    {
        this.repo = repo;

        Stream<T> entidades = repo.obtenerTodos();
        memory = entidades.collect(Collectors.toList());
        entidades.close();

        id = memory.stream().map(Entidad::getId).max(Integer::compare).orElse(0);
    }

    public void crear(T t) throws IOException
    {
        t.setId(asignId());
        memory.add(t);
        repo.crear(t);
    }

    public T obtener(int id)
    {
        Stream<T> entidades = memory.stream().filter(t -> t.getId() == id);
        T t = entidades.findFirst().orElseThrow();
        entidades.close();
        return t;
    }

    public Stream<T> obtenerTodos()
    {
        return memory.stream();
    }

    public void actualizar(T t) throws IOException
    {
        repo.actualizar(t);
    }

    public void eliminar(T t) throws IOException
    {
        memory.remove(t);
        repo.eliminar(t);
    }

    private int asignId()
    {
        return id++;
    }
}
