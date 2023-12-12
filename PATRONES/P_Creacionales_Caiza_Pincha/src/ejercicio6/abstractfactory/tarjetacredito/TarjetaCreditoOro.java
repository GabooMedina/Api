/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.tarjetacredito;

import ejercicio6.abstractfactory.ITarjetaCredito;

/**
 *
 * @author USUARIO
 */
public class TarjetaCreditoOro implements ITarjetaCredito{

    @Override
    public void getPropiedad() {
        System.out.println(" Gratuito , 60% pensión ");    }

    @Override
    public void generarTarjetaCredito() {
        System.out.println("--Generando Tarjeta de Credito Oro....");    }
    
}
