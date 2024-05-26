package Comandos.userCommand;


import Comandos.CommandHelper;

import java.util.HashMap;
import java.util.List;

public class RegisterCuidadorCommand extends UserCommand {
    private HashMap<String, String> params;
    public RegisterCuidadorCommand() {
        params = new HashMap<>();
    }

    public void setParams(List<String> args) {
        try
        {
            params.put("nombre", args.get(0));
            params.put("descripcion", args.get(1));
            params.put("tarifa", args.get(2));
            params.put("horario", args.get(3));
            params.put("plataforma", args.get(4));
        } catch (IndexOutOfBoundsException ignored) {}
    }

    @Override
    public void exec() {
        super.controller.registrarCuidador(params);
    }

    @Override
    public String getDescription() {
        return "Registrar un cuidador";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("nombre descripcion tarifa horario (aaaa-mm-ddThh:mm:ss) plataforma");
        return message.toString();
    }
}
