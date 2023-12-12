/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author jaevi
 */
public class PizzaBase implements IPizza{

    @Override
    public String descripcion() {
    return "Pizza Basica";
    }

    @Override
    public double costo() {
    return 2;
    }
    
}
