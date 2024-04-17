package Default;

public class Mascota {
    private String nombre;
    private int codigoPostal;
    private String descripcion;

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


}
