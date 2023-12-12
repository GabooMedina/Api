/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.decorator.mensaje;

import java.lang.reflect.UndeclaredThrowableException;

/**
 *
 * @author USUARIO
 */
public class MensajeCliente implements IMensaje {

    private String nombre;
    private String email;
    private String telefono;

    public MensajeCliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public IMensaje procesarMensaje() {

        return this;
    }

    @Override
    public String getContenidoMensaje() {
        return toString();
    }

    @Override
    public String toString() {
        return "MensajeCliente{" + "nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }

    @Override
    public void setContenido(String contenido) {
        throw new UnsupportedOperationException("Aun no es compatible"); 
    }
    
    

    

}
