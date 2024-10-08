package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Responsable extends Usuario {

    private List<Mascota> mascotas;
    private List<Cuidador> cuidadoresFavoritos;

    public Responsable(int id, String codigoPlataforma, TPlataforma plataforma, String nombre) {
        super(id, codigoPlataforma, plataforma, nombre);
        this.mascotas = new ArrayList<>();
        this.cuidadoresFavoritos = new ArrayList<>();
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void addMascotas(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void eliminarMascota(Mascota mascota) {
        mascotas.remove(mascota);
    }

    public void setCuidadoresFavoritos(List<Cuidador> cuidadoresFavoritos) {
        this.cuidadoresFavoritos = cuidadoresFavoritos;
    }

    public List<Cuidador> getCuidadoresFavoritos() {
        return cuidadoresFavoritos;
    }

    public void addCuidadores(Cuidador cuidador) {
        cuidadoresFavoritos.add(cuidador);
    }

    public void removeCuidadores(Cuidador cuidador) {
        cuidadoresFavoritos.remove(cuidador);
    }
}
