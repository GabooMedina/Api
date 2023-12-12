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
public class TenAccountFactory extends AccountFactory {

   private AccountCard accountCard ;
     private CreditCard crediCard ;
      private DebitCard debitCard ;
    
    public AccountCard getAccountCard() {
        if (accountCard == null) {
            accountCard =  new TenAccount();

        }
        return accountCard;
    }

   @Override
    public CreditCard getCreditCard() {
        if (crediCard == null) {
            crediCard =  new TenCreditCard();

        }
        return crediCard;
    }
   @Override
    public DebitCard getDebitCard() {
        if (debitCard == null) {
            debitCard =  new TenDebitCard();

        }
        return debitCard;
    }



    
}
