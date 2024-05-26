package Modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cuidado implements Id, ICuidado {
    private LocalDateTime fechaCuidado;
    private Duration duracion;
    private final int id;
    private Pago pago;
    private Mensaje mensaje;
    private Cuidador cuidador;
    private Mascota mascota;

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

    @Override
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
        if (this.cuidador != null) {
            this.cuidador.removeCuidado(this);
        }

        this.cuidador = cuidador;
        cuidador.addCuidado(this);
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setMascota(Mascota mascota) {
        if (this.mascota != null) {
            this.mascota.removeCuidado(this);
        }

        this.mascota = mascota;
        mascota.addCuidado(this);
    }

    public Mascota getMascota() {
        return mascota;
    }
}
