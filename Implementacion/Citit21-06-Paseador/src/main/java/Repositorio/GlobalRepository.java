package Repositorio;

import Modelo.*;
import Serializers.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GlobalRepository {
    private static GlobalRepository instance = null;
    private final Repository<Responsable> responsables;
    private final Repository<Cuidador> cuidadores;
    private final Repository<Mascota> mascotas;
    private final Repository<Exotico> exoticos;
    private final Repository<Cuidado> cuidados;

    private GlobalRepository() {
        Path currentPath = Paths.get("").toAbsolutePath().resolve("repositorio");

        try {
            this.responsables = new Repository<>(new FileRepository<>(new SerializerXMLResponsable(), currentPath.resolve("responsables")));
            this.cuidadores = new Repository<>(new FileRepository<>(new SerializerXMLCuidador(), currentPath.resolve("cuidadores")));
            this.mascotas = new Repository<>(new FileRepository<>(new SerializerXMLMascota(this.responsables), currentPath.resolve("mascotas")));
            this.exoticos = new Repository<>(new FileRepository<>(new SerializerXMLExotico(this.responsables), currentPath.resolve("exoticos")));
            this.cuidados = new Repository<>(new FileRepository<>(new SerializerXMLCuidado(this.cuidadores, this.mascotas), currentPath.resolve("cuidados")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static GlobalRepository getInstance() {
        if (instance == null) {
            instance = new GlobalRepository();
        }

        return instance;
    }

    public static IRepository<Responsable> getResponsables() {
        return getInstance().responsables;
    }

    public static IRepository<Cuidador> getCuidadores() {
        return getInstance().cuidadores;
    }

    public static IRepository<Mascota> getMascotas() {
        return getInstance().mascotas;
    }

    public static IRepository<Exotico> getExoticos() {
        return getInstance().exoticos;
    }

    public static IRepository<Cuidado> getCuidados() {
        return getInstance().cuidados;
    }
}
