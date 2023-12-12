/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.singleton;

/**
 *
 * @author USUARIO
 */
public class MainSingleton {
    public static void main(String[] args) {
        Employee emple1 = new Employee("Carlos", "CEO", "Tomar Desiciones Ejecutivas");
    emple1.printCurrentAssignment();
    Employee emple2 = new Employee("Sara", "Consultor", "Consultorias de la empres");
    emple2.printCurrentAssignment();
    Employee emple3 = new Employee("Tito", "Vendedor", "Vende productos  de la empres");
    emple3.printCurrentAssignment();
    Employee emple4 = new Employee("Tamia", "Crush", "Crush de vichi");
    emple4.printCurrentAssignment();
    
        
    }
    
    
   
  
}
