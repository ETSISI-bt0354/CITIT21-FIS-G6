package Serializers;

import Modelo.Exotico;
import Modelo.Responsable;
import Repositorio.IGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.nio.file.Path;

public class SerializerXMLExotico implements Serializer<Exotico> {
    private final IGet<Responsable> responsables;

    public SerializerXMLExotico(IGet<Responsable> responsable) {
        this.responsables = responsable;
    }

    @Override
    public String serialize(Exotico exotico) {
        Document document = XML.getEmptyDocument();

        Element root = document.createElement("mascota");
        document.appendChild(root);
        root.setAttribute("id", String.valueOf(exotico.getId()));

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode(exotico.getNombre()));
        root.appendChild(nombre);

        Element codigoPostal = document.createElement("codigoPostal");
        nombre.appendChild(document.createTextNode(String.valueOf(exotico.getCodigoPostal())));
        root.appendChild(codigoPostal);

        Element descripcion = document.createElement("descripcion");
        descripcion.appendChild(document.createTextNode(exotico.getDescripcion()));
        root.appendChild(descripcion);

        Element responsable = document.createElement("responsable");
        responsable.appendChild(document.createTextNode(String.valueOf(exotico.getResponsable()
                                                                               .getId())));
        root.appendChild(responsable);

        Element permiso = document.createElement("permiso");
        permiso.appendChild(document.createTextNode(String.valueOf(exotico.getPermiso())));
        root.appendChild(permiso);

        Element certificadoLegal = document.createElement("certificado-legal");
        certificadoLegal.appendChild(document.createTextNode(String.valueOf(exotico.getCertificadoLegal())));
        root.appendChild(certificadoLegal);

        Element certificadoSalud = document.createElement("certificado-salud");
        certificadoSalud.appendChild(document.createTextNode(String.valueOf(exotico.getCertificadoSalud())));
        root.appendChild(certificadoSalud);

        return XML.DocumentToString(document);
    }

    @Override
    public Exotico deserialize(String data) {
        Document document = XML.getDocument(data);
        Node exotico = document.getElementsByTagName("exotico")
                .item(0);

        int id = Integer.parseInt(exotico.getAttributes()
                                          .item(0)
                                          .getNodeValue());

        String nombre = document.getElementsByTagName("nombre")
                .item(0)
                .getTextContent();

        int codigoPostal = Integer.parseInt(document.getElementsByTagName("codigoPostal")
                                                    .item(0)
                                                    .getTextContent());

        String descripcion = document.getElementsByTagName("descripcion")
                .item(0)
                .getTextContent();

        Responsable responsable = responsables.obtener(Integer.parseInt(document.getElementsByTagName("responsable")
                                                                                .item(0)
                                                                                .getTextContent()));

        Path permiso = Path.of(document.getElementsByTagName("permiso")
                                       .item(0)
                                       .getTextContent());

        Path certificadoLegal = Path.of(document.getElementsByTagName("certificado-legal")
                                                .item(0)
                                                .getTextContent());

        Path certificadoSalud = Path.of(document.getElementsByTagName("certificado-salud")
                                                .item(0)
                                                .getTextContent());

        return new Exotico(id, nombre, codigoPostal, descripcion, responsable, permiso, certificadoLegal, certificadoSalud);
    }
}
