/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapterClavijas;

/**
 *
 * @author USUARIO
 */
public class RoundHole implements IRound {

    Double radio;

    @Override
    public double getRadius() {

        return radio;
    }

    @Override
    public Boolean fits(Double roundPeg) {
        if (roundPeg <= this.radio) {
            return true;

        } else {
            return false;
        }
    }
    public RoundHole (Double roud){
        this.radio = roud;
        
    }

}
