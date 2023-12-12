/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapterClavijas;

/**
 *
 * @author USUARIO
 */
public class RoundPeg  implements IRound{
    Double radio;

    @Override
    public double getRadius() {
        return radio;
    }

    @Override
    public Boolean fits(Double roundPeg) {
       return null;
            
        }

    public RoundPeg(Double roud) {
        this.radio= roud;
    }
    
    }
    

