package edu.acaiza.decorator.decoradores;

import edu.acaiza.decorator.mensaje.IMensaje;

public class SOAPEnvelopMensaje extends MensajeDecorador {

    public SOAPEnvelopMensaje(IMensaje mensaje) {
        super(mensaje);
    }

    @Override
    public IMensaje procesarMensaje() {
        mensaje.procesarMensaje();
        mensaje = envelopMessage();
        return mensaje;

    }

    private IMensaje envelopMessage() {
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + " <soapenv:Header/>\n"
                + " <soapenv:Body>\n"
                + mensaje.getContenidoMensaje()
                + "\n"
                + " </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        mensaje.setContenido(soap);
        return mensaje;

    }

}
