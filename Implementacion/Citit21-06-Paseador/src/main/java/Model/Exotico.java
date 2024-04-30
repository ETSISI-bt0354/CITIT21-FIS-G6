package Model;

import java.nio.file.Path;

public class Exotico {
    private Path permiso;
    private Path certificadoLegal;
    private Path certificadoSalud;

    public Exotico(Path permiso, Path certificadoLegal, Path certificadoSalud) {
        this.permiso = permiso;
        this.certificadoLegal = certificadoLegal;
        this.certificadoSalud = certificadoSalud;
    }

    public Path getPermiso() {
        return permiso;
    }
    public void setPermiso(Path permiso) {
        this.permiso = permiso;
    }
    public Path getCertificadoLegal() {
        return certificadoLegal;
    }
    public void setCertificadoLegal(Path certificadoLegal) {
        this.certificadoLegal = certificadoLegal;
    }
    public Path getCertificadoSalud() {
        return certificadoSalud;
    }
    public void setCertificadoSalud(Path certificadoSalud) {
        this.certificadoSalud = certificadoSalud;
    }


}
