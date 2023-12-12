/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factory;

/**
 *
 * @author USUARIO
 */
public class Diamond extends Figure {

    private double diametroMayor;
    private double diametroMenor;

    public Diamond(String nombre, double diametroMenor, double diametroMayor) {
        super(nombre);
        this.diametroMayor = diametroMayor;
        this.diametroMenor = diametroMenor;
    }

    @Override
    public double area() {
        return (this.diametroMayor * this.diametroMenor) / 2;
    }

    @Override
    public double numeroOfSlides() {

        return 4;
    }

    @Override
    public String toString() {
        return "Diamond{" + "diametroMayor=" + diametroMayor + ", diametroMenor=" + diametroMenor + '}';
    }

}
