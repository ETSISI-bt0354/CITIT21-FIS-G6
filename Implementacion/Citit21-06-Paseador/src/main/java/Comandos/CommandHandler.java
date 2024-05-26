package Comandos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandHandler {
    private Map<String, ICommandFactory> factories;
    private String description;

    public CommandHandler(String description) {
        this.factories = new HashMap<>();
        this.description = description;
    }

    public void addCommand(String commandName, ICommandFactory factory) {
        factories.put(commandName, factory);
    }


    public Command getCommand(List<String> args) {
        if (args.isEmpty()) {
            System.out.println(handlerHelp());
            return null;
        }
        String commandName = args.get(0);
        args.remove(0);

        ICommandFactory factory = factories.get(commandName);
        if (factory == null) {
            StringBuilder message = new StringBuilder();
            if (!commandName.isEmpty()) {
                message.append(commandName);
                message.append(" is not a command\n");
            }
            message.append(handlerHelp());
            System.out.println(message);
            return null;
        }

        return factory.getCommand(args);
    }


    public String getDescription() {
        return description;
    }


    public void getHelp(List<String> args, String prefixCommand) {
        if (args.isEmpty()) {
            System.out.println(handlerHelp());
            return;
        }

        String commandName = args.get(0);
        args.remove(0);

        ICommandFactory factory = factories.get(commandName);
        if (factory == null) {
            StringBuilder message = new StringBuilder();
            if (!commandName.isEmpty()) {
                message.append(CommandHelper.prefixCommandBuilder(prefixCommand, " "));
                message.append(commandName);
                message.append(" is not a command\n");
            }
            message.append(handlerHelp());
            System.out.println(message);
            return;
        }

        StringBuilder message = CommandHelper.prefixCommandBuilder(prefixCommand, " ");
        message.append("\033[0;32m");
        message.append(commandName);
        message.append("\033[0m");

        StringBuilder helpMessage = new StringBuilder();
        if (args.isEmpty()) {
            helpMessage.append(factory.getDescription());
            helpMessage.append("\n");
        }

        factory.getHelp(args, message.toString());
    }

    private String handlerHelp() {
        StringBuilder message = new StringBuilder();
        factories.forEach((commandName, command) -> {
            StringBuilder aux = new StringBuilder();
            aux.append(commandName);
            aux.append(" ".repeat(5));
            if (aux.length() < 30)
                aux.append(" ".repeat(30 - aux.length()));
            aux.append(command.getDescription());

            message.append(aux);
            message.append("\n");
        });

        message.deleteCharAt(message.length() - 1);
        return message.toString();
    }
}
