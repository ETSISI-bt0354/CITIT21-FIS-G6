package Excepciones;

public class CampoNoExistente extends Exception {
    private final String campo;

    public CampoNoExistente(String field) {
        this.campo = field;
    }

    public String getCampo() {
        return campo;
    }
}
