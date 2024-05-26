package Vista;

import Modelo.Responsable;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VistaUsuarioTest extends TestCase {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @org.junit.jupiter.api.Test
    void usuarioCreadoReturnsExpectedMessage() {
        Responsable mockUser = new Responsable(1, "codigoPlataforma", null, "nombre");
        new VistaUsuario().usuarioCreado(mockUser);
        assertEquals("Usuario creado con exito", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void campoNoExistentePrintsExpectedMessage() {
        new VistaUsuario().campoNoExistente("test");
        assertEquals("El campo test no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void plataformaInvalidaPrintsExpectedMessage() {
        new VistaUsuario().plataformaInvalida("test");
        assertEquals("La plataforma test no está soportada", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void tarifaInvalidaPrintsExpectedMessage() {
        new VistaUsuario().tarifaInvalida("test");
        assertEquals("test no es una tarifa válida", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void horarioInvalidoPrintsExpectedMessage() {
        new VistaUsuario().horarioInvalido("test");
        assertEquals("test no es un horario válido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void usuarioExistentePrintsExpectedMessage() {
        new VistaUsuario().usuarioExistente();
        assertEquals("El responsable ya ha sido registrado anteriormente", outputStreamCaptor.toString().trim());
    }
}