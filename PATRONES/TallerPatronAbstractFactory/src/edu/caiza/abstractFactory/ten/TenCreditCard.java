/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten;

import edu.caiza.abstractFactory.AccountCard;
import edu.caiza.abstractFactory.CreditCard;

/**
 *
 * @author USUARIO
 */
public class TenCreditCard implements CreditCard{

    @Override
    public String view() {
        return "Gratuito Max.600 : ";
    }

   
    
}
