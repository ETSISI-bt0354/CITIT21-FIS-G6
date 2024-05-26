package Serializers;

import Modelo.Cuidador;
import Modelo.TPlataforma;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializerXMLCuidadorTest {

    @org.junit.jupiter.api.Test
    void serializeFullCuidador() {
        Serializer ser = new SerializerXMLCuidador();
        LocalDateTime horario = LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.ofHours(0));
        Cuidador mock = new Cuidador(1, "descripcion", 1, horario, "nombre", 1, TPlataforma.FACEBOOK, "codPlat");
        String result = ser.serialize(mock);
        assertTrue(result.contains("<cuidador id=\"1\">"));
        assertTrue(result.contains("<nombre>nombre</nombre>"));
        assertTrue(result.contains("<descripcion>descripcion</descripcion>"));
        assertTrue(result.contains("<panchoPuntos>1</panchoPuntos>"));
        assertTrue(result.contains("<tarifa>1.0</tarifa>"));
        assertTrue(result.contains("<horario>1970-01-01T00:00:01.000000001</horario>"));
        assertTrue(result.contains("<plataforma>FACEBOOK</plataforma>"));
        assertTrue(result.contains("<codigoPlataforma>codPlat</codigoPlataforma>"));
    }

    @org.junit.jupiter.api.Test
    void deserializeFullCuidador() {
        Serializer ser = new SerializerXMLCuidador();
        String sauce = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><cuidador id=\"1\"><codigoPlataforma>codPlat</codigoPlataforma><nombre>nombre</nombre><descripcion>descripcion</descripcion><panchoPuntos>1</panchoPuntos><tarifa>1.0</tarifa><horario>1970-01-01T00:00:01.000000001</horario><plataforma>FACEBOOK</plataforma></cuidador>";
        Cuidador result = (Cuidador) ser.deserialize(sauce);
        assertEquals(1, result.getId());
        assertEquals("nombre", result.getNombre());
        assertEquals(TPlataforma.FACEBOOK, result.getPlataforma());
        assertEquals("codPlat", result.getCodigoPlatafoma());
        assertEquals("descripcion", result.getDescripcion());
        assertEquals(1, result.getPanchoPuntos());
        assertEquals(1.0, result.getTarifa());
        assertEquals(LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.ofHours(0)), result.getHorario());
    }
}