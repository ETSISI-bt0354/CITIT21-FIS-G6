package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {

    @org.junit.jupiter.api.Test
    void creatingNewEntityAddsItToFileRepository() throws IOException, AlreadyExist, NotFound {
        Mock mock = new Mock(1, "tomatoe");
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        repo.crear(mock);
        assertEquals(mock.getId(), repo.obtener(1).getId());
    }

    @org.junit.jupiter.api.Test
    void creatingDuplicateEntity() throws IOException, AlreadyExist, NotFound {
        Mock mock = new Mock(1, "tomatoe");
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        repo.crear(mock);
        assertThrows(AlreadyExist.class, () -> repo.crear(mock));
    }

    @org.junit.jupiter.api.Test
    void updatingEntity() throws IOException, AlreadyExist, NotFound {
        Mock mock = new Mock(1, "tomatoe");
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        repo.crear(mock);
        mock.setTomatoe("potatoe");
        repo.actualizar(mock);
        Mock updated = (Mock) repo.obtener(1);
        assertEquals(mock.getTomatoe(), updated.getTomatoe());
    }

    @org.junit.jupiter.api.Test
    void deletingEntity() throws IOException, AlreadyExist, NotFound {
        Mock mock = new Mock(1, "tomatoe");
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        repo.crear(mock);
        repo.eliminar(mock);
        assertThrows(NotFound.class, () -> repo.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void updatingNonExistentEntityThrowsException() throws IOException {
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        assertThrows(NotFound.class, () -> repo.actualizar(new Mock(1)));
    }

    @org.junit.jupiter.api.Test
    void deletingNonExistentEntityThrowsException() throws IOException {
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        assertThrows(NotFound.class, () -> repo.eliminar(new Mock(1)));
    }

    @org.junit.jupiter.api.Test
    void obtainingNonExistentEntityThrowsException() throws IOException {
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        assertThrows(NotFound.class, () -> repo.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void obtainingExistentEntity() throws IOException, AlreadyExist, NotFound {
        Mock mock = new Mock(1, "tomatoe");
        FileRepository<Mock> fileRepository = new FileRepository<Mock>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Repository repo = new Repository<Mock>(fileRepository);
        repo.crear(mock);
        assertEquals(mock.getId(), repo.obtener(1).getId());
    }
}