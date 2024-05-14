package Repositorio;

import Modelo.Cuidador;
import Modelo.TPlataforma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioCuidador
{
    private final List<Cuidador> repositorio;
    private int maxId;

    public RepositorioCuidador()
    {
        repositorio = new ArrayList<>();
        maxId = 0;
    }

    public Cuidador crear(HashMap<String, String> cuidador)
    {
        TPlataforma plataforma = switch (cuidador.get("plataforma")) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };

        Cuidador c = new Cuidador(); //TODO

        repositorio.add(c);

        return c;
    }

    public Cuidador obtener(int id)
    {
        return repositorio.stream().filter(cuidador -> cuidador.getId() == id).findAny().orElseThrow();
    }

    public void actualizar(Cuidador cuidador) {

    }

    public void borrar(int id)
    {
        repositorio.remove(repositorio.stream().filter(cuidador -> cuidador.getId() == id).findAny().orElseThrow());
    }

    private int assignID()
    {
        return maxId++;
    }
}
