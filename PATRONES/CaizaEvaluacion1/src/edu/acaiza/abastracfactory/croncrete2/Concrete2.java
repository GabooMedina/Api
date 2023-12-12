/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abastracfactory.croncrete2;

import edu.acaiza.abastracfactory.AbstractFactory;
import edu.acaiza.abastracfactory.IMesilla;
import edu.acaiza.abastracfactory.ISilla;
import edu.acaiza.abastracfactory.ISofa;
import edu.acaiza.abastracfactory.concrete1.Mesilla1;
import edu.acaiza.abastracfactory.concrete1.Silla1;
import edu.acaiza.abastracfactory.concrete1.Sofa1;

/**
 *
 * @author USUARIO
 */
public class Concrete2 extends AbstractFactory {
    
    private ISilla silla;
    private ISofa sofa;
    private IMesilla mesilla;

    @Override
    public ISofa getSofa() {
        
        if (this.sofa==null) {
            sofa=new Sofa1();
        }
       return sofa;
    }

    @Override
    public IMesilla getMesilla() {
        if (this.mesilla==null) {
            mesilla = new Mesilla1();
        }
        return mesilla;
    }

    @Override
    public ISilla getSilla() {
         if (this.silla==null) {
            silla = new Silla1();
        }
        return silla;
    }
    
}
