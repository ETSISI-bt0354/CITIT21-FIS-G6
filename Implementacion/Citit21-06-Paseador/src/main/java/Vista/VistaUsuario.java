package Vista;

import Modelo.IUsuario;
import Modelo.TPlataforma;

public class VistaUsuario implements IUsuario
{
    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public TPlataforma getPlataforma() {
        return null;
    }
}
