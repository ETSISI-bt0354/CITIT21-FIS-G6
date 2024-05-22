package Repositorio;

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

    public void crear(T t) throws IOException {
        Path archivo = getPathFromId(t.getId());
        Files.write(archivo, serializer.serialize(t)
                .getBytes());
    }

    public T obtener(int id) throws IOException {
        Path archivo = getPathFromId(id);
        byte[] contenido = Files.readAllBytes(archivo);

        return serializer.deserialize(new String(contenido));

    }

    public Stream<T> obtenerTodos() throws IOException {
        try (Stream<Path> stream = Files.list(repo)) {
            return stream
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
    }

    public void actualizar(T t) throws IOException {
        crear(t);
    }

    public void eliminar(T t) throws IOException {
        Path archivo = getPathFromId(t.getId());
        Files.delete(archivo);
    }

    private Path getPathFromId(int id) {
        return repo.resolve(String.valueOf(id));
    }
}
