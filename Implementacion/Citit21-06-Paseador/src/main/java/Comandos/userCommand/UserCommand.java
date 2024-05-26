package Comandos.userCommand;

import Comandos.Command;
import Controlador.ControladorUsuario;

public abstract class UserCommand implements Command {
    protected ControladorUsuario controller;

    public UserCommand(ControladorUsuario controller) {
        this.controller = controller;
    }
}
