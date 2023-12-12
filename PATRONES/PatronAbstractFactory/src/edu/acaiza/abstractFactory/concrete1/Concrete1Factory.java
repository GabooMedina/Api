/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abstractFactory.concrete1;

import edu.acaiza.abstractFactory.AbstractFactory;
import edu.acaiza.abstractFactory.IProductA;
import edu.acaiza.abstractFactory.IProductB;

/**
 *
 * @author USUARIO
 */
public class Concrete1Factory extends AbstractFactory {

    private IProductA productA;
    private IProductB productB;

    @Override
    public IProductA getProductA() {
        if (productA == null) {
            productA =  new ProductA1();

        }
        return productA;
    }

    @Override
    public IProductB getProductB() {
        if (productB == null) {
            productB =  new ProductB1();

        }
        return productB;
    }

    @Override
    public String toString() {
        return "Concrete1Factory{" + '}';
    }
}
    
