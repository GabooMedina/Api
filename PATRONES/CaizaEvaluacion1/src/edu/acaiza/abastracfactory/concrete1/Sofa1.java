/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abastracfactory.concrete1;

import edu.acaiza.abastracfactory.ISofa;

/**
 *
 * @author USUARIO
 */
public class Sofa1 implements  ISofa{
    private String color;
    

    @Override
    public String view() {
        return "de color Rojo Victorian";
    }
    
}
