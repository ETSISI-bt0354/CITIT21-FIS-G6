package Excepciones;

public class PlataformaInvalida extends Exception {
    private final String plataforma;

    public PlataformaInvalida(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
