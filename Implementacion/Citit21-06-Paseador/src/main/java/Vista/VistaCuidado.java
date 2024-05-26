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

    public void idInvalido(String id) {
        StringBuilder message = new StringBuilder();
        message.append(id);
        message.append(" no es un id válido\n");

        System.out.println(message);
    }

    public void cuidadoExistente() {
        System.out.println("El cuidado ya ha sido registrado anteriormente");
    }

    public void mascotaNoExistente() {
        System.out.println("La mascota no existe");
    }
}
