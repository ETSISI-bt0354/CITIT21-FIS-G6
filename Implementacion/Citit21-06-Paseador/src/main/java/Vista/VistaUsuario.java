package Vista;

import Modelo.IUsuario;

public class VistaUsuario {
    public void usuarioCreado(IUsuario usuario) {
        StringBuilder message = new StringBuilder();
        message.append("Usuario creado con exito\n");

        System.out.println(message);
    }
}
