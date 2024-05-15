package Controlador;

import Repositorio.RepositorioCuidado;
import Vista.VistaCuidado;
import java.util.HashMap;

public class ControladorCuidado {
  private static final int		   MIN_CREATE_PARAMS = 3;
  private final RepositorioCuidado repositorio;
  private VistaCuidado			   vista;

  public ControladorCuidado(RepositorioCuidado repositorio) {
	this.repositorio = repositorio;
	this.vista		 = new VistaCuidado();
  }

  private void crearCuidado(HashMap<String, String> params) {
	if (params.size() < MIN_CREATE_PARAMS)
	  throw new IllegalArgumentException("Faltan parametros para crear el cuidado.");

	vista.cuidadoCreado(repositorio.crear(params));
  }

  public void crearCuidadoMascota(HashMap<String, String> params) {
	// TODO: Implementar
  }

  public void crearCuidadoCuidador(HashMap<String, String> params) {
	// TODO: Implementar
  }
}
