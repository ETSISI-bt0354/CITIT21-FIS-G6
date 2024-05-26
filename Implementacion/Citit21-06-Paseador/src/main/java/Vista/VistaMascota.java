package Vista;

import Modelo.IMascota;
import Modelo.Mascota;

import java.util.stream.Stream;

public class VistaMascota {
    public void registrarMascota(IMascota mascota) {
        StringBuilder message = new StringBuilder();
        message.append("\033[0;32m");
        message.append("La mascota con nombre: ");
        message.append("\033[0;36m");
        message.append(mascota.getNombre());
        message.append("\033[0;32m");
        message.append("código postal: ");
        message.append("\033[0;36m");
        message.append(mascota.getCodigoPostal());
        message.append("\033[0;32m");
        message.append("y descripción: ");
        message.append("\033[0;36m");
        message.append(mascota.getDescripcion());
        message.append("\033[0;32m");
        message.append(" ha sido registrada correctamente.");
        message.append("\033[0;0m");

        System.out.println(message);
    }

    public void mostrarMascota(IMascota mascota) {
        StringBuilder message = new StringBuilder();
        message.append("Nombre: ")
                .append(mascota.getNombre())
                .append("\n");
        message.append("Descripcion: ")
                .append(mascota.getDescripcion())
                .append("\n");

        System.out.println(message);
    }

    public void listarMascotas(Stream<Mascota> mascotas) {
        mascotas.forEach(this::mostrarMascota);
    }

    public void campoNoExistente(String campo) {
        StringBuilder message = new StringBuilder();
        message.append("El campo ");
        message.append(campo);
        message.append(" no ha sido introducido\n");

        System.out.println(message);
    }

    public void codigoPostalInvalido(String codigoPostal) {
        StringBuilder message = new StringBuilder();
        message.append(codigoPostal);
        message.append(" es inválido");

        System.out.println(message);
    }

    public void usuarioNoConectado() {
        System.out.println("Ningún usuario ha iniciado sesión");
    }
}
