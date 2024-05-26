package Serializers;

import Modelo.Cuidador;
import Modelo.TPlataforma;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDateTime;

public class SerializerXMLCuidador implements Serializer<Cuidador> {

    @Override
    public String serialize(Cuidador cuidador) {
        Document doc = XML.newDocument();
        Element root = doc.createElement("cuidador");
        doc.appendChild(root);
        root.setAttribute("id", String.valueOf(cuidador.getId()));


        Element nombre = doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode(cuidador.getNombre()));
        root.appendChild(nombre);


        Element descripcion = doc.createElement("descripcion");
        descripcion.appendChild(doc.createTextNode(cuidador.getDescripcion()));
        root.appendChild(descripcion);

        Element panchoPuntos = doc.createElement("panchoPuntos");
        panchoPuntos.appendChild(doc.createTextNode(String.valueOf(cuidador.getPanchoPuntos())));
        root.appendChild(panchoPuntos);


        Element tarifa = doc.createElement("tarifa");
        tarifa.appendChild(doc.createTextNode(String.valueOf(cuidador.getTarifa())));
        root.appendChild(tarifa);

        Element horario = doc.createElement("horario");
        horario.appendChild(doc.createTextNode(cuidador.getHorario().toString()));
        root.appendChild(horario);


        Element plataforma = doc.createElement("plataforma");
        plataforma.appendChild(doc.createTextNode(cuidador.getPlataforma().toString()));
        root.appendChild(plataforma);

        return XML.toString(doc);
    }

    @Override
    public Cuidador deserialize(String data) {
        Document doc = XML.getDocumentt(data);
        Node cuidador = doc.getElementsByTagName("cuidador").item(0);

        int id = Integer.parseInt(cuidador.getAttributes().item(0).getNodeValue());
        NodeList elem = cuidador.getChildNodes();


        String nombre = elem.item(0).getTextContent();
        String descripcion = elem.item(1).getTextContent();
        int panchoPuntos = Integer.parseInt(elem.item(2).getTextContent());
        double tarifa = Double.parseDouble(elem.item(3).getTextContent());
        LocalDateTime horario = LocalDateTime.parse(elem.item(4).getTextContent());
        TPlataforma plataforma = TPlataforma.valueOf(elem.item(5).getTextContent());

        return new Cuidador(panchoPuntos, descripcion, tarifa, horario, nombre, id, plataforma);
    }
}
