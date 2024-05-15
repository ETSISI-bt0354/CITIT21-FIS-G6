package Repositorio;

import Modelo.Mascota;
import Modelo.Responsable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioMascota {
  private final List<Mascota>	       repositorio;
  private final RepositorioResponsable responsables;
  private int			       maxId;

  public RepositorioMascota(RepositorioResponsable responsables) {
    repositorio	      = new ArrayList<>();
    this.responsables = responsables;
    maxId	      = 0;
  }

  public Mascota crear(HashMap<String, String> mascota) {
    int		codigoPostal = Integer.parseInt(mascota.get("codigo-postal"));
    Responsable responsable  = responsables.obtener(Integer.parseInt(mascota.get("responsable")));
    Mascota	m	     = new Mascota(assignId(), mascota.get("nombre"), codigoPostal,
					   mascota.get("descripcion"), responsable);

    repositorio.add(m);

    return m;
  }

  public Mascota obtener(int id) {
    return repositorio.stream().filter(mascota -> mascota.getId() == id).findAny().orElseThrow();
  }

  public void actualizar(Mascota mascota) {
    // TODO: Implementar
  }

  public void borrar(int id) {
    repositorio.remove(
	repositorio.stream().filter(mascota -> mascota.getId() == id).findAny().orElseThrow());
  }

  private int assignId() { return maxId++; }
}
