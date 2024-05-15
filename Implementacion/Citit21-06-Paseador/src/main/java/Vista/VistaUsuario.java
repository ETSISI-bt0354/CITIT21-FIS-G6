package Vista;

import Modelo.IUsuario;

public class VistaUsuario {
  public void usuarioCreado(IUsuario usuario) {
	StringBuilder message = new StringBuilder();
	message.append("Usuario creado con exito\n");

	System.out.println(message);
  }

  public void mostrarUsuario(IUsuario usuario) {
	StringBuilder message = new StringBuilder();
	message.append("Nombre: ").append(usuario.getNombre()).append("\n");
	message.append("Plataforma: ").append(usuario.getPlataforma()).append("\n");

	System.out.println(message);
  }
}
