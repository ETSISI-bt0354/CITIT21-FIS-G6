package Serializers;

import Modelo.Responsable;
import Modelo.TPlataforma;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SerializerXMLResponsable implements Serializer<Responsable> {
    @Override
    public String serialize(Responsable responsable) {
        Document newDoc = XML.getEmptyDocument();
        Element root = newDoc.createElement("responsables");
        newDoc.appendChild(root);
        root.setAttribute("id", String.valueOf(responsable.getId()));

        Element nombre = newDoc.createElement("nombre");
        nombre.appendChild(newDoc.createTextNode(responsable.getNombre()));
        root.appendChild(nombre);

        Element plataforma = newDoc.createElement("plataforma");
        plataforma.appendChild(newDoc.createTextNode(responsable.getPlataforma()
                                                             .toString()));
        root.appendChild(plataforma);

        return XML.DocumentToString(newDoc);
    }

    @Override
    public Responsable deserialize(String data) {
        Document document = XML.getDocument(data);
        Node responsable = document.getElementsByTagName("responsable")
                .item(0);

        int id = Integer.parseInt(responsable.getAttributes()
                                          .item(0)
                                          .getNodeValue());

        NodeList nodeList = responsable.getChildNodes();

        TPlataforma plataforma = TPlataforma.parse(nodeList.item(0)
                                                           .getTextContent());
        String nombre = nodeList.item(1)
                .getTextContent();

        return new Responsable(id, plataforma, nombre);
    }
}
