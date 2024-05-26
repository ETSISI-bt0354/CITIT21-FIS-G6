package Comandos.cuidadoCommand;

import Comandos.CommandHelper;
import Controlador.ControladorCuidado;

import java.util.List;

public class RegistrarCuidadoCommand extends CuidadoCommand {
    public RegistrarCuidadoCommand(ControladorCuidado controlador) {
        super(controlador);
    }

    @Override
    public void exec(List<String> args) {
        super.controladorCuidado.registrarCuidado(CommandHelper.argsToMap(args));
    }

    @Override
    public String getDescription() {
        return "Registrar un cuidado";
    }

    @Override
    public String getHelp(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
