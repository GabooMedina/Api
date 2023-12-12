/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza;

/**
 *
 * @author jaevi
 */
public abstract class PizzaDecorator implements IPizza{
    protected IPizza pizza;

    public PizzaDecorator(IPizza pizza) {
        this.pizza = pizza;
    }   
}
