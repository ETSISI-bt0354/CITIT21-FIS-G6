package Comandos.cuidadoCommand;

import Comandos.Command;
import Controlador.ControladorCuidado;

public abstract class CuidadoCommand implements Command {
    protected ControladorCuidado controladorCuidado;

    public CuidadoCommand() {
        this.controladorCuidado = ControladorCuidado.getInstance();
    }
}
