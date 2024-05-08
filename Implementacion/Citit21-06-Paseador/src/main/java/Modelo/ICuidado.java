package Modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public interface ICuidado {
    LocalDateTime getFechaCuidado();
    Duration getDuracion();
    Mascota getMascota();
    Cuidador getCuidador();
}
