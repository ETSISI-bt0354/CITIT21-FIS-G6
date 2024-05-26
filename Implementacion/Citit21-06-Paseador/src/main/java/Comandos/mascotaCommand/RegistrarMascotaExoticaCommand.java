package Comandos.mascotaCommand;

import Comandos.CommandHelper;

import java.util.HashMap;
import java.util.List;

public class RegistrarMascotaExoticaCommand extends MascotaCommand {
    private HashMap<String, String> params;

    public RegistrarMascotaExoticaCommand() {
        params = new HashMap<>();
    }

    public void setParams(List<String> args) {
        try {
            params.put("nombre", args.get(0));
            params.put("descripcion", args.get(1));
            params.put("codigoPostal", args.get(2));
            params.put("permiso", args.get(3));
            params.put("certificadoLegal", args.get(4));
            params.put("certificadoSalud", args.get(5));
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Override
    public void exec() {
        super.controladorMascota.registrarMascotaExotica(params);

    }

    @Override
    public String getDescription() {
        return "Registrar una mascota exotica";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("nombre descripcion codigoPosatl permiso (path) certificadoLegal (path) certificadoSalud (path)");
        return message.toString();
    }
}
