package Comandos;

import java.util.List;

public interface ICommandFactory {
    public Command getCommand(List<String> args);

    public String getDescription();

    public void getHelp(List<String> args, String prefixCommand);
}
