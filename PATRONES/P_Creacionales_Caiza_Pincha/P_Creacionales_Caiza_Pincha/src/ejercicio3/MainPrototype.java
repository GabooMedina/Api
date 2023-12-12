/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class MainPrototype {
    public static void main(String[] args) {
        Android android = new Android();
        ArrayList<String> aplicaciones = new ArrayList();
        aplicaciones.add("Google");
        aplicaciones.add("Facebook");
        android.setVersion("5.0");
        android.setName("Redmi");
        android.setAplicaciones(aplicaciones);
        System.out.println("***Sistema Existente***");
        System.out.println(android);
        //
        Android androidClonado = (Android) android.clonar();
        if (androidClonado != null) {
            androidClonado.setVersion("10.0");
            androidClonado.setName("Redmi10");
            System.out.println("***Sistema Clonado 1***");
            System.out.println(androidClonado);
        }
        //
        Android androidClonado2 = (Android) android.clonar();
        ArrayList<String> aplicaciones2 = new ArrayList();
        aplicaciones2.add("Youtube");
        aplicaciones2.add("Gmail");
        aplicaciones2.add("Facebook");
        androidClonado2.setVersion("11.0");
        androidClonado2.setName("Redmi12");
        androidClonado2.setAplicaciones(aplicaciones2);
        if (androidClonado2 != null) {
            System.out.println("***Sistema Clonado 2***");
            System.out.println(androidClonado2);
        }
    }
    
}
