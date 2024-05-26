package Controlador;

import java.util.OptionalInt;

public class LoginController {
    private static LoginController instance;

    private OptionalInt logInUser;

    private LoginController() {
        logInUser = OptionalInt.empty();
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }

        return instance;
    }

    public void setLogInUser(int logInUser) {
        this.logInUser = OptionalInt.of(logInUser);
    }

    public void logout() {
        logInUser = OptionalInt.empty();
    }

    public OptionalInt getLogInUser() {
        return logInUser;
    }
}
