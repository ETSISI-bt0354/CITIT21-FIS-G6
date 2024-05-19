package Controlador;

import Modelo.Mascota;
import Repositorio.RepositorioMascota;
import Repositorio.RepositorioMascotaExotica;
import Vista.VistaMascota;
import java.util.HashMap;

public class ControladorMascota {
  private static final int		  MIN_REG_NO_EXOTICO_PARAMS = 4;
  private static final int		  MIN_REG_EXOTICO_PARAMS    = 7;
  private final RepositorioMascota	  repositorioMascota;
  private final RepositorioMascotaExotica repositorioMascotaExotica;
  private final VistaMascota		  vista;

  public ControladorMascota(RepositorioMascota	      repositorioMascota,
			    RepositorioMascotaExotica repositorioMascotaExotica) {
    this.repositorioMascota	   = repositorioMascota;
    this.repositorioMascotaExotica = repositorioMascotaExotica;
    this.vista			   = new VistaMascota();
  }

  public void registrarMascota(HashMap<String, String> params) {
    if (params.size() < MIN_REG_NO_EXOTICO_PARAMS)
      throw new IllegalArgumentException("Faltan parametros para registrar la mascota.");

    vista.registrarMascota(repositorioMascota.crear(params));
  }

  public void registrarMascotaExotica(HashMap<String, String> params) {
    if (params.size() < MIN_REG_EXOTICO_PARAMS)
      throw new IllegalArgumentException("Faltan parametros para registrar la mascota exotica.");

    vista.registrarMascota(repositorioMascotaExotica.crear(params));
  }

  public void listarMascotas() { vista.listarMascotas(repositorioMascota.fetchAll()); }

  public void mostrarMascota(Mascota mascota) { vista.mostrarMascota(mascota); }
}
