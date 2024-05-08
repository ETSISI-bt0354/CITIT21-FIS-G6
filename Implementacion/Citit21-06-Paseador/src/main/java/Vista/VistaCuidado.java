package Vista;

import Modelo.Cuidador;
import Modelo.ICuidado;
import Modelo.Mascota;

import java.time.Duration;
import java.time.LocalDateTime;

public class VistaCuidado implements ICuidado
{

    @Override
    public LocalDateTime getFechaCuidado() {
        return null;
    }

    @Override
    public Duration getDuracion() {
        return null;
    }

    @Override
    public Mascota getMascota() {
        return null;
    }

    @Override
    public Cuidador getCuidador() {
        return null;
    }
}
