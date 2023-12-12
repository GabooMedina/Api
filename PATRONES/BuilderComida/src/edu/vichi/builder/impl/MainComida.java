/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.impl;

import edu.vichi.builder.domain.Comida;

/**
 *
 * @author jaevi
 */
public class MainComida {
    public static void main(String[] args) {
        DirectorComida director = new DirectorComida();
        
        Comida comidaVeg = director.prepararComidaVeg();
        System.out.println("Comida Vegetariana");
        comidaVeg.mostrarItem();
        System.out.println("Costo total: "+comidaVeg.getCosto());
        System.out.println("***********************************");
        Comida comidaNoVeg = director.prepararComidaPollo();
        System.out.println("Comida NO Vegetariana");
        comidaNoVeg.mostrarItem();
        System.out.println("Costo total: "+comidaNoVeg.getCosto());
    }
}
