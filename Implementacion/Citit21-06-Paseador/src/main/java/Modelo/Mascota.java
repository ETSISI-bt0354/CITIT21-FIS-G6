package Modelo;

import java.util.List;

public class Mascota {
    private String nombre;
    private int codigoPostal;
    private String descripcion;
    private List<Foto> foto;
    private Perfil perfil;

    public Mascota(String nombre, int codigoPostal, String descripcion) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFoto(List<Foto> foto) {
        this.foto = foto;
    }
    public List<Foto> getFoto() {
        return foto;
    }
    public void addFoto(Foto foto) {
        this.foto.add(foto);
    }
    public void removeFoto(Foto foto) {
        this.foto.remove(foto);
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Perfil getPerfil() {
        return perfil;
    }


}
