package Excepciones;

public class FechaInvalida extends Exception {
    private final String fecha;

    public FechaInvalida(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
}
