/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Template;

import adapter.IPizza;
import adapter.Peperoni;
import adapter.PizzaBase;
import adapter.Queso;
import template.Cocina;

/**
 *
 * @author jaevi
 */
public class Pizza extends Cocina {

    @Override
    public IPizza crear() {
        return new PizzaBase();
    }

    @Override
    public IPizza agregarPeperoni(IPizza ipizza) {
        ipizza = new Peperoni(ipizza);
        // ipizza = new Queso(ipizza);
        return ipizza;
    }

    @Override
    public IPizza agregarQueso(IPizza ipizza) {
        //  ipizza = new Peperoni(ipizza);
        ipizza = new Queso(ipizza);
        return ipizza;
    }

}
