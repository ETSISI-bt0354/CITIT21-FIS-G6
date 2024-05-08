package Modelo;

import java.util.List;

public class Responsable extends Usuario{

    private List<Mascota> mascotas;
    private List<Cuidador> cuidadores;

    public Responsable(int id, TPlataforma plataforma, String nombre) {
        super(id, plataforma, nombre);
    }
    public List<Mascota> getMascotas() {
        return mascotas;
    }
    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    public void addMascotas (Mascota mascota) {
        mascotas.add(mascota);
    }
    public void eliminarMascota (Mascota mascota) {
        mascotas.remove(mascota);
    }

    public void setCuidadores(List<Cuidador> cuidadores) {
        this.cuidadores = cuidadores;
    }
    public List<Cuidador> getCuidadores() {
        return cuidadores;
    }
    public void addCuidadores (Cuidador cuidador) {
        cuidadores.add(cuidador);
    }
    public void removeCuidadores (Cuidador cuidador) {
        cuidadores.remove(cuidador);
    }
}
