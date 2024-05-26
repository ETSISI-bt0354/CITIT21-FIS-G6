package Excepciones;

public class IdInvalido extends Exception {
    private final String id;

    public IdInvalido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
