/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza;

/**
 *
 * @author jaevi
 */
public class PizzaChampiñon extends PizzaDecorator {

    public PizzaChampiñon(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String descripcion() {
        return pizza.descripcion() + " + champiñon";
    }

    @Override
    public double costo() {
        return pizza.costo() + 1;
    }

}
