/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author jaevi
 */
public abstract class PizzaDecorador implements IPizza {

    IPizza pizza;

    public PizzaDecorador(IPizza pizza) {
        this.pizza = pizza;
    }

}
