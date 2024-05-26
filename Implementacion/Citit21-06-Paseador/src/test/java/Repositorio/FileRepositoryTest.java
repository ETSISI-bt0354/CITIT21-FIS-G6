package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;
import Modelo.Id;
import Serializers.Serializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileRepositoryTest {

    @org.junit.jupiter.api.Test
    void creatingNewEntityAddsItToFileRepository() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new MockSerializer(), Files.createTempDirectory("test"));
    }

    @org.junit.jupiter.api.Test
    void creatingExistingEntityThrowsException() throws AlreadyExist, IOException {
        Serializer<Id> mockSerializer = mock(Serializer.class);
        Id mockId = mock(Id.class);
        when(mockId.getId()).thenReturn(1);
        when(mockSerializer.serialize(mockId)).thenReturn("Serialized Data");
        Path tempDir = Files.createTempDirectory("test");
        FileRepository<Id> fileRepository = new FileRepository<>(mockSerializer, tempDir);
        fileRepository.crear(mockId);
        assertThrows(AlreadyExist.class, () -> fileRepository.crear(mockId));
    }

    @org.junit.jupiter.api.Test
    void obtainingNonExistentEntityThrowsException() throws IOException {
        Serializer<Id> mockSerializer = mock(Serializer.class);
        Path tempDir = Files.createTempDirectory("test");
        FileRepository<Id> fileRepository = new FileRepository<>(mockSerializer, tempDir);
        assertThrows(NotFound.class, () -> fileRepository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void updatingNonExistentEntityThrowsException() throws IOException {
        Serializer<Id> mockSerializer = mock(Serializer.class);
        Id mockId = mock(Id.class);
        when(mockId.getId()).thenReturn(1);
        Path tempDir = Files.createTempDirectory("test");
        FileRepository<Id> fileRepository = new FileRepository<>(mockSerializer, tempDir);
        assertThrows(NotFound.class, () -> fileRepository.actualizar(mockId));
    }

    @org.junit.jupiter.api.Test
    void deletingNonExistentEntityThrowsException() throws IOException {
        Serializer<Id> mockSerializer = mock(Serializer.class);
        Id mockId = mock(Id.class);
        when(mockId.getId()).thenReturn(1);
        Path tempDir = Files.createTempDirectory("test");
        FileRepository<Id> fileRepository = new FileRepository<>(mockSerializer, tempDir);
        assertThrows(NotFound.class, () -> fileRepository.eliminar(mockId));
    }
}