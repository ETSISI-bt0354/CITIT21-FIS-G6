package Comandos.userCommand;


import Comandos.CommandHelper;
import Controlador.ControladorUsuario;

import java.util.List;

public class RegisterCuidadorCommand extends UserCommand {
    public RegisterCuidadorCommand(ControladorUsuario controller) {
        super(controller);
    }

    @Override
    public void exec(List<String> args) {
        super.controller.registrarCuidador(CommandHelper.argsToMap(args));
    }

    @Override
    public String getDescription() {
        return "Registrar un cuidador";
    }

    @Override
    public String getHelp(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
