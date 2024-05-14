package Vista;

import Modelo.IUsuario;
import Modelo.TPlataforma;

public class VistaUsuario
{
    public VistaUsuario() {

    }

    public void UsuarioCreado(IUsuario usuario) {
        StringBuilder message = new StringBuilder();
        message.append("Usuario creado con exito\n");

        System.out.println(message);
    }

    public void PrintUsuario(IUsuario usuario) {
        StringBuilder message = new StringBuilder();
        message.append("Nombre: ").append(usuario.getNombre()).append("\n");
        message.append("Plataforma: ").append(usuario.getPlataforma()).append("\n");

        System.out.println(message);
    }
}


