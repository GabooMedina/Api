/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

import java.util.ArrayList;

/**
 *
 * @author jaevi
 */
public class ProductoCompuesto implements IPrecio {

    private ArrayList<IPrecio> productos;

    public ProductoCompuesto() {
        productos = new ArrayList<>();
    }

    public void addProducto(IPrecio precio) {
        productos.add(precio);
    }

    public void removeProducto(IPrecio precio) {
        productos.remove(precio);
    }

    public ArrayList<IPrecio> getProductos() {
        return productos;
    }

    @Override
    public double getImporteTotal() {
        double total = 0;
        for (IPrecio precio : productos) {
            total += precio.getImporteTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ProductoCompuesto{" + "productos=" + productos + '}';
    }
    
}
