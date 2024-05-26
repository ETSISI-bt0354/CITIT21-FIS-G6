package Comandos.userCommand;

import Comandos.CommandHelper;
import Controlador.ControladorUsuario;

import java.util.HashMap;
import java.util.List;

public class RegisterResponsableCommand extends UserCommand {
    private HashMap<String, String> params;
    public RegisterResponsableCommand() {
        params = new HashMap<>();
    }

    public void setParams(List<String> args) {
        try
        {
            params.put("nombre", args.get(0));
            params.put("descripcion", args.get(1));
            params.put("plataforma", args.get(2));
        } catch (IndexOutOfBoundsException ignored) {}
    }

    @Override
    public void exec() {
        super.controller.registrarResponsable(params);
    }

    @Override
    public String getDescription() {
        return "Registrar un responsable";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("nombre descripcion plataforma");
        return message.toString();
    }
}
