package edu.acaiza.decorator.decoradores;

import edu.acaiza.decorator.mensaje.IMensaje;

/**
 *
 * @author USUARIO
 */
public abstract class MensajeDecorador implements IMensaje {

    protected IMensaje mensaje;

    public MensajeDecorador(IMensaje mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getContenidoMensaje() {
        return mensaje.getContenidoMensaje();
    }

    @Override
    public void setContenido(String contenido) {
        this.mensaje.setContenido(contenido);

    }

}
