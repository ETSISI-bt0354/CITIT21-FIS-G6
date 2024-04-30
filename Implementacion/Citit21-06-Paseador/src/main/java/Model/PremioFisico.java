package Model;

public class PremioFisico extends Premio{
    private String descripcion;

    public PremioFisico(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
