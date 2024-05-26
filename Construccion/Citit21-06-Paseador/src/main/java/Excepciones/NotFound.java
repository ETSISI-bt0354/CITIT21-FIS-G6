package Excepciones;

public class NotFound extends Exception {
    private final int entityId;

    public NotFound(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() {
        return entityId;
    }
}
