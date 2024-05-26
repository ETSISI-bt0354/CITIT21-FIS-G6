package Repositorio;

import Serializers.Serializer;
import Serializers.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class SerializerXMLMock implements Serializer<Mock> {
    @Override
    public String serialize(Mock mock) {
        Document newDoc = XML.getEmptyDocument();
        Element root = newDoc.createElement("mocks");
        newDoc.appendChild(root);
        root.setAttribute("id", String.valueOf(mock.getId()));

        Element tomatoe = newDoc.createElement("tomatoe");
        tomatoe.appendChild(newDoc.createTextNode(mock.getTomatoe()));
        root.appendChild(tomatoe);

        return XML.DocumentToString(newDoc);
    }

    @Override
    public Mock deserialize(String data) {
        Document document = XML.getDocument(data);
        Element mock = (Element) document.getElementsByTagName("mock")
                .item(0);

        int id = Integer.parseInt(mock.getAttributes()
                .item(0)
                .getNodeValue());
        String tomatoe = document.getElementsByTagName("tomatoe").item(0)
                .getTextContent();

        return new Mock(id, tomatoe);
    }
}
