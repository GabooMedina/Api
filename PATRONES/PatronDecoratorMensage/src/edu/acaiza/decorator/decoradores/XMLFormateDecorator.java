package edu.acaiza.decorator.decoradores;

import edu.acaiza.decorator.mensaje.IMensaje;
import edu.acaiza.decorator.mensaje.MensajeTexto;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class XMLFormateDecorator extends MensajeDecorador {

    public XMLFormateDecorator(IMensaje mensaje) {
        super(mensaje);
    }

    @Override
    public IMensaje procesarMensaje() {
        mensaje = mensaje.procesarMensaje();
        mensaje = xmlMensaje();
        return mensaje;

    }

    private IMensaje xmlMensaje() {
        try {
            JAXBContext jc = JAXBContext.newInstance(mensaje.getClass());
            JAXBElement<IMensaje> je2 = new JAXBElement<IMensaje>(
                    new QName(mensaje.getClass().getName()),
                    (Class<IMensaje>) mensaje.getClass(), mensaje);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            marshaller.marshal(je2, output);
            return new MensajeTexto(new String(output.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al convertir el XML");
        }

    }
}
