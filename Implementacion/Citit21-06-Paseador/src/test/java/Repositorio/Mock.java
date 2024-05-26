package Repositorio;

import Modelo.Id;

public class Mock implements Id {
    private final int id;

    public Mock(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return 0;
    }
}
