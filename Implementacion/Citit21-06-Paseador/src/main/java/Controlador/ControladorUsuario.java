package Controlador;

import Modelo.Cuidador;
import Modelo.Responsable;
import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;
import Vista.VistaUsuario;
import java.util.HashMap;

public class ControladorUsuario {
  private static final int MIN_REGCUIDADOR_PARAMS = 5;
  private static final int MIN_REGRESPONSABLE_PARAMS = 2;
  // private static Usuario loggedUser = null;
  private VistaUsuario vistaUsuario;
  private RepositorioResponsable repositorioResponsable;
  private RepositorioCuidador repositorioCuidador;

  public ControladorUsuario(RepositorioResponsable repositorioResponsable,
                            RepositorioCuidador repositorioCuidador) {
    this.repositorioResponsable = repositorioResponsable;
    this.repositorioCuidador = repositorioCuidador;
    this.vistaUsuario = new VistaUsuario();
  }

  public void registrarCuidador(HashMap<String, String> params) {
    if (params.size() < MIN_REGCUIDADOR_PARAMS)
      throw new IllegalArgumentException(
          "Faltan parametros para registrar el cuidador."); // TODO: Should we specify which parameters are missing?
    repositorioCuidador.crear(params);
  }

  public void registrarResponsable(HashMap<String, String> responsable) {
    repositorioResponsable.crear(responsable);
  }

  public void mostrarUsuario(Usuario usuario) {
    vistaUsuario.PrintUsuario(usuario);
  }
}
