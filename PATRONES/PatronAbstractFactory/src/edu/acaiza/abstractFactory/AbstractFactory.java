
package edu.acaiza.abstractFactory;


public abstract class AbstractFactory {

    private static AbstractFactory abstractFactory;

    public static AbstractFactory getAbstractFactory() {
        return AbstractFactory.abstractFactory;
    }

    public static void setAbstractFactory(AbstractFactory abstractFactory) {
        AbstractFactory.abstractFactory = abstractFactory;
    }
    
    public abstract  IProductA getProductA();
    public abstract  IProductB getProductB();


}
