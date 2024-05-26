package Excepciones;

public class HorarioInvalido extends Exception {
    private final String horario;

    public HorarioInvalido(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}
