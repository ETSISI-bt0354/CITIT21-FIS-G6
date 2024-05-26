import Comandos.Command;
import Comandos.CommandFactory;
import Comandos.CommandHandler;
import Comandos.cuidadoCommand.RegistrarCuidadoCommand;
import Comandos.mascotaCommand.ListarMascotaCommand;
import Comandos.mascotaCommand.RegistrarMascotaCommand;
import Comandos.mascotaCommand.RegistrarMascotaExoticaCommand;
import Comandos.userCommand.RegisterCuidadorCommand;
import Comandos.userCommand.RegisterResponsableCommand;
import Controlador.LoginController;
import Excepciones.AlreadyExist;
import Modelo.Mascota;
import Modelo.Responsable;
import Modelo.TPlataforma;
import Repositorio.GlobalRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Responsable r = new Responsable(0, "fhdashfughadjkghfdjk", TPlataforma.GOOGLE, "Lucas");
        try {
            GlobalRepository.getResponsables()
                    .crear(r);
        } catch (AlreadyExist ignored) {
        }

        LoginController.getInstance()
                .setLogInUser(0);

        Mascota m1 = new Mascota(0, "Rufian", 8214, "Un perro mordaz y preparado para todo", r);
        Mascota m2 = new Mascota(1, "Puerro", 28040, "No acerques tu dinero que se lo lleva", r);

        try {
            GlobalRepository.getMascotas()
                    .crear(m1);
            GlobalRepository.getMascotas()
                    .crear(m2);
        } catch (AlreadyExist ignored) {
        }

        CommandHandler commands = new CommandHandler("App cuidando a Pancho");

        CommandFactory mascotaCommands = new CommandFactory("Comandos de para gestionar mascotas");
        mascotaCommands.addCommand("registrar-mascota", new RegistrarMascotaCommand());
        mascotaCommands.addCommand("registrar-exotico", new RegistrarMascotaExoticaCommand());
        mascotaCommands.addCommand("listar-mascota", new ListarMascotaCommand());
        commands.addCommand("mascota", mascotaCommands);

        CommandFactory usuarioCommands = new CommandFactory("Comandos de para gestionar usuarios");
        usuarioCommands.addCommand("registrar-responsable", new RegisterResponsableCommand());
        usuarioCommands.addCommand("registrar-cuidador", new RegisterCuidadorCommand());
        commands.addCommand("usuario", usuarioCommands);

        CommandFactory cuidadoCommand = new CommandFactory("Comandos de para gestionar cuidados");
        cuidadoCommand.addCommand("registrar", new RegistrarCuidadoCommand());
        commands.addCommand("cuidado", cuidadoCommand);

        Scanner scanner = new Scanner(System.in);
        boolean finish = false;
        System.out.println("Cuidando a Pancho\n");
        do {
            System.out.print("cp> ");

            String input = scanner.nextLine();
            ArrayList<String> arg = new ArrayList<>(Arrays.asList(input.split(" ")));

            String command = arg.get(0);
            if (command.equals("help")) {
                arg.remove(0);
                commands.getHelp(arg, "");
            }
            else {
                finish = command.equals("exit");
                Command c = commands.getCommand(arg);
                if (c != null) c.exec();
            }

            System.out.println();

        } while (!finish);

        scanner.close();
    }

}
