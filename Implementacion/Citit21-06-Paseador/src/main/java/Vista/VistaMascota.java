package Vista;

import Modelo.IMascota;

public class VistaMascota
{
    public void registrarMascota(IMascota mascota) {
        StringBuilder message = new StringBuilder();
        message.append("La mascota con nombre: ");
        message.append(mascota.getNombre());
        message.append("código postal: ");
        message.append(mascota.getCodigoPostal());
        message.append("y descripción: ");
        message.append(mascota.getDescripcion());
        message.append(" ha sido registrada correctamente.");

        System.out.println(message);
    }

    public void mostrarMascota(IMascota mascota) {
        StringBuilder message = new StringBuilder();

    }
}
