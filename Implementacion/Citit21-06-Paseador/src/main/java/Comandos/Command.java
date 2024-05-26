package Comandos;

import java.util.List;

public interface Command {
    void exec(List<String> args);

    String getDescription();

    String getHelp(List<String> args, String prefixCommand);
}
