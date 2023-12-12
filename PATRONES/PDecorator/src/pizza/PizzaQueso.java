/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza;

/**
 *
 * @author jaevi
 */
public class PizzaQueso extends PizzaDecorator {

    public PizzaQueso(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String descripcion() {
        return pizza.descripcion() + " + quesito";
    }

    @Override
    public double costo() {
        return pizza.costo() + 2;
    }
}
