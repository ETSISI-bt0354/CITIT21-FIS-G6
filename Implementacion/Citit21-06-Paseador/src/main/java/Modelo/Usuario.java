package Modelo;

import java.util.List;

public abstract class Usuario implements IUsuario {
    private final int id;
    private String nombre;
    private final TPlataforma plataforma;
    private List<Mensaje> mensajesRecibidos;
    private List<Mensaje> mensajesEnviados;

    public Usuario(int id, TPlataforma plataforma, String nombre) {
        this.id = id;
        this.plataforma = plataforma;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public TPlataforma getPlataforma() {
        return plataforma;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public void addMensajeEnviado(Mensaje mensaje) {
        mensajesEnviados.add(mensaje);
    }

    public void removeMensajeEnviado(Mensaje mensaje) {
        mensajesEnviados.remove(mensaje);
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public void addMensajeRecibido(Mensaje mensaje) {
        mensajesRecibidos.add(mensaje);
    }

    public void removeMensajeRecibido(Mensaje mensaje) {
        mensajesRecibidos.remove(mensaje);
    }

}
