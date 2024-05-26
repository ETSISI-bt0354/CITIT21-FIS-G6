package Comandos.mascotaCommand;

import Comandos.Command;
import Controlador.ControladorMascota;

public abstract class MascotaCommand implements Command {
    protected ControladorMascota controladorMascota;

    public MascotaCommand(ControladorMascota controlador) {
        this.controladorMascota = controlador;
    }
}
