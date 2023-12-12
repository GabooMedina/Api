/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.acaiza.decorator.mensaje;

/**
 *
 * @author USUARIO
 */
public interface IMensaje {
    
    public IMensaje procesarMensaje();
    public String getContenidoMensaje();
    public void setContenido(String contenido);
    
}
