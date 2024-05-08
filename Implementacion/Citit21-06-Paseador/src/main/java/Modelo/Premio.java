package Modelo;

public abstract class Premio {
    private int id;
    private double precioPanchoPuntos;

    public int getId() {
        return id;
    }
    public Premio(int id, double precioPanchoPuntos) {
        this.id = id;
        this.precioPanchoPuntos = precioPanchoPuntos;
    }
    public double getprecioPanchoPuntos() {
        return precioPanchoPuntos;
    }
    public void setPrecioPanchoPuntos(double precioPanchoPuntos) {
        this.precioPanchoPuntos = precioPanchoPuntos;
    }
}
