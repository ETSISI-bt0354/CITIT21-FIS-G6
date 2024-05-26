package Serializers;

import Excepciones.PlataformaInvalida;
import Modelo.Cuidador;
import Modelo.TPlataforma;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.time.LocalDateTime;

public class SerializerXMLCuidador implements Serializer<Cuidador> {

    @Override
    public String serialize(Cuidador cuidador) {
        Document doc = XML.getEmptyDocument();
        Element root = doc.createElement("cuidador");
        doc.appendChild(root);
        root.setAttribute("id", String.valueOf(cuidador.getId()));

        Element codigoPlataforma = doc.createElement("codigoPlataforma");
        codigoPlataforma.appendChild(doc.createTextNode(cuidador.getCodigoPlatafoma()));
        root.appendChild(codigoPlataforma);

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

        return XML.DocumentToString(doc);
    }

    @Override
    public Cuidador deserialize(String data) {
        Document document = XML.getDocument(data);
        Node cuidador = document.getElementsByTagName("cuidador").item(0);

        int id = Integer.parseInt(cuidador.getAttributes().item(0).getNodeValue());


        String codigoPlataforma = document.getElementsByTagName("codigoPlataforma").item(0).getTextContent();
        String nombre = document.getElementsByTagName("nombre").item(0).getTextContent();
        String descripcion = document.getElementsByTagName("descripcion").item(0).getTextContent();
        int panchoPuntos = Integer.parseInt(document.getElementsByTagName("panchoPuntos").item(0).getTextContent());
        double tarifa = Double.parseDouble(document.getElementsByTagName("tarifa").item(0).getTextContent());
        LocalDateTime horario = LocalDateTime.parse(document.getElementsByTagName("horario").item(0).getTextContent());
        TPlataforma plataforma = null;
        try {
            plataforma = TPlataforma.parse(document.getElementsByTagName("plataforma").item(0)
                    .getTextContent());
        } catch (PlataformaInvalida e) {
            throw new RuntimeException(e);
        }

        return new Cuidador(panchoPuntos, descripcion, tarifa, horario, nombre, id, plataforma, codigoPlataforma);
    }
}
