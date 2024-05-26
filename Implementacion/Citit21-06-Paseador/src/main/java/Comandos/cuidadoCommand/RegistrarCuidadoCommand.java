package Comandos.cuidadoCommand;

import Comandos.CommandHelper;
import Controlador.ControladorCuidado;

import java.util.HashMap;
import java.util.List;

public class RegistrarCuidadoCommand extends CuidadoCommand {
    private HashMap<String, String> params;
    public RegistrarCuidadoCommand() {
        params = new HashMap<>();
    }

    @Override
    public void setParams(List<String> args) {
        try
        {
            params.put("fecha", args.get(0));
            params.put("duracion", args.get(1));
            params.put("mascota", args.get(2));
        } catch (IndexOutOfBoundsException ignored) {}
    }

    @Override
    public void exec() {
        super.controladorCuidado.registrarCuidado(params);
    }

    @Override
    public String getDescription() {
        return "Registrar un cuidado";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("fecha (aaaa-mm-ddThh:mm:ss) duracion (PTcantidadunidad ej PT6H) id-mascota");
        return message.toString();
    }
}
