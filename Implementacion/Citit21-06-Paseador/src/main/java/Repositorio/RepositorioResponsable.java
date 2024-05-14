package Repositorio;

import Modelo.Responsable;
import Modelo.TPlataforma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioResponsable
{
    private final List<Responsable> repositorio;
    private int maxId;

    public RepositorioResponsable()
    {
        repositorio = new ArrayList<>();
        maxId = 0;
    }

    public Responsable crear(HashMap<String, String> cuidador)
    {
        TPlataforma plataforma = switch (cuidador.get("plataforma")) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };

        Responsable r = new Responsable(assingId(), plataforma, cuidador.get("nombre"));

        repositorio.add(r);

        return r;
    }

    public Responsable obtener(int id)
    {
        return repositorio.stream().filter(responsable -> responsable.getId() == id).findAny().orElseThrow();
    }

    public void actualizar(Responsable responsable) {

    }

    public void borrar(int id)
    {
        repositorio.remove(repositorio.stream().filter(responsable -> responsable.getId() == id).findAny().orElseThrow());
    }

    private int assingId()
    {
        return maxId++;
    }
}
