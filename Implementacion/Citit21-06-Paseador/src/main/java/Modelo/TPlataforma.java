package Modelo;

import Excepciones.PlataformaInvalida;

public enum TPlataforma {
    TWITTER,
    FACEBOOK,
    GOOGLE,
    MICROSOFT;

    public static TPlataforma parse(String data) throws PlataformaInvalida {
        return switch (data.toUpperCase()) {
            case "TWITTER" -> TPlataforma.TWITTER;
            case "FACEBOOK" -> TPlataforma.FACEBOOK;
            case "GOOGLE" -> TPlataforma.GOOGLE;
            case "MICROSOFT" -> TPlataforma.MICROSOFT;
            default -> throw new PlataformaInvalida(data);
        };
    }

    public String toString() {
        return switch (this) {
            case TWITTER -> "TWITTER";
            case FACEBOOK -> "FACEBOOK";
            case GOOGLE -> "GOOGLE";
            case MICROSOFT -> "MICROSOFT";
        };
    }
}
