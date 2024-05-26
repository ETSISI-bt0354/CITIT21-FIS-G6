package Repositorio;

import java.util.stream.Stream;

public interface IRepository<T> extends IGet<T> {
    public void crear(T t);
    public Stream<T> obtenerTodos();
    public void actualizar(T t);
    public void eliminar(T t);
}
