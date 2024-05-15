package Controlador;

import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;
import Vista.VistaUsuario;
import java.util.HashMap;

public class ControladorUsuario {
  private static final int MIN_REGCUIDADOR_PARAMS = 5;
  private static final int MIN_REGRESPONSABLE_PARAMS = 2;
  // private static Usuario loggedUser = null;
  private VistaUsuario vista;
  private final RepositorioResponsable repositorioResponsable;
  private final RepositorioCuidador repositorioCuidador;

  public ControladorUsuario(RepositorioResponsable repositorioResponsable,
                            RepositorioCuidador repositorioCuidador) {
    this.repositorioResponsable = repositorioResponsable;
    this.repositorioCuidador = repositorioCuidador;
    this.vista = new VistaUsuario();
  }

  public void registrarCuidador(HashMap<String, String> params) {
    if (params.size() < MIN_REGCUIDADOR_PARAMS)
      throw new IllegalArgumentException(
          "Faltan parametros para registrar el cuidador."); // TODO: Should we specify which parameters are missing?
    vista.UsuarioCreado(repositorioCuidador.crear(params));
  }

  public void registrarResponsable(HashMap<String, String> params) {
    if (params.size() < MIN_REGRESPONSABLE_PARAMS)
      throw new IllegalArgumentException(
          "Faltan parametros para registrar el responsable."); // TODO: Should we specify which parameters are missing?
    vista.UsuarioCreado(repositorioResponsable.crear(params));
  }

  public void mostrarUsuario(Usuario usuario) {
    vista.PrintUsuario(usuario);
  }
}
