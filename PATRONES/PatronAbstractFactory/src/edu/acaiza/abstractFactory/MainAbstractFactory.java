/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abstractFactory;

import edu.acaiza.abstractFactory.concrete1.Concrete1Factory;
import edu.acaiza.abstractFactory.concrete2.Concrete2Factory;

/**
 *
 * @author USUARIO
 */
public class MainAbstractFactory {

    public static void main(String[] args) {
        System.out.println("----FABRICA DE FAMILIA PRODUCTO 1 -----");
        AbstractFactory.setAbstractFactory(new Concrete1Factory());
        AbstractFactory miFabrica = AbstractFactory.getAbstractFactory();
        
        System.out.println("Poducto A :" + miFabrica.getProductA().view());
                
       System.out.println("Poducto B :" + miFabrica.getProductB().view());
        System.out.println("*************************************");
        
        System.out.println("----FABRICA DE FAMILIA PRODUCTO 2 -----");
        AbstractFactory.setAbstractFactory(new Concrete2Factory());
        AbstractFactory miFabrica2 = AbstractFactory.getAbstractFactory();
        
        System.out.println("Poducto A :" + miFabrica2.getProductA().view());
                
       System.out.println("Poducto B :" + miFabrica2.getProductB().view());
        
    }
}
