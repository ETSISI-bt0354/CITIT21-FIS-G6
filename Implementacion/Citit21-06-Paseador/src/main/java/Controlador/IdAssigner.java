package Controlador;

public class IdAssigner {
    private int id;

    public IdAssigner(int numberId) {
        id = numberId;
    }

    public int nextId() {
        return id++;
    }
}
