package Controlador;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
    void registrarResponsableWithValidParams() {
        HashMap<String, String> params = new HashMap<>();
        ControladorUsuario con = ControladorUsuario.getInstance();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("nombre", "nombre");
        assertDoesNotThrow(() -> con.registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void registrarResponsableWithInexistantName() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        controladorUsuario.registrarResponsable(params);
        assertEquals("El campo nombre no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarResponsableWithInvalidPlatform() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "INVALID");
        params.put("nombre", "nombre");
        controladorUsuario.registrarResponsable(params);
        assertEquals("La plataforma INVALID no está soportada", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarResponsableWithInexistantPlatform() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("nombre", "nombre");
        controladorUsuario.registrarResponsable(params);
        assertEquals("El campo plataforma no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithValidParams() {
        HashMap<String, String> params = new HashMap<>();
        ControladorUsuario con = ControladorUsuario.getInstance();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        assertDoesNotThrow(() -> con.registrarCuidador(params));
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInvalidTarifa() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("horario", "horario");
        params.put("nombre", "nombre");
        params.put("tarifa", "INVALID");
        controladorUsuario.registrarCuidador(params);
        assertEquals("INVALID no es una tarifa válida", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInexistantName() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("El campo nombre no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInvalidPlatform() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "INVALID");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("La plataforma INVALID no está soportada", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInvalidHorario() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("horario", "INVALID");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("INVALID no es un horario válido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInexistantDescripcion() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("El campo descripcion no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInexistantHorario() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("El campo horario no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void registrarCuidadorWithInexistantPlatform() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        controladorUsuario.registrarCuidador(params);
        assertEquals("El campo plataforma no ha sido introducido", outputStreamCaptor.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void pruebaResponsablePlatFacebook() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "FACEBOOK");
        params.put("nombre", "nombre");
        assertDoesNotThrow(() -> controladorUsuario.registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaResponsablePlatGoogle() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("nombre", "nombre");
        assertDoesNotThrow(() -> controladorUsuario.registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaResponsablePlatTwitter() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "TWITTER");
        params.put("nombre", "nombre");
        assertDoesNotThrow(() -> controladorUsuario.registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaResponsablePlatMicrosoft() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "MICROSOFT");
        params.put("nombre", "nombre");
        assertDoesNotThrow(() -> controladorUsuario.registrarResponsable(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaCuidadorPlatFacebook() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "FACEBOOK");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        assertDoesNotThrow(() -> controladorUsuario.registrarCuidador(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaCuidadorPlatGoogle() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "GOOGLE");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        assertDoesNotThrow(() -> controladorUsuario.registrarCuidador(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaCuidadorPlatTwitter() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "TWITTER");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        assertDoesNotThrow(() -> controladorUsuario.registrarCuidador(params));
    }

    @org.junit.jupiter.api.Test
    void pruebaCuidadorPlatMicrosoft() {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        HashMap<String, String> params = new HashMap<>();
        params.put("codigoPlataforma", "1");
        params.put("plataforma", "MICROSOFT");
        params.put("descripcion", "descripcion");
        params.put("horario", "1970-01-01T00:00:01");
        params.put("nombre", "nombre");
        params.put("tarifa", "1");
        assertDoesNotThrow(() -> controladorUsuario.registrarCuidador(params));
    }


}