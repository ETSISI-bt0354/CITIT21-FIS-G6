package Controlador;

import Excepciones.PlataformaInvalida;
import Excepciones.TarifaInvalida;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControladorUsuarioTest {

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