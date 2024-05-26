package Vista;

import Modelo.ICuidado;

public class VistaCuidado {
    public void cuidadoCreado(ICuidado cuidado) {
        StringBuilder message = new StringBuilder();
        message.append("Cuidado creado con exito\n");

        System.out.println(message);
    }

    public void campoNoExistente(String campo) {
        StringBuilder message = new StringBuilder();
        message.append("El campo ");
        message.append(campo);
        message.append(" no ha sido introducido\n");

        System.out.println(message);
    }

    public void fechaInvalida(String fecha) {
        StringBuilder message = new StringBuilder();
        message.append(fecha);
        message.append(" no es una fecha válida\n");

        System.out.println(message);
    }

    public void duracionInvalida(String duracion) {
        StringBuilder message = new StringBuilder();
        message.append(duracion);
        message.append(" no es una duración válida\n");

        System.out.println(message);
    }
}
