/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza;

/**
 *
 * @author jaevi
 */
public class Main {

    public static void main(String[] args) {
        IPizza pizza = new PizzaBasica();
        System.out.println("Compra de una pizza basica: " + pizza.descripcion() + " " + pizza.costo() + "\n");

        IPizza pizzaQueso = new PizzaQueso(new PizzaBasica());
        System.out.println("Compra de una pizza con queso: " + pizzaQueso.descripcion() + " " + pizzaQueso.costo() + "\n");

        IPizza pizzaChampiñon = new PizzaChampiñon(new PizzaBasica());
        System.out.println("Compra de una pizza con champiñon: " + pizzaChampiñon.descripcion() + " " + pizzaChampiñon.costo() + "\n");

        IPizza pizzaCompleta = new PizzaChampiñon(new PizzaQueso(new PizzaBasica()));
        System.out.println("Compra de una pizza con champiñon: " + pizzaCompleta.descripcion() + " " + pizzaCompleta.costo() + "\n");
    }
}
