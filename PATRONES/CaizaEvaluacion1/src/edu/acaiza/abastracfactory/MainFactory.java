/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abastracfactory;

import edu.acaiza.abastracfactory.concrete1.ConcreteFactory1;
import edu.acaiza.abastracfactory.concrete3.Concrete2;

/**
 *
 * @author USUARIO
 */
public class MainFactory {

    public static void main(String[] args) {
        System.out.println("----FABRICA DE FAMILIA PRODUCTO 1 -----");
        AbstractFactory.setAbstractFactory(new ConcreteFactory1());
        AbstractFactory miFabrica = AbstractFactory.getAbstractFactory();

        System.out.println("Silla >=" + miFabrica.getSilla().view());

        System.out.println("Mesilla  >= " + miFabrica.getMesilla().view());
        System.out.println("Sofa >= " + miFabrica.getSofa().view());
        
          System.out.println("----FABRICA DE FAMILIA PRODUCTO 2 -----");
        AbstractFactory.setAbstractFactory(new Concrete2());
        AbstractFactory miFabrica1 = AbstractFactory.getAbstractFactory();

        System.out.println("Silla >=" + miFabrica1.getSilla().view());

        System.out.println("Mesilla  >= " + miFabrica1.getMesilla().view());
        System.out.println("Sofa >= " + miFabrica1.getSofa().view());

    }

}
