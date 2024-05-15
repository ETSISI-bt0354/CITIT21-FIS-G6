package Modelo;

public class PremioFisico extends Premio {
  private String descripcion;

  public PremioFisico(int id, double precioPanchoPuntos, String descripcion) {
    super(id, precioPanchoPuntos);
    this.descripcion = descripcion;
  }

  public String getDescripcion() { return descripcion; }
  public void	setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
