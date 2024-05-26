package Vista;

import Modelo.IUsuario;

public class VistaUsuario {
    public String usuarioCreado(IUsuario usuario) {
        StringBuilder message = new StringBuilder();
        message.append("Usuario creado con exito\n");
        return message.toString();
    }

    public void campoNoExistente(String campo) {
        StringBuilder message = new StringBuilder();
        message.append("El campo ");
        message.append(campo);
        message.append(" no ha sido introducido\n");

        System.out.println(message);
    }

    public void plataformaInvalida(String plataforma) {
        StringBuilder message = new StringBuilder();
        message.append("La plataforma ");
        message.append(plataforma);
        message.append(" no está soportada\n");

        System.out.println(message);
    }

    public void tarifaInvalida(String tarifa) {
        StringBuilder message = new StringBuilder();
        message.append(tarifa);
        message.append(" no es una tarifa válida\n");

        System.out.println(message);
    }

    public void horarioInvalido(String horario) {
        StringBuilder message = new StringBuilder();
        message.append(horario);
        message.append(" no es un horario válido\n");

        System.out.println(message);
    }

    public void usuarioExistente() {
        System.out.println("El responsable ya ha sido registrado anteriormente");
    }
}
