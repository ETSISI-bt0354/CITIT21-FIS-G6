package Excepciones;

public class TarifaInvalida extends Exception {
    private final String tarifa;

    public TarifaInvalida(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getTarifa() {
        return tarifa;
    }
}
