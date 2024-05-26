package Comandos.mascotaCommand;

import Comandos.CommandHelper;

import java.util.HashMap;
import java.util.List;

public class RegistrarMascotaCommand extends MascotaCommand {
    private HashMap<String, String> params;

    public RegistrarMascotaCommand() {
        params = new HashMap<>();
    }

    public void setParams(List<String> args) {
        try {
            params.put("nombre", args.get(0));
            params.put("descripcion", args.get(1));
            params.put("codigoPostal", args.get(2));
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Override
    public void exec() {
        super.controladorMascota.registrarMascota(params);
    }

    @Override
    public String getDescription() {
        return "Registrar una mascota";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("nombre descripcion codigo-postal");
        return message.toString();
    }
}
