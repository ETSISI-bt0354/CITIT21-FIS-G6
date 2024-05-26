package Comandos;


import java.util.HashMap;
import java.util.List;

public class CommandHelper {
    public static StringBuilder prefixCommandBuilder(String prefixCommand, String separator) {
        StringBuilder message = new StringBuilder();
        if (!prefixCommand.isBlank()) {
            message.append(prefixCommand);
            message.append(separator);
        }

        return message;
    }

    public static HashMap<String, String> argsToMap(List<String> args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < args.size(); i += 2) {
            map.put(args.get(i), args.get(i + 1));
        }
        return map;
    }
}

