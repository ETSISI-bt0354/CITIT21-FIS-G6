package Controlador;

import Modelo.Cuidador;
import Modelo.Responsable;
import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;
import Vista.VistaUsuario;
import java.util.HashMap;

public class ControladorUsuario {
  private static Usuario loggedUser = null;
  private VistaUsuario vistaUsuario;
  private RepositorioResponsable repositorioResponsable;
  private RepositorioCuidador repositorioCuidador;

  public ControladorUsuario(RepositorioResponsable repositorioResponsable,
                            RepositorioCuidador repositorioCuidador) {
    this.repositorioResponsable = repositorioResponsable;
    this.repositorioCuidador = repositorioCuidador;
    this.vistaUsuario = new VistaUsuario();
  }

  public void registrarCuidador(HashMap<String, String> cuidador) {
    repositorioCuidador.crear(cuidador);
  }

  public void registrarResponsable(HashMap<String, String> responsable) {
    repositorioResponsable.crear(responsable);
  }

  public void mostrarUsuario(Usuario usuario) {
    vistaUsuario.PrintUsuario(usuario);
  }
}
