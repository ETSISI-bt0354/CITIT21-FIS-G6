package Vista;

import Modelo.IMascota;

import java.util.List;
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

    public void listarMascotas(Stream mascotas) {
        for (Object mascota : (List) mascotas.toList()) {
            mostrarMascota((IMascota) mascota);
        }
    }
}
