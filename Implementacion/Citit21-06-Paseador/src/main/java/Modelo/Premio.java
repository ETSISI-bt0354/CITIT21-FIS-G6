package Modelo;

public abstract class Premio {
    private final int id;
    private double precioPanchoPuntos;
    private Cuidador cuidador;

    public int getId() {
        return id;
    }
    public Premio(int id, double precioPanchoPuntos) {
        this.id = id;
        this.precioPanchoPuntos = precioPanchoPuntos;
    }
    public Cuidador getCuidador(){
        return cuidador;
    }
    public void setCuidador(Cuidador cuidador){
        this.cuidador = cuidador;
    }
    public double getprecioPanchoPuntos() {
        return precioPanchoPuntos;
    }
    public void setPrecioPanchoPuntos(double precioPanchoPuntos) {
        this.precioPanchoPuntos = precioPanchoPuntos;
    }
}
