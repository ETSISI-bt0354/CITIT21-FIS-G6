package Repositorio;

import Modelo.Id;

public class Mock implements Id {
    private final int id;
    private String tomatoe;

    public Mock(int id) {
        this.id = id;
    }

    public Mock(int id, String tomatoe) {
        this.id = id;
        this.tomatoe = tomatoe;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getTomatoe() {
        return tomatoe;
    }

    public void setTomatoe(String tomatoe) {
        this.tomatoe = tomatoe;
    }
}
