package Comandos;


import java.util.List;

public class ExitCommand implements Command {

    @Override
    public String exec(List<String> args) {
        return "Exiting Paseador Platform";
    }

    @Override
    public String description() {
        return "Exit the program";
    }

    @Override
    public String help(List<String> args, String prefixCommand) {
        return CommandHelper.prefixCommandBuilder(prefixCommand, "").toString();
    }
}
