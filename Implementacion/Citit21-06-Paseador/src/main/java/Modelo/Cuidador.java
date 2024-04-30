package Modelo;

import java.time.LocalDateTime;

public class Cuidador extends Usuario{
    private int panchoPuntos;
    private String descripcion;
    private double tarifa;
    private LocalDateTime horario;

    public Cuidador(int panchoPuntos, String descripcion, double tarifa, LocalDateTime horario) {
        this.panchoPuntos = panchoPuntos;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
        this.horario = horario;
    }

    public int getPanchoPuntos() {
        return panchoPuntos;
    }

    public void setPanchoPuntos(int panchoPuntos) {
        this.panchoPuntos = panchoPuntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

}
