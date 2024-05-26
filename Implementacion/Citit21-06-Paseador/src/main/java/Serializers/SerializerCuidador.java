package Serializers;

import Modelo.Cuidador;
import Modelo.TPlataforma;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDateTime;

public class SerializerCuidador implements Serializer<Cuidador> {
    @Override
    public String serialize(Cuidador cuidador) {
        return "";
    }

    @Override
    public Cuidador deserialize(String data) {
        Document doc = XML.getDocument(data);
        doc.getDocumentElement()
                .normalize();

        NodeList nodeList = doc.getElementsByTagName("cuidador");
        Node node = nodeList.item(0);
        Element elem = (Element) node;

        int id = Integer.parseInt(elem.getElementsByTagName("id")
                .item(0)
                .getTextContent());
        int panchoPuntos = Integer.parseInt(elem.getElementsByTagName("panchoPuntos")
                .item(0)
                .getTextContent());
        String descripcion = elem.getElementsByTagName("descripcion")
                .item(0)
                .getTextContent();
        double tarifa = Double.parseDouble(elem.getElementsByTagName("tarifa")
                .item(0)
                .getTextContent());
        LocalDateTime horario = LocalDateTime.parse(elem.getElementsByTagName("horario")
                .item(0)
                .getTextContent());
        String nombre = elem.getElementsByTagName("nombre")
                .item(0)
                .getTextContent();
        TPlataforma plataforma = TPlataforma.parse(elem.getElementsByTagName("plataforma")
                .item(0)
                .getTextContent());
        return new Cuidador(panchoPuntos, descripcion, tarifa, horario, nombre, id, plataforma);
    }
}
