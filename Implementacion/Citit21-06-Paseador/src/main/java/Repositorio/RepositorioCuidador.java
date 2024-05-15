package Repositorio;

import Modelo.Cuidador;
import Modelo.TPlataforma;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioCuidador {
  private final List<Cuidador> repositorio;
  private int		       maxId;

  public RepositorioCuidador() {
    repositorio = new ArrayList<>();
    maxId	= 0;
  }

  public Cuidador crear(HashMap<String, String> cuidador) {
    TPlataforma plataforma = switch (cuidador.get("plataforma")) {
			case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new IllegalArgumentException("Plataforma no valida");
        };

        Cuidador cui = new Cuidador(0, cuidador.get("descripcion"),
                Double.parseDouble(cuidador.get("tarifa")), LocalDateTime.parse(cuidador.get("horario")),
                cuidador.get("nombre"), assignID(), plataforma);

        repositorio.add(cui);

        return cui;
    }

    public Cuidador obtener(int id)
    {
        return repositorio.stream().filter(cuidador -> cuidador.getId() == id).findAny().orElseThrow();
    }

    public void actualizar(Cuidador cuidador) {
        // TODO: Implementar
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
