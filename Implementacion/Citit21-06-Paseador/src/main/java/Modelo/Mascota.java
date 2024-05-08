package Modelo;

import java.util.List;

public class Mascota implements IMascota {
    private String nombre;
    private int codigoPostal;
    private String descripcion;
    private List<Foto> fotos;
    private Perfil perfil;
    private List<Cuidado> cuidados;

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

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
    public List<Foto> getFotos() {
        return fotos;
    }

    public void addFotos(Foto foto) {
        this.fotos.add(foto);
    }

    public void removeFotos(Foto foto) {
        this.fotos.remove(foto);
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setCuidados(List<Cuidado> cuidados) {
        this.cuidados = cuidados;
    }
    public List<Cuidado> getCuidados() {
        return cuidados;
    }
    public void addCuidado(Cuidado cuidado) {
        this.cuidados.add(cuidado);
    }
    public void removeCuidado(Cuidado cuidado) {
        this.cuidados.remove(cuidado);
    }

}
