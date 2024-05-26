package Repositorio;

import Excepciones.AlreadyExist;
import Excepciones.NotFound;
import Modelo.Id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryRepositoryTest {

    @org.junit.jupiter.api.Test
    void creatingNewEntityAddsItToRepository() throws AlreadyExist {
        InMemoryRepository<Mock> repository = new InMemoryRepository<>();
        Mock mock = new Mock(1);
        Mock mock2 = new Mock(1);
        repository.crear(mock);
        assertThrows(AlreadyExist.class, () -> repository.crear(mock2));
    }

    @org.junit.jupiter.api.Test
    void updatingExistentEntity() throws AlreadyExist, NotFound {
        InMemoryRepository<Mock> repository = new InMemoryRepository<>();
        Mock mock = new Mock(1);
        repository.crear(mock);
        Mock mock2 = new Mock(2);
        repository.actualizar(mock2);
        assertEquals(mock2, repository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void obtainingExistentEntity() throws AlreadyExist, NotFound {
        InMemoryRepository<Mock> repository = new InMemoryRepository<>();
        Mock mock = new Mock(1);
        repository.crear(mock);
        assertEquals(mock, repository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void obtainingNonExistentEntityThrowsException() {
        InMemoryRepository<Id> repository = new InMemoryRepository<>();
        assertThrows(NotFound.class, () -> repository.obtener(1));
    }

    @org.junit.jupiter.api.Test
    void updatingNonExistentEntityThrowsException() {
        InMemoryRepository<Id> repository = new InMemoryRepository<>();
        assertThrows(NotFound.class, () -> repository.actualizar(new Mock(1)));

    }

    @org.junit.jupiter.api.Test
    void deletingNonExistentEntityThrowsException() {
        InMemoryRepository<Id> repository = new InMemoryRepository<>();
        assertThrows(NotFound.class, () -> repository.eliminar(new Mock(1)));
    }
}