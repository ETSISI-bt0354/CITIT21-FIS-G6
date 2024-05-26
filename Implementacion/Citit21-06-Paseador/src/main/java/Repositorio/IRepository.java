package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;

import java.util.stream.Stream;

public interface IRepository<T> extends IGet<T> {
    public void crear(T t) throws AlreadyExist;

    public Stream<T> obtenerTodos();

    public void actualizar(T t) throws NotFound;

    public void eliminar(T t) throws NotFound;
}
