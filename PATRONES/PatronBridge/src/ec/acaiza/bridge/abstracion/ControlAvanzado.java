/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.acaiza.bridge.abstracion;

import ec.acaiza.bridge.implementacion.IDispositivo;

/**
 *
 * @author USUARIO
 */
public class ControlAvanzado extends ControlRemotoBasico{
    
    public ControlAvanzado(IDispositivo dispositivo) {
        super(dispositivo);
    }
    public void mute(){
        System.out.println("Remoto :Botón mute");
        this.dispositivo.setVolumen(0);
        
    }
    
}
