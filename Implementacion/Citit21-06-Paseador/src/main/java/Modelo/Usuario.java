package Modelo;

public class Usuario {
    private int id;
    private String nombre;
    private TPlataforma plataforma;

    public Usuario(int id, TPlataforma plataforma, String nombre)
    {
        this.id = id;
        this.plataforma = plataforma;
        this.nombre = nombre;
    }

    public int getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public TPlataforma getPlataforma()
    {
        return plataforma;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
