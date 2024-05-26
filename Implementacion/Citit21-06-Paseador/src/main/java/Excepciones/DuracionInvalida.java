package Excepciones;

public class DuracionInvalida extends Exception {
    private final String duracion;

    public DuracionInvalida(String duracion) {
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }
}
