/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.tipocuenta;

import ejercicio6.abstractfactory.ICuenta;

/**
 *
 * @author USUARIO
 */
public class Cuenta10 implements ICuenta{

    @Override
    public void getPropiedad() {
        System.out.println("1% de interes , 50% descubierto ");
    }

    @Override
    public void generarCuenta() {
        System.out.println("--Generando Cuenta 10 ....");
    }
    
}
