/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.abastracfactory;

/**
 *
 * @author USUARIO
 */
public abstract class AbstractFactory {

    private static AbstractFactory abstractFactory;

    public static AbstractFactory getAbstractFactory() {
        return AbstractFactory.abstractFactory;
    }

    public static void setAbstractFactory(AbstractFactory abstractFactory) {
        AbstractFactory.abstractFactory = abstractFactory;
    }

    public abstract ISofa getSofa();

    public abstract IMesilla getMesilla();

    public abstract ISilla getSilla();

}


