/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author jaevi
 */
public class ProductoPeso implements IPrecio {

    private double peso;
    private double precioPeso;
    private String nombre;
    private String categoria;

    public ProductoPeso(String nombre, String categoria, double peso, double precioPeso) {
        this.peso = peso;
        this.precioPeso = precioPeso;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecioPeso() {
        return precioPeso;
    }

    public void setPrecioPeso(double precioPeso) {
        this.precioPeso = precioPeso;
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
        return getPeso() * getPrecioPeso();
    }

    @Override
    public String toString() {
        return "ProductoPeso{" + "peso=" + peso + ", precioPeso=" + precioPeso + ", nombre=" + nombre + ", categoria=" + categoria + '}';
    }
    

}
