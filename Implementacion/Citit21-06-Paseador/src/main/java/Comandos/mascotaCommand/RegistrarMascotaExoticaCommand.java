package Comandos.mascotaCommand;

import Comandos.CommandHelper;

import java.util.List;

public class RegistrarMascotaExoticaCommand extends MascotaCommand {

    @Override
    public void exec(List<String> args) {
        super.controladorMascota.crearMascotaExotica(CommandHelper.argsToMap(args));
    }

    @Override
    public String getDescription() {
        return "Registrar una mascota exotica";
    }

    @Override
    public String getHelp(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
