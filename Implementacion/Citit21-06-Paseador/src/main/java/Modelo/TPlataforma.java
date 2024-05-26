package Modelo;

public enum TPlataforma {
    TWITTER,
    FACEBOOK,
    GOOGLE,
    MICROSOFT;

    public static TPlataforma parse(String data) {
        return switch (data) {
            case "twitter" -> TPlataforma.TWITTER;
            case "facebook" -> TPlataforma.FACEBOOK;
            case "google" -> TPlataforma.GOOGLE;
            case "microsoft" -> TPlataforma.MICROSOFT;
            default -> throw new RuntimeException("Plataforma no valida.");
        };
    }

    public String toString() {
        return switch (this) {
            case TWITTER -> "Twitter";
            case FACEBOOK -> "Facebook";
            case GOOGLE -> "Google";
            case MICROSOFT -> "Microsoft";
        };
    }
}
