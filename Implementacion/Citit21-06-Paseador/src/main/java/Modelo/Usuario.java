package Modelo;

import java.util.Set;

public class Usuario {
    private int id;
    private String nombre;
    private TPlataforma plataforma;
    private Set<Mensaje> mensajesRecibidos;

    public Usuario(int id, TPlataforma plataforma, String nombre)
    {
        this.id = id;
        this.plataforma = plataforma;
        this.nombre = nombre;
    }

    public int getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public TPlataforma getPlataforma()
    {
        return plataforma;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    private Set<Mensaje> mensajesEnviados;

    public Set<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(Set<Mensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public void addMensajeEnviado(Mensaje mensaje){
        mensajesEnviados.add(mensaje);
    }

    public void removeMensajeEnviado(Mensaje mensaje){
        mensajesEnviados.remove(mensaje);
    }



    public Set<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }
    public void setMensajesRecibidos(Set<Mensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public void addMensajeRecibido(Mensaje mensaje){
        mensajesRecibidos.add(mensaje);
    }

    public void removeMensajeRecibido(Mensaje mensaje){
        mensajesRecibidos.remove(mensaje);
    }

}
