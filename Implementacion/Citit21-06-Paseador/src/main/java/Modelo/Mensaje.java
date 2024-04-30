package Modelo;

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

    public Usuario usuarioEmisor;

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Usuario usuarioReceptor;

    public Usuario getUsuarioReceptor() {
        return usuarioReceptor;
    }
    public void setUsuarioReceptor(Usuario usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    
}
