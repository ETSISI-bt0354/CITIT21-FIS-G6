package Modelo;

public class Perfil {
  private int codigoRiac;
  private int numeroPoliza;

  public Perfil(int codigoRiac, int numeroPoliza) {
    this.codigoRiac = codigoRiac;
    this.numeroPoliza = numeroPoliza;
  }
  public int getCodigoRiac() { return codigoRiac; }
  public void setCodigoRiac(int codigoRiac) { this.codigoRiac = codigoRiac; }
  public int getNumeroPoliza() { return numeroPoliza; }
  public void setNumeroPoliza(int numeroPoliza) {
    this.numeroPoliza = numeroPoliza;
  }
}
