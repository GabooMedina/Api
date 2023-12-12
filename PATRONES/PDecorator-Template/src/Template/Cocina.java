/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package template;

import adapter.IPizza;

/**
 *
 * @author jaevi
 */
public abstract class Cocina {

    public abstract IPizza crear();

    public abstract IPizza agregarPeperoni(IPizza ipizza);
    
    public abstract IPizza agregarQueso(IPizza ipizza);


}
