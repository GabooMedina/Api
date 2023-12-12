/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.tarjetadebito;

import ejercicio6.abstractfactory.ITarjetaDebito;

/**
 *
 * @author USUARIO
 */
public class TarjetaDebitoJoven  implements ITarjetaDebito{
    @Override
    public void getPropiedad() {
        System.out.println(" Gratuito");    }

    @Override
    public void generarTarjetaDebito() {
        System.out.println("--Generando Tarjeta Debito Joven....");    }
}
