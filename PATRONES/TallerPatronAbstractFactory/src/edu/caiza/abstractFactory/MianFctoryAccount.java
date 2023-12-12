/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory;

import edu.caiza.abstractFactory.ten.TenAccountFactory;
import edu.caiza.abstractFactory.ten.young.YoungAccountFactory;
import edu.caiza.abstractFactory.ten.young.gold.GoldAccountFactory;

/**
 *
 * @author USUARIO
 */
public class MianFctoryAccount {
    // TODO code application logic here
        public static void main(String[] args) {
        System.out.println("--FABRICA DE FAMILIA DE OBJETOS1--");
        AccountFactory.setAbstractFactory(new TenAccountFactory());
        AccountFactory miFabrica = AccountFactory.getAccountctFactory();

        System.out.println("CUENTA: " + miFabrica.getAccountCard().view());
        System.out.println("CREDITO: " + miFabrica.getCreditCard().view());
        System.out.println("DEBITO: " + miFabrica.getDebitCard().view());
        
        /////////////7
         System.out.println("--FABRICA DE FAMILIA DE OBJETOS2--");
    AccountFactory.setAbstractFactory(new YoungAccountFactory());
        AccountFactory miFabrica1 = AccountFactory.getAccountctFactory();

        System.out.println("CUENTA: " + miFabrica1.getAccountCard().view());
        System.out.println("CREDITO: " + miFabrica1.getCreditCard().view());
        System.out.println("DEBITO: " + miFabrica1.getDebitCard().view());
        /////////////7
         System.out.println("--FABRICA DE FAMILIA DE OBJETOS3--");
        AccountFactory.setAbstractFactory(new GoldAccountFactory());
        AccountFactory miFabrica2 = AccountFactory.getAccountctFactory();

        System.out.println("CUENTA: " + miFabrica2.getAccountCard().view());
        System.out.println("CREDITO " + miFabrica2.getCreditCard().view());
        System.out.println("DEBITO: " + miFabrica2.getDebitCard().view());
    
    }

}
