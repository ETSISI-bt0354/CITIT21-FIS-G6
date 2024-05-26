package Comandos.userCommand;

import Comandos.CommandHelper;
import Controlador.ControladorUsuario;

import java.util.List;

public class RegisterResponsableCommand extends UserCommand {
    public RegisterResponsableCommand(ControladorUsuario controller) {
        super(controller);
    }

    @Override
    public void exec(List<String> args) {
        super.controller.registrarResponsable(CommandHelper.argsToMap(args));
    }

    @Override
    public String getDescription() {
        return "Registrar un responsable";
    }

    @Override
    public String getHelp(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
