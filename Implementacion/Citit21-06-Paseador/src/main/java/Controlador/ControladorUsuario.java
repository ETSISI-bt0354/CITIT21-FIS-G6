package Controlador;

import Modelo.Cuidador;
import Modelo.Responsable;
import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;

import java.util.HashMap;

public class ControladorUsuario
{
    private static Usuario loggedUser = null;
    private RepositorioResponsable repositorioResponsable;
    private RepositorioCuidador repositorioCuidador;

    public ControladorUsuario(RepositorioResponsable repositorioResponsable, RepositorioCuidador repositorioCuidador) {
        this.repositorioResponsable = repositorioResponsable;
        this.repositorioCuidador = repositorioCuidador;
    }

    public void registrarCuidador(HashMap<String, String> cuidador) {

        repositorioCuidador.crear(cuidador);
    }

    public void registrarResponsable(HashMap<String, String> responsable) {
        repositorioResponsable.crear(responsable);
    }

    public void mostrarUsuario(Usuario usuario) {
    }
}
