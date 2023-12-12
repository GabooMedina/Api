/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.decorator.mensaje;

/**
 *
 * @author USUARIO
 */
public class MensajeTexto implements IMensaje {

    private String contenido;

    public MensajeTexto(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public IMensaje procesarMensaje() {
        return this;
    }

    @Override
    public String getContenidoMensaje() {
        return this.contenido;
    }

    @Override
    public void setContenido(String contenido) {
        this.contenido = contenido;

    }

}
