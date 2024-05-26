package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;
import Modelo.Id;
import Serializers.Serializer;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileRepository<T extends Id> {
    private final Serializer<T> serializer;
    private final Path repo;

    public FileRepository(Serializer<T> serializer, Path directorio) throws IOException {
        this.serializer = serializer;
        repo = Files.createDirectories(directorio);
    }

    public void crear(T t) throws IOException, AlreadyExist {
        Path archivo = getPathFromId(t.getId());
        if (Files.exists(archivo)) {
            throw new AlreadyExist(t.getId());
        }

        Files.write(archivo, serializer.serialize(t)
                .getBytes());
    }

    public T obtener(int id) throws IOException, NotFound {
        Path archivo = getPathFromId(id);
        if (!Files.exists(archivo)) {
            throw new NotFound(id);
        }

        byte[] contenido = Files.readAllBytes(archivo);

        return serializer.deserialize(new String(contenido));

    }

    public Stream<T> obtenerTodos() throws IOException {
        return Files.list(repo)
                    .map(archivo -> {
                        try {
                            return Files.readAllBytes(archivo);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    })
                    .map(String::new)
                    .map(serializer::deserialize);
    }

    public void actualizar(T t) throws IOException, NotFound {
        Path archivo = getPathFromId(t.getId());
        if (!Files.deleteIfExists(archivo)) {
            throw new NotFound(t.getId());
        }

        try {
            crear(t);
        } catch (AlreadyExist ignored) {}
    }

    public void eliminar(T t) throws IOException, NotFound {
        Path archivo = getPathFromId(t.getId());
        if (!Files.deleteIfExists(archivo)) {
            throw new NotFound(t.getId());
        }
    }

    private Path getPathFromId(int id) {
        return repo.resolve(String.valueOf(id));
    }
}
