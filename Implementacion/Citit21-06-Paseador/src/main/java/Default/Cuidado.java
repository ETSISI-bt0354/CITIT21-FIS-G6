package Default;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cuidado {
    private LocalDateTime fechaCuidado;
    private Duration duracion;
    private int id;

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
}
