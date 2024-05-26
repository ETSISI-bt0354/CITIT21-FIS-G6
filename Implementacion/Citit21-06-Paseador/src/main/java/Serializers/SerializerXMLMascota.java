package Serializers;

import Modelo.Mascota;
import Modelo.Responsable;
import Repositorio.InMemoryRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SerializerXMLMascota implements Serializer<Mascota> {
    private final InMemoryRepository<Responsable> responsables;

    public SerializerXMLMascota(InMemoryRepository<Responsable> responsable) {
        this.responsables = responsable;
    }

    @Override
    public String serialize(Mascota mascota) {
        Document document = XML.getEmptyDocument();

        Element root = document.createElement("mascota");
        document.appendChild(root);
        root.setAttribute("id", String.valueOf(mascota.getId()));

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode(mascota.getNombre()));
        root.appendChild(nombre);

        Element codigoPostal = document.createElement("codigoPostal");
        nombre.appendChild(document.createTextNode(String.valueOf(mascota.getCodigoPostal())));
        root.appendChild(codigoPostal);

        Element descripcion = document.createElement("descripcion");
        descripcion.appendChild(document.createTextNode(mascota.getDescripcion()));
        root.appendChild(descripcion);

        Element responsable = document.createElement("responsable");
        responsable.appendChild(document.createTextNode(String.valueOf(mascota.getResponsable()
                                                                               .getId())));
        root.appendChild(responsable);

        return XML.DocumentToString(document);
    }

    @Override
    public Mascota deserialize(String data) {
        Document document = XML.getDocument(data);
        Node mascota = document.getElementsByTagName("responsable")
                .item(0);

        int id = Integer.parseInt(mascota.getAttributes()
                                          .item(0)
                                          .getNodeValue());
        NodeList nodeList = mascota.getChildNodes();

        String nombre = nodeList.item(0)
                .getTextContent();
        int codigoPostal = Integer.parseInt(nodeList.item(1)
                                                    .getTextContent());
        String descripcion = nodeList.item(2)
                .getTextContent();
        Responsable responsable = responsables.obtener(Integer.parseInt(nodeList.item(3)
                                                                                .getTextContent()));

        return new Mascota(id, nombre, codigoPostal, descripcion, responsable);
    }
}
