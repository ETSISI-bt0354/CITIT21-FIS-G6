package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Cuidador extends Usuario {
  private int panchoPuntos;
  private String descripcion;
  private double tarifa;
  private LocalDateTime horario;
  private List<Documentacion> documentosAportados;
  private List<Cuidado> cuidados;
  private List<Premio> premiosCanjeados;
  private List<Mascota> mascotasFavoritas;

  public Cuidador(int panchoPuntos, String descripcion, double tarifa, LocalDateTime horario,
				  String nombre, int id, TPlataforma plataforma) {
	super(id, plataforma, nombre);
	this.panchoPuntos = panchoPuntos;
	this.descripcion  = descripcion;
	this.tarifa		  = tarifa;
	this.horario	  = horario;
  }

  public int getPanchoPuntos() { return panchoPuntos; }

  public void setPanchoPuntos(int panchoPuntos) { this.panchoPuntos = panchoPuntos; }

  public String getDescripcion() { return descripcion; }

  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  public double getTarifa() { return tarifa; }

  public void setTarifa(double tarifa) { this.tarifa = tarifa; }

  public LocalDateTime getHorario() { return horario; }

  public void setHorario(LocalDateTime horario) { this.horario = horario; }

  public List<Documentacion> getDocumentosAportados() { return documentosAportados; }

  public void setDocumentosAportados(List<Documentacion> documentosAportados) {
	this.documentosAportados = documentosAportados;
  }

  public void addDocumentosAportados(Documentacion documentacion) {
	documentosAportados.add(documentacion);
  }

  public void removeMensajeEnviado(Documentacion documentacion) {
	documentosAportados.remove(documentacion);
  }

  public void setCuidados(List<Cuidado> cuidados) { this.cuidados = cuidados; }

  public List<Cuidado> getCuidados() { return cuidados; }

  public void addCuidado(Cuidado cuidado) { cuidados.add(cuidado); }

  public void removeCuidado(Cuidado cuidado) { cuidados.remove(cuidado); }

  public void setPremiosCanjeados(List<Premio> premiosCanjeados) {
	this.premiosCanjeados = premiosCanjeados;
  }

  public List<Premio> getPremiosCanjeados() { return premiosCanjeados; }

  public void addPremioCanjeado(Premio premio) { this.premiosCanjeados.add(premio); }

  public void removePremioCanjeado(Premio premio) { premiosCanjeados.remove(premio); }

  public List<Mascota> getMascotasFavoritas() { return mascotasFavoritas; }

  public void setMascotasFavoritas(List<Mascota> mascotasFavoritas) {
	this.mascotasFavoritas = mascotasFavoritas;
  }

  public void addMascotaFavorita(Mascota mascota) { this.mascotasFavoritas.add(mascota); }

  public void removeMascotaFavorita(Mascota mascota) { this.mascotasFavoritas.remove(mascota); }
}
