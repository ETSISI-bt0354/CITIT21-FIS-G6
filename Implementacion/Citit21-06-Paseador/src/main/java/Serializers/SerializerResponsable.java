package Serializers;

import Modelo.Responsable;
import Modelo.TPlataforma;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SerializerResponsable implements Serializer<Responsable> {
    @Override
    public String serialize(Responsable responsable) {
        return "";
    }

    @Override
    public Responsable deserialize(String data) {
        Document doc = XML.getDocument(data);
        doc.getDocumentElement()
                .normalize();

        NodeList nodeList = doc.getElementsByTagName("responsable");
        Node node = nodeList.item(0);
        Element elem = (Element) node;

        int id = Integer.parseInt(elem.getElementsByTagName("id")
                                          .item(0)
                                          .getTextContent());

        TPlataforma plataforma = TPlataforma.parse(elem.getElementsByTagName("plataforma")
                                                           .item(0)
                                                           .getTextContent());

        String nombre = elem.getElementsByTagName("nombre")
                .item(0)
                .getTextContent();

        return new Responsable(id, plataforma, nombre);
    }
}
