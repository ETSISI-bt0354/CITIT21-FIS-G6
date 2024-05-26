package Comandos.userCommand;


import Comandos.CommandHelper;
import Controlador.ControladorUsuario;

import java.util.List;

public class RegisterResponsableCommand extends UserCommand {
    public RegisterResponsableCommand(ControladorUsuario controller) {
        super(controller);
    }

    @Override
    public String exec(List<String> args) {
        return super.controller.registrarResponsable(CommandHelper.argsToMap(args));
    }

    @Override
    public String description() {
        return "Register a Responsable";
    }

    @Override
    public String help(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append(super.controller.registerUserHelp());
        return message.toString();
    }
}
