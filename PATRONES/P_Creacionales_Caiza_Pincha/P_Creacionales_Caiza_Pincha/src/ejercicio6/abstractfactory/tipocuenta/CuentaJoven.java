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
public class CuentaJoven implements ICuenta{

    @Override
    public void getPropiedad() {
        System.out.println(" 2% de interés");
    }

    @Override
    public void generarCuenta() {
        System.out.println("--Generando Cuenta Joven....");
    }
    
}
