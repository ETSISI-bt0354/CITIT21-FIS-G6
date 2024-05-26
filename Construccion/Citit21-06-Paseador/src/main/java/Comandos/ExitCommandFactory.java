package Comandos;

import java.util.List;

public class ExitCommandFactory implements ICommandFactory {

    @Override
    public Command getCommand(List<String> args) {
        return new ExitCommand();
    }

    @Override
    public String getDescription() {
        return "exit program";
    }

    @Override
    public void getHelp(List<String> args, String prefixCommand) {
        System.out.println("exit");
    }
}
