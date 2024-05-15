package Modelo;

import java.time.LocalDateTime;

public class Promocion extends Premio {

  private LocalDateTime fechalimite;

  public Promocion(int id, double precioPanchoPuntos, LocalDateTime fechalimite) {
	super(id, precioPanchoPuntos);
	this.fechalimite = fechalimite;
  }
  public LocalDateTime getFechalimite() { return fechalimite; }
  public void setFechalimite(LocalDateTime fechalimite) { this.fechalimite = fechalimite; }

  public LocalDateTime calcularFechaInicio() { return fechalimite; }
}
