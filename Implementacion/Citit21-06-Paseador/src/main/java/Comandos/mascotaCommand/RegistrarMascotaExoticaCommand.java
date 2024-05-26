package Comandos.mascotaCommand;

import Comandos.CommandHelper;
import Controlador.ControladorMascota;

import java.util.List;

public class RegistrarMascotaExoticaCommand extends MascotaCommand {
    public RegistrarMascotaExoticaCommand(ControladorMascota controlador) {
        super(controlador);
    }

    @Override
    public void exec(List<String> args) {
        try {
            super.controladorMascota.crearMascotaExotica(CommandHelper.argsToMap(args));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
