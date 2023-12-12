/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abastracfactory.concrete1;

import edu.acaiza.abastracfactory.AbstractFactory;
import edu.acaiza.abastracfactory.IMesilla;
import edu.acaiza.abastracfactory.ISilla;
import edu.acaiza.abastracfactory.ISofa;

/**
 *
 * @author USUARIO
 */
public class ConcreteFactory1 extends AbstractFactory {

    private ISilla silla;
    private ISofa sofa;
    private IMesilla mesilla;

    @Override
    public ISofa getSofa() {
        if (sofa == null) {
            sofa = new Sofa1();

        }
        return sofa;
    }

    @Override
    public IMesilla getMesilla() {
        if (mesilla == null) {
            mesilla = new Mesilla1();

        }
        return mesilla;
    }

    @Override
    public ISilla getSilla() {
        if (silla == null) {
            silla = new Silla1();

        }
        return silla;
    }

    @Override
    public String toString() {
        return "ConcreteFactory1{" + "silla=" + silla + ", sofa=" + sofa + ", mesilla=" + mesilla + '}';
    }

}
