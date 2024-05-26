package Serializers;

import Excepciones.NotFound;
import Modelo.Cuidado;
import Modelo.Cuidador;
import Modelo.Mascota;
import Repositorio.IGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.time.Duration;
import java.time.LocalDateTime;

public class SerializerXMLCuidado implements Serializer<Cuidado> {

    private final IGet<Cuidador> cuidadores;
    private final IGet<Mascota> mascotas;

    public SerializerXMLCuidado(IGet<Cuidador> cuidadores, IGet<Mascota> mascotas) {
        this.cuidadores = cuidadores;
        this.mascotas = mascotas;
    }


    @Override
    public String serialize(Cuidado cuidado) {
        Document document = XML.getEmptyDocument();

        Element root = document.createElement("cuidado");
        document.appendChild(root);
        root.setAttribute("id", String.valueOf(cuidado.getId()));

        Element fechaCuidado = document.createElement("fechaCuidado");
        fechaCuidado.appendChild(document.createTextNode(cuidado.getFechaCuidado().toString()));
        root.appendChild(fechaCuidado);

        Element duracion = document.createElement("duracion");
        duracion.appendChild(document.createTextNode(cuidado.getDuracion().toString()));
        root.appendChild(duracion);

        Element cuidador = document.createElement("cuidador");
        if (cuidado.getCuidador() == null) {
            cuidador.appendChild(document.createTextNode("nil"));
        } else {
            cuidador.appendChild(document.createTextNode(String.valueOf(cuidado.getCuidador().getId())));
        }
        root.appendChild(cuidador);

        Element mascota = document.createElement("mascota");
        if (cuidado.getMascota() == null) {
            mascota.appendChild(document.createTextNode("nil"));
        } else {
            mascota.appendChild(document.createTextNode(String.valueOf(cuidado.getMascota().getId())));
        }
        root.appendChild(mascota);

        return XML.DocumentToString(document);
    }

    @Override
    public Cuidado deserialize(String data) {
        Document doc = XML.getDocument(data);
        Node cuidado = doc.getElementsByTagName("cuidado").item(0);
        int id = Integer.parseInt(cuidado.getAttributes().item(0).getNodeValue());

        LocalDateTime fechaCuidado = LocalDateTime.parse(doc.getElementsByTagName("fechaCuidado")
                .item(0).getTextContent());
        Duration duracion = Duration.parse(doc.getElementsByTagName("duracion")
                .item(0).getTextContent());

        Cuidado le_cuidado = new Cuidado(fechaCuidado, duracion, id);

        Cuidador cuidador = null;
        try {
            cuidador = doc.getElementsByTagName("cuidador").item(0).getTextContent().equals("nil") ?
                    null : cuidadores.obtener(Integer.parseInt(doc.getElementsByTagName("cuidador").item(0).getTextContent()));
        } catch (NotFound e) {
            throw new RuntimeException(e);
        }
        Mascota mascota = null;
        try {
            mascota = doc.getElementsByTagName("mascota").item(0).getTextContent().equals("nil") ?
                    null : mascotas.obtener(Integer.parseInt(doc.getElementsByTagName("mascota").item(0).getTextContent()));
        } catch (NotFound e) {
            throw new RuntimeException(e);
        }

        if (cuidador != null) {
            le_cuidado.setCuidador(cuidador);
        }
        if (mascota != null) {
            le_cuidado.setMascota(mascota);
        }

        return le_cuidado;
    }


}
