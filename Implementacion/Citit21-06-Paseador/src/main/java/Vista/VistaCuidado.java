package Vista;

import Modelo.ICuidado;

public class VistaCuidado {
  public void cuidadoCreado(ICuidado cuidado) {
    StringBuilder message = new StringBuilder();
    message.append("Cuidado creado con exito\n");

    System.out.println(message);
  }
}
