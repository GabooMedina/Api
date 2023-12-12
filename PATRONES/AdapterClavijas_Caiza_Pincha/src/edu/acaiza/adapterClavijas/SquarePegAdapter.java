/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapterClavijas;

/**
 *
 * @author USUARIO
 */
public class SquarePegAdapter {

    SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    public Double getRadius() {
        return squarePeg.getWidth() * Math.sqrt(2) / 2;

    }

}
