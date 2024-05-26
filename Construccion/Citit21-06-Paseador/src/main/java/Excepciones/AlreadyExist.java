package Excepciones;

public class AlreadyExist extends Exception {
    private final int entityId;

    public AlreadyExist(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() {
        return entityId;
    }
}
