/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory;

/**
 *
 * @author USUARIO
 */
public  abstract class  AccountFactory {
     private static AccountFactory  accountFactory;
    
     public static AccountFactory getAccountctFactory() {
        return AccountFactory.accountFactory;
    }
     public static void setAbstractFactory(AccountFactory accountFactory) {
        AccountFactory.accountFactory = accountFactory;
    }
     public abstract  AccountCard getAccountCard ();
    public abstract  CreditCard getCreditCard ();
     public abstract  DebitCard getDebitCard ();
}
