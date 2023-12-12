/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factory;

/**
 *
 * @author USUARIO
 */
public class Circle extends Figure {

    private double radios;

    public Circle( String nombre,double radio) {
        super(nombre);
        this.radios = radio;
    }

    @Override
    public double area() {
        return Math.PI * radios * radios;

    }

    @Override
    public String toString() {
        return "Circle{" + "radios=" + radios + '}';
    }

    @Override
    public double numeroOfSlides() {

        return Double.POSITIVE_INFINITY;
    }

}


