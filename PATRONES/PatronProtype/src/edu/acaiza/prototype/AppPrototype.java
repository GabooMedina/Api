/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

/**
 *
 * @author USUARIO
 */
public class AppPrototype {

    public static void main(String[] args) {
        CuentaAH cuentaAhorross = new CuentaAH();
        cuentaAhorross.setMonto(200);
        System.out.println(cuentaAhorross);
        System.out.println("-------------------");

        CuentaAH cuentaClonada = (CuentaAH) cuentaAhorross.clonar();
        CuentaAH cuentaAhorros2 = new CuentaAH();
        System.out.println("Cuenta original " + cuentaAhorross);
        System.out.println("Cuenta clonada " + cuentaAhorross.clonar());
        System.out.println("Cuenta ahorros 2 " + cuentaAhorros2);
        CuentaAH cuentaClonada2 = (CuentaAH) cuentaAhorross.clonar();
        System.out.println("CuentaClonada2 = " + cuentaClonada2);
        System.out.println(cuentaAhorross == cuentaClonada);

    }

}
