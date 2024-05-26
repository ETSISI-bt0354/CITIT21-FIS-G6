package Modelo;

import java.util.List;

public abstract class Usuario implements Id, IUsuario {
    private final int id;
    private final String codigoPlatafoma;
    private String nombre;
    private final TPlataforma plataforma;
    private List<Mensaje> mensajesRecibidos;
    private List<Mensaje> mensajesEnviados;

    public Usuario(int id, String codigoPlatafoma, TPlataforma plataforma, String nombre) {
        this.id = id;
        this.codigoPlatafoma = codigoPlatafoma;
        this.plataforma = plataforma;
        this.nombre = nombre;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getCodigoPlatafoma() {
        return codigoPlatafoma;
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
