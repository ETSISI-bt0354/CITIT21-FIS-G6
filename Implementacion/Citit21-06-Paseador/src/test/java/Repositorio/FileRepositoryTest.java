package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileRepositoryTest {

    @org.junit.jupiter.api.Test
    void creatingNewEntityAddsItToFileRepository() throws AlreadyExist, IOException, NotFound {
        FileRepository<Mock> fileRepository = new FileRepository<>(new SerializerXMLMock(), Files.createTempDirectory("mocks"));
        Mock mock = new Mock(1, "dsfdsfsd");
        fileRepository.crear(mock);
        assertEquals(mock, fileRepository.obtener(1));
    }
}