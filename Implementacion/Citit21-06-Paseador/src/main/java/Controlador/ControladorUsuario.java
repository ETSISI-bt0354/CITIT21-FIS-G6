package Controlador;

import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;
import Vista.VistaUsuario;
import java.util.HashMap;

public class ControladorUsuario {
  private static final int MIN_REG_CUIDADOR_PARAMS    = 5;
  private static final int MIN_REG_RESPONSABLE_PARAMS = 2;
  // private static Usuario loggedUser = null;
  private final VistaUsuario	       vista;
  private final RepositorioResponsable repositorioResponsable;
  private final RepositorioCuidador    repositorioCuidador;

  public ControladorUsuario(RepositorioResponsable repositorioResponsable,
			    RepositorioCuidador	   repositorioCuidador) {
    this.repositorioResponsable = repositorioResponsable;
    this.repositorioCuidador	= repositorioCuidador;
    this.vista			= new VistaUsuario();
  }

  public void registrarCuidador(HashMap<String, String> params) {
    if (params.size() < MIN_REG_CUIDADOR_PARAMS)
      throw new IllegalArgumentException(
	  "Faltan parametros para registrar el cuidador."); // TODO: Should we specify which
							    // parameters are missing?
    vista.usuarioCreado(repositorioCuidador.crear(params));
  }

  public void registrarResponsable(HashMap<String, String> params) {
    if (params.size() < MIN_REG_RESPONSABLE_PARAMS)
      throw new IllegalArgumentException(
	  "Faltan parametros para registrar el responsable."); // TODO: Should we specify which
							       // parameters are missing?
    vista.usuarioCreado(repositorioResponsable.crear(params));
  }

  public void mostrarUsuario(Usuario usuario) { vista.mostrarUsuario(usuario); }
}
