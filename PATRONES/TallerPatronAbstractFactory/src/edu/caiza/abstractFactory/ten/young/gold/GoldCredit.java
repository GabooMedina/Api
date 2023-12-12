/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten.young.gold;

import edu.caiza.abstractFactory.AccountCard;
import edu.caiza.abstractFactory.CreditCard;

/**
 *
 * @author USUARIO
 */
public class GoldCredit implements CreditCard {

    @Override
    public String view() {
        return " Tienes 2 % de interes";
        
    }
    
    
}
