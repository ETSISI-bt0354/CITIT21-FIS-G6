package Modelo;

import java.nio.file.Path;

public class Foto {

    private Path foto;
    private boolean esPrincipal;

    public Foto(Path foto, boolean esPrincipal) {}

    public Path getFoto() {
        return foto;
    }

    public void setFoto(Path foto) {
        this.foto = foto;
    }
    public boolean getEsPrincipal() {
        return esPrincipal;
    }
    public void setEsPrincipal(boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }
}
