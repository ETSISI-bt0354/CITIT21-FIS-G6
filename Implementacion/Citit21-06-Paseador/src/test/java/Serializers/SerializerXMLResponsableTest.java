package Serializers;

import Modelo.Responsable;
import Modelo.TPlataforma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializerXMLResponsableTest {

    @org.junit.jupiter.api.Test
    void serializeFullResponsable() {
        Serializer ser = new SerializerXMLResponsable();
        Responsable mock = new Responsable(1, "codigoPlataforma", TPlataforma.FACEBOOK, "nombre");
        String result = ser.serialize(mock);
        assertTrue(result.contains("<responsables id=\"1\">"));
        assertTrue(result.contains("<nombre>nombre</nombre>"));
        assertTrue(result.contains("<plataforma>FACEBOOK</plataforma>"));
    }

    @org.junit.jupiter.api.Test
    void deserializeFullResponsable() {
        Serializer ser = new SerializerXMLResponsable();
        String data = "<responsables id=\"1\"><nombre>nombre</nombre><plataforma>FACEBOOK</plataforma></responsables>";
        Responsable result = (Responsable) ser.deserialize(data);
        result.getId();
        assertEquals(1, result.getId());
        assertEquals("nombre", result.getNombre());
        assertEquals(TPlataforma.FACEBOOK, result.getPlataforma());
    }
}