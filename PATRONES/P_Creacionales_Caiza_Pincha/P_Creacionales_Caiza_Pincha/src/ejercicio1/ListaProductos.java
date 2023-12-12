/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ListaProductos implements IPLista{

    ArrayList<Productos> producto = new ArrayList<>();
    
    
    @Override
    public IPLista clonar() {
        ListaProductos clonar = new ListaProductos();
        
        ArrayList<Productos> productosClon = new ArrayList<>();
        for (int i = 0; i < producto.size(); i++) {
            Productos original = producto.get(i);
            
            productosClon.add(new Productos(original.getNombre(), original.getPrecio()));
        }        
        clonar.setProducto(productosClon);
        
        return  clonar;
    }
    
    public ArrayList<Productos> getProducto() {
        return producto;
    }
    
    public void setProducto(ArrayList<Productos> producto) {
        this.producto = producto;
    }
    public void guardarPorducto(Productos producto){
        this.producto.add(producto);
                
    }
    
}
