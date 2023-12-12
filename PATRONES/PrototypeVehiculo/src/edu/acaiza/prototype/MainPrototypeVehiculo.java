/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

/**
 *
 * @author USUARIO
 */
public class MainPrototypeVehiculo {
    
    public static void main(String[] args) {
        RegistroVehiculos registroVehichulo = new RegistroVehiculos();
        Taxi taxi1 = (Taxi) registroVehichulo.obtenerPrototipo("Taxi");
        Taxi taxi2 = (Taxi) registroVehichulo.obtenerPrototipo("Taxi");
        //verificar

        System.out.println("Clone 1 Taxi : " + taxi1);
        System.out.println("Clone 2 Taxi : " + taxi2);
        System.out.println("---------------------");
        //System.out.println("CLONES MODIFICADAS");
        taxi1.setNumPuertas(4);
        taxi1.setMarca("Huianday");
        System.out.println("CLONES MODIFICADAS");
        System.out.println("Clone 1 Taxi : " + taxi1);
        System.out.println("Clone 2 Taxi : " + taxi2);
        System.out.println("---------------------");
        
        Autobus autobus = new Autobus("Nissan", "2007", "HD.4", "AZUL", 40);
        registroVehichulo.adicionaPrototipo("Autobus", autobus);
        
        Autobus autobus2 = (Autobus) registroVehichulo.obtenerPrototipo("Autobus");
        
        System.out.println("Autibus 2 :  " + autobus2);
       
        
    }
    
}
