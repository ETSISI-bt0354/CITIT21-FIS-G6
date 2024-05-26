package Comandos;


import java.util.List;

public class ExitCommand implements Command {

    @Override
    public void exec(List<String> args) {
        System.out.println();
    }

    @Override
    public String getDescription() {
        return "Salir del programa";
    }

    @Override
    public String getHelp(List<String> args, String prefixCommand) {
        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("");
        return message.toString();
    }
}
