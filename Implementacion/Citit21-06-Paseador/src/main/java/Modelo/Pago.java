package Modelo;

public class Pago {
  private double cantidad;
  private int factura;
  private Cuidado cuidado;

  public Pago(double cantidad, int factura) {
	this.cantidad = cantidad;
	this.factura  = factura;
  }

  public double getCantidad() { return cantidad; }

  public void setCantidad(double cantidad) { this.cantidad = cantidad; }

  public int getFactura() { return factura; }

  public void setFactura(int factura) { this.factura = factura; }

  public Cuidado getCuidado() { return cuidado; }
  public void setCuidado(Cuidado cuidado) { this.cuidado = cuidado; }
}
