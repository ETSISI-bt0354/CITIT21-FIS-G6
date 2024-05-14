package Controlador;

import Modelo.Cuidador;
import Modelo.Responsable;
import Modelo.Usuario;
import Repositorio.RepositorioCuidador;
import Repositorio.RepositorioResponsable;

public class ControladorUsuario
{
    private static Usuario loggedUser = null;
    private RepositorioResponsable repositorioResponsable;
    private RepositorioCuidador repositorioCuidador;

    public ControladorUsuario(RepositorioResponsable repositorioResponsable, RepositorioCuidador repositorioCuidador) {
        this.repositorioResponsable = repositorioResponsable;
        this.repositorioCuidador = repositorioCuidador;
    }

    public void registrarCuidador(Cuidador cuidador) {
    }

    public void registrarResponsable(Responsable responsable){
    }

    public void mostrarUsuario(Usuario usuario) {
    }
}
