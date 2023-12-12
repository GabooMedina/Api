/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.domain;

import edu.vichi.builder.impl.IItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaevi
 */
public class Comida {

    private List<IItem> items = new ArrayList<>();

    public void addItem(IItem item) {
        items.add(item);
    }

    public float getCosto() {
        float costo = 0;
        for (IItem item : items) {
            costo += item.getPrecio();
        }
        return costo;
    }
    
    public void mostrarItem(){
        for(IItem item: items){
            System.out.print("Item: "+item.getNombre());
            System.out.print(", Empaque: "+item.embalaje().empaquetar());
            System.out.print(", Precio: "+item.getPrecio());
        }
    }
}
