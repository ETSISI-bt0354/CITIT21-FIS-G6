package Repositorio;

import Modelo.Cuidado;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioCuidado {
  public final List<Cuidado> repositorio;

  public RepositorioCuidado() { repositorio = new ArrayList<>(); }

  public Cuidado crear(HashMap<String, String> cuidado) {
	Cuidado c =
		new Cuidado(LocalDateTime.parse(cuidado.get("fechaCuidado")),
					Duration.parse(cuidado.get("duracion")), Integer.parseInt(cuidado.get("id")));

	repositorio.add(c);

	return c;
  }

  public Cuidado obtener(int id) {
	return repositorio.stream().filter(cuidado -> cuidado.getId() == id).findAny().orElseThrow();
  }

  public void actualizar(Cuidado cuidado) {
	// TODO: Implementar
  }

  public void borrar(int id) {
	repositorio.remove(
		repositorio.stream().filter(cuidado -> cuidado.getId() == id).findAny().orElseThrow());
  }
}
