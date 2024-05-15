package Vista;

import Modelo.Cuidador;
import Modelo.ICuidado;
import Modelo.Mascota;
import java.time.Duration;
import java.time.LocalDateTime;

public class VistaCuidado {
    public void CuidadoCreado(ICuidado cuidado) {
        StringBuilder message = new StringBuilder();
        message.append("Cuidado creado con exito\n");

        System.out.println(message);
    }
}
