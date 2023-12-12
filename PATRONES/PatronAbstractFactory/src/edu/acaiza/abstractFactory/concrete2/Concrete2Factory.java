/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abstractFactory.concrete2;

import edu.acaiza.abstractFactory.AbstractFactory;
import edu.acaiza.abstractFactory.IProductA;
import edu.acaiza.abstractFactory.IProductB;
import edu.acaiza.abstractFactory.concrete1.ProductA1;
import edu.acaiza.abstractFactory.concrete1.ProductB1;

/**
 *
 * @author USUARIO
 */
public class Concrete2Factory extends AbstractFactory{
      private IProductA productA;
    private IProductB productB;

    @Override
    public IProductA getProductA() {
        if (productA == null) {
            productA = new ProductA2();

        }
        return productA;
    }

    @Override
    public IProductB getProductB() {
        if (productB == null) {
            productB =   new ProductB2();

        }
        return productB;
    }

    @Override
    public String toString() {
        return "Concrete1Factory{" + '}';
    }
    
}
