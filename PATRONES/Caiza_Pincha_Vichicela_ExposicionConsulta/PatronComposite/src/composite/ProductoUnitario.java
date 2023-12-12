/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author jaevi
 */

public class ProductoUnitario implements IPrecio {

    private int cantidad;
    private double precio;
    private String nombre;
    private String categoria;

    public ProductoUnitario(String nombre, String categoria, int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public double getImporteTotal() {
        return getCantidad() * getPrecio();
    }

    @Override
    public String toString() {
        return "ProductoUnitario{" + "cantidad=" + cantidad + ", precio=" + precio + ", nombre=" + nombre + ", categoria=" + categoria + '}';
    }
    

}
