/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.domain;

/**
 *
 * @author jaevi
 */
public class Agua extends BebidaFria {

    @Override
    public float getPrecio() {
        return 0.6f;
    }

    @Override
    public String getNombre() {
   return "Agua sin gas";
    }

}
