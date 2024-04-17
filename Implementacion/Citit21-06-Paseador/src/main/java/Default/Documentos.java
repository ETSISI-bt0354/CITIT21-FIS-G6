package Default;

import java.nio.file.Path;

public class Documentos {
    private int id;
    private Path documentos;

    public Documentos(int id, Path documentos) {
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
