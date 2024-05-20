package Modelo;

import java.nio.file.Path;

public class Documentacion {
    private final int id;
    private Path documentos;

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
}
