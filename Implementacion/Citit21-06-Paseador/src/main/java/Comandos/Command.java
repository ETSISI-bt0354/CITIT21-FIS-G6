package Comandos;

import java.util.HashMap;
import java.util.List;

public interface Command {
    void exec();
    void setParams(List<String> args);

    String getDescription();

    String getHelp(String prefixCommand);
}
