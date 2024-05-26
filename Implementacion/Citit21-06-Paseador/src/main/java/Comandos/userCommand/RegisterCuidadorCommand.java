package Comandos.userCommand;


import Comandos.CommandHelper;
import Controlador.ControladorUsuario;

import java.util.List;

public class RegisterCuidadorCommand extends UserCommand {
    public RegisterCuidadorCommand(ControladorUsuario controller) {
        super(controller);
    }

    @Override
    public String exec(List<String> args) {
        // return super.controller.registrarCuidador(CommandHelper.argsToMap(args));
        return "";
    }

    @Override
    public String description() {
        return "Register a Cuidador";
    }

    @Override
    public String help(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        //message.append(super.controller.registerUserHelp());
        return message.toString();
    }
}
