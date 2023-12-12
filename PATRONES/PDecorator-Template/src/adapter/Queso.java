/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author jaevi
 */
public class Queso extends PizzaDecorador {

    public Queso(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String descripcion() {
        return pizza.descripcion() + " + queso";
    }

    @Override
    public double costo() {
        return pizza.costo() + 2;
    }

}
