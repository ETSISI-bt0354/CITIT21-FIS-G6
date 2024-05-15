package Modelo;

public abstract class Premio {
  private final int id;
  private double    precioPanchoPuntos;

  public Premio(int id, double precioPanchoPuntos) {
    this.id		    = id;
    this.precioPanchoPuntos = precioPanchoPuntos;
  }

  public int getId() { return id; }

  public double getprecioPanchoPuntos() { return precioPanchoPuntos; }
  public void	setPrecioPanchoPuntos(double precioPanchoPuntos) {
    this.precioPanchoPuntos = precioPanchoPuntos;
  }
}
