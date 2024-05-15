package Controlador;

import Modelo.Mascota;
import Repositorio.RepositorioMascota;
import Vista.VistaMascota;

import java.util.HashMap;

public class ControladorMascota {
  private static final int MIN_REGISTER_PARAMS = 4;
  private final RepositorioMascota repositorio;
  private VistaMascota vista;

  public ControladorMascota(RepositorioMascota repositorio) {
    this.repositorio = repositorio;
    this.vista = new VistaMascota();
  }

  public void registrarMascota(HashMap<String, String> params) {
    if (params.size() < MIN_REGISTER_PARAMS)
      throw new IllegalArgumentException(
          "Faltan parametros para registrar la mascota.");

    vista.registrarMascota(repositorio.crear(params));
  }

  public void registrarMascotaExotica(HashMap<String, String> params) {
    // TODO: Implementar
  }

  public void listarMascotas() {
    // TODO: Implementar
  }

  public void mostrarMascota(Mascota mascota) {
    // TODO: Implementar
  }
}
