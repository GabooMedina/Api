/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Template.Pizza;
import adapter.IPizza;
import adapter.Peperoni;
import adapter.PizzaBase;
import adapter.Queso;
import template.Cocina;

/**
 *
 * @author jaevi
 */
public class Main {

    public static void main(String[] args) {
        Cocina c = new Pizza();

        IPizza pizza = c.crear();
        System.out.println("Pedido: " + pizza.descripcion());
        System.out.println("Costo: " + pizza.costo());
        
        System.out.println("");
        
        IPizza pizza2 = c.agregarPeperoni(new PizzaBase());
        System.out.println("Pedido: " + pizza2.descripcion());
        System.out.println("Costo: " + pizza2.costo());
        
        System.out.println("");
        
        IPizza pizza3 = c.agregarQueso(new PizzaBase());
        System.out.println("Pedido: " + pizza3.descripcion());
        System.out.println("Costo: " + pizza3.costo());
        
        System.out.println("");
        
        IPizza pizza4 = c.agregarPeperoni(new Queso(new PizzaBase())); 
        System.out.println("Pedido: " + pizza4.descripcion());
        System.out.println("Costo: " + pizza4.costo());
    }
}
