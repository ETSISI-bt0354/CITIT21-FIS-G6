package Modelo;

import java.nio.file.Path;

public class Documentacion {
    private final int id;
    private Path documentos;
    private Cuidador cuidador;
    public Documentacion(int id, Path documentos) {
        this.id = id;
        this.documentos = documentos;
    }

    public int getId() {
        return id;
    }

    public Path getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Path documentos) {
        this.documentos = documentos;
    }
    public Cuidador getCuidador() {
        return cuidador;
    }
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
}
