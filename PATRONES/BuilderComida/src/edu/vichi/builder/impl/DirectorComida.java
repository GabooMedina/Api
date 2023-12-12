/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.impl;

import edu.vichi.builder.domain.Agua;
import edu.vichi.builder.domain.Cola;
import edu.vichi.builder.domain.Comida;
import edu.vichi.builder.domain.HamburguesaPollo;
import edu.vichi.builder.domain.HamburguesaVeg;

/**
 *
 * @author jaevi
 */
public class DirectorComida {

    public Comida prepararComidaVeg() {
        Comida comida = new Comida();
        comida.addItem(new HamburguesaVeg());
        comida.addItem(new Cola());
        return comida;
    }
    
    public Comida prepararComidaPollo() {
        Comida comida = new Comida();
        comida.addItem(new HamburguesaPollo());
        comida.addItem(new Agua());
        return comida;
    }
}
