package Comandos.mascotaCommand;

import Comandos.CommandHelper;

import java.util.HashMap;
import java.util.List;

public class ListarMascotaCommand extends MascotaCommand
{
    @Override
    public void exec() {
        super.controladorMascota.listarMascotas();
    }

    @Override
    public void setParams(List<String> args)
    {

    }

    @Override
    public String getDescription() {
        return "Listar tus mascotas";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
