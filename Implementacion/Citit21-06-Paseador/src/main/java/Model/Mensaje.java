package Model;

import java.time.LocalDateTime;

public class Mensaje {
    private String contenido;
    private LocalDateTime timestamp;
    private int id;

    public Mensaje(String contenido, LocalDateTime timestamp, int id) {
        this.contenido = contenido;
        this.timestamp = timestamp;
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }
    
}
