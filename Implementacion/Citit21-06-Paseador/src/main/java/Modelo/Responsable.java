package Modelo;

import java.util.List;

public class Responsable extends Usuario{

    private List<Mascota> Mascota;

    public Responsable(int id, TPlataforma plataforma, String nombre) {
        super(id, plataforma, nombre);
    }

    public List<Mascota> getMascota() {
        return Mascota;
    }

    public void setMascota(List<Mascota> mascota) {
        Mascota = mascota;
    }

    public void addMascota (Mascota mascota) {
        Mascota.add(mascota);
    }

    public void eliminarMascota (Mascota mascota) {
        Mascota.remove(mascota);
    }
}
