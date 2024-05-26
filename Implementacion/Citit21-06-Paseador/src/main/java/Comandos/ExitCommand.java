package Comandos;


import java.util.List;

public class ExitCommand implements Command {

    @Override
    public void exec() {
        System.out.println();
    }

    @Override
    public void setParams(List<String> args) {

    }

    @Override
    public String getDescription() {
        return "Salir del programa";
    }

    @Override
    public String getHelp(String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
