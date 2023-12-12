/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten;

import edu.caiza.abstractFactory.AccountCard;
import edu.caiza.abstractFactory.AccountFactory;
import edu.caiza.abstractFactory.CreditCard;
import edu.caiza.abstractFactory.DebitCard;

/**
 *
 * @author USUARIO
 */
public class TenAccount implements AccountCard {

   

    @Override
    public String view() {
       return "Tiene 1 % interes ";
    }
    
}
