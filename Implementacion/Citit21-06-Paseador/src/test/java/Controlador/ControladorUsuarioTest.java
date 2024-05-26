package Controlador;

import Excepciones.PlataformaInvalida;
import Excepciones.TarifaInvalida;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControladorUsuarioTest extends TestCase {

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
    void registeringResponsableWithValidParamsCreatesResponsable() {
        HashMap<String, String> params = new HashMap<>();
        params.put("nombre", "John Doe");
        params.put("plataforma", "FACEBOOK");
        ControladorUsuario.getInstance().registrarResponsable(params);
        assertDoesNotThrow(() -> ControladorUsuario.getInstance().obtenerResponsable(1));
    }

    @org.junit.jupiter.api.Test
    void registeringResponsableWithInvalidPlatformThrowsException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("nombre", "John Doe");
        params.put("plataforma", "INVALID_PLATFORM");
        assertThrows(PlataformaInvalida.class, () -> ControladorUsuario.getInstance().registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void registeringCuidadorWithValidParamsCreatesCuidador() {
        HashMap<String, String> params = new HashMap<>();
        params.put("nombre", "Jane Doe");
        params.put("descripcion", "Experienced caregiver");
        params.put("tarifa", "20.0");
        params.put("horario", LocalDateTime.now().toString());
        params.put("plataforma", "FACEBOOK");
        ControladorUsuario.getInstance().registrarCuidador(params);
        assertDoesNotThrow(() -> ControladorUsuario.getInstance().obtenerCuidador(1));
    }

    @org.junit.jupiter.api.Test
    void registeringCuidadorWithInvalidTarifaThrowsException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("nombre", "Jane Doe");
        params.put("descripcion", "Experienced caregiver");
        params.put("tarifa", "invalid_tarifa");
        params.put("horario", LocalDateTime.now().toString());
        params.put("plataforma", "FACEBOOK");
        assertThrows(TarifaInvalida.class, () -> ControladorUsuario.getInstance().registrarCuidador(params));
    }
}