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
        Document doc = XML.newDocument();
        Element root = doc.createElement("cuidador");
        doc.appendChild(root);

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode(String.valueOf(cuidador.getId())));
        root.appendChild(id);

        Element panchoPuntos = doc.createElement("panchoPuntos");
        panchoPuntos.appendChild(doc.createTextNode(String.valueOf(cuidador.getPanchoPuntos())));
        root.appendChild(panchoPuntos);

        Element descripcion = doc.createElement("descripcion");
        descripcion.appendChild(doc.createTextNode(cuidador.getDescripcion()));
        root.appendChild(descripcion);

        Element tarifa = doc.createElement("tarifa");
        tarifa.appendChild(doc.createTextNode(String.valueOf(cuidador.getTarifa())));
        root.appendChild(tarifa);

        Element horario = doc.createElement("horario");
        horario.appendChild(doc.createTextNode(cuidador.getHorario().toString()));
        root.appendChild(horario);

        Element nombre = doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode(cuidador.getNombre()));
        root.appendChild(nombre);

        Element plataforma = doc.createElement("plataforma");
        plataforma.appendChild(doc.createTextNode(cuidador.getPlataforma().toString()));
        root.appendChild(plataforma);

        return XML.toString(doc);
    }

    @Override
    public Cuidador deserialize(String data) {
        Document doc = XML.getDocumentt(data);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("cuidador");
        Node node = nodeList.item(0);
        Element elem = (Element) node;

        int id = Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent());
        int panchoPuntos = Integer.parseInt(elem.getElementsByTagName("panchoPuntos").item(0).getTextContent());
        String descripcion = elem.getElementsByTagName("descripcion").item(0).getTextContent();
        double tarifa = Double.parseDouble(elem.getElementsByTagName("tarifa").item(0).getTextContent());
        LocalDateTime horario = LocalDateTime.parse(elem.getElementsByTagName("horario").item(0).getTextContent());
        String nombre = elem.getElementsByTagName("nombre").item(0).getTextContent();
        TPlataforma plataforma = TPlataforma.valueOf(elem.getElementsByTagName("plataforma").item(0).getTextContent());

        return new Cuidador(panchoPuntos, descripcion, tarifa, horario, nombre, id, plataforma);
    }
}
