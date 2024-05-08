package Modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cuidado {
    private LocalDateTime fechaCuidado;
    private Duration duracion;
    private int id;
    private Pago pago;
    private Mensaje mensaje;
    private Cuidador cuidador;

    public Cuidado(LocalDateTime fechaCuidado, Duration duracion, int id) {
        this.fechaCuidado = fechaCuidado;
        this.duracion = duracion;
        this.id = id;
    }
    public LocalDateTime getFechaCuidado() {
        return fechaCuidado;
    }
    public void setFechaCuidado(LocalDateTime fechaCuidado) {
        this.fechaCuidado = fechaCuidado;
    }
    public Duration getDuracion() {
        return duracion;
    }
    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }
    public int getId() {
        return id;
    }
    public void setPago(Pago pago) {
        this.pago = pago;
    }
    public Pago getPago() {
        return pago;
    }
    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    public Mensaje getMensaje() {
        return mensaje;
    }
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
    public Cuidador getCuidador() {
        return cuidador;
    }
}
