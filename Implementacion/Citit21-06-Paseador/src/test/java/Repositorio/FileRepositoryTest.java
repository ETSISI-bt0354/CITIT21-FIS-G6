package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileRepositoryTest {

    @org.junit.jupiter.api.Test
    void creatingNewEntityAddsItToFileRepository() throws AlreadyExist, IOException, NotFound {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        fileRepository.crear(mock);
        assertEquals(mock.getId(), fileRepository.obtener(1).getId());
    }

    @org.junit.jupiter.api.Test
    void updatingEntityUpdatesItInFileRepository() throws AlreadyExist, IOException, NotFound {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        fileRepository.crear(mock);
        mock.setTomatoe("new value");
        fileRepository.actualizar(mock);
        assertEquals(mock.getTomatoe(), fileRepository.obtener(1).getTomatoe());
    }

    @org.junit.jupiter.api.Test
    void gettingAllEntitiesReturnsAllEntities() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock1 = new Mock(1, "dsfdsfsd");
        Mock mock2 = new Mock(2, "dsfdsfsd");
        fileRepository.crear(mock1);
        fileRepository.crear(mock2);
        assertEquals(2, fileRepository.obtenerTodos().count());
    }

    @org.junit.jupiter.api.Test
    void deletingEntityRemovesItFromFileRepository() throws AlreadyExist, IOException, NotFound {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        fileRepository.crear(mock);
        fileRepository.eliminar(mock);
        assertThrows(NotFound.class, () -> fileRepository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void creatingSameEntityTwiceThrowsAlreadyExist() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        fileRepository.crear(mock);
        assertThrows(AlreadyExist.class, () -> fileRepository.crear(mock));
    }

    @org.junit.jupiter.api.Test
    void gettingNonExistentEntityThrowsNotFound() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        assertThrows(NotFound.class, () -> fileRepository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void updatingNonExistentEntityThrowsNotFound() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        assertThrows(NotFound.class, () -> fileRepository.actualizar(mock));
    }

    @org.junit.jupiter.api.Test
    void deletingNonExistentEntityThrowsNotFound() throws AlreadyExist, IOException {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        assertThrows(NotFound.class, () -> fileRepository.eliminar(mock));
    }
}