/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza;

/**
 *
 * @author jaevi
 */
public class PizzaBasica implements IPizza {

    @Override
    public String descripcion() {
        return "Pizza";
    }

    @Override
    public double costo() {
        return 5.0;
    }

}
