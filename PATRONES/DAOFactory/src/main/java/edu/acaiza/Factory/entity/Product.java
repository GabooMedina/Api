/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.Factory.entity;

/**
 *
 * @author USUARIO
 */
public class Product {
    private int idProduct;
    private String prductName;
    private double price;

    public Product() {
    }
    
    public Product(int idProduct) {
        this.idProduct=idProduct;
    }

    
    public Product(int idProduct, String prductName, double price) {
        this.idProduct = idProduct;
        this.prductName = prductName;
        this.price = price;
    }
    

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return prductName;
    }

    public void setProductName(String prductName) {
        this.prductName = prductName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", prductName=" + prductName + ", price=" + price + '}';
    }
    

}
