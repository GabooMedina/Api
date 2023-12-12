/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.PaisSingleton;

/**
 *
 * @author USUARIO
 */
public class AppPaises {

    public static void main(String[] args) {
        PaisesList listaPaises = PaisesList.getInstance();
        for (Object obj : listaPaises.getPaises()) {
            System.out.println(((Pais) obj).getNombre());
        }

        System.out.println("---------------------");
        PaisesList listaPaises2 = PaisesList.getInstance();
        for (Object obj : listaPaises2.getPaises()) {
            System.out.println(((Pais) obj).getNombre());

        }
        System.out.println("------------------"); 
        PaisesList listaPaises3 = PaisesList.getInstance();
        for (Object obj : listaPaises3.getPaises()) {
            System.out.println(((Pais) obj).getNombre());
    }
}
}