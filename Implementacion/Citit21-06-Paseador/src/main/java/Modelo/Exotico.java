package Modelo;

import java.nio.file.Path;

public class Exotico extends Mascota {
  private Path permiso;
  private Path certificadoLegal;
  private Path certificadoSalud;

  public Exotico(int id, String nombre, int codigoPostal, String descripcion,
		 Responsable responsable, Path permiso, Path certificadoLegal,
		 Path certificadoSalud) {
    super(id, nombre, codigoPostal, descripcion, responsable);
    this.permiso	  = permiso;
    this.certificadoLegal = certificadoLegal;
    this.certificadoSalud = certificadoSalud;
  }

  public Path getPermiso() { return permiso; }
  public void setPermiso(Path permiso) { this.permiso = permiso; }
  public Path getCertificadoLegal() { return certificadoLegal; }
  public void setCertificadoLegal(Path certificadoLegal) {
    this.certificadoLegal = certificadoLegal;
  }
  public Path getCertificadoSalud() { return certificadoSalud; }
  public void setCertificadoSalud(Path certificadoSalud) {
    this.certificadoSalud = certificadoSalud;
  }
}
