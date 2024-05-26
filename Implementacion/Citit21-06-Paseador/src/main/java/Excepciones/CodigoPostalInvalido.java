package Excepciones;

public class CodigoPostalInvalido extends Exception {
    private final String codigoPostal;

    public CodigoPostalInvalido(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}
