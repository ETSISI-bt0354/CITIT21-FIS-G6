package Repositorio;

import Excepciones.NotFound;

public interface IGet<T> {
    public T obtener(int id) throws NotFound;
}
