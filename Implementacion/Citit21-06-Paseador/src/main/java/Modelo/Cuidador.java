package Modelo;

import jdk.javadoc.internal.doclets.toolkit.taglets.UserTaglet;

import java.time.LocalDateTime;
import java.util.Set;

public class Cuidador extends Usuario{
    private int panchoPuntos;
    private String descripcion;
    private double tarifa;
    private LocalDateTime horario;
    private Set<Documentacion> documentosAportados;

    public Cuidador(int panchoPuntos, String descripcion, double tarifa, LocalDateTime horario, String nombre, int id, TPlataforma plataforma) {
        super(id, plataforma, nombre);
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

    public Set<Documentacion> getDocumentosAportados() {
        return documentosAportados;
    }

    public void setDocumentosAportados(Set<Documentacion> documentosAportados) {
        this.documentosAportados = documentosAportados;
    }

    public void addDocumentosAportados(Documentacion documentacion){
        documentosAportados.add(documentacion);
    }

    public void removeMensajeEnviado(Documentacion documentacion){
        documentosAportados.remove(documentacion);
    }
}
