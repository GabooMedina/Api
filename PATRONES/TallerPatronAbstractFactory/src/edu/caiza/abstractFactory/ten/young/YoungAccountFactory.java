/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten.young;

import edu.caiza.abstractFactory.AccountCard;
import edu.caiza.abstractFactory.AccountFactory;
import edu.caiza.abstractFactory.CreditCard;
import edu.caiza.abstractFactory.DebitCard;
import edu.caiza.abstractFactory.ten.TenAccount;
import edu.caiza.abstractFactory.ten.TenCreditCard;
import edu.caiza.abstractFactory.ten.TenDebitCard;

/**
 *
 * @author USUARIO
 */
public class YoungAccountFactory  extends AccountFactory {
    private AccountCard accountCard ;
     private CreditCard crediCard ;
      private DebitCard debitCard ;
    
    public AccountCard getAccountCard() {
        if (accountCard == null) {
            accountCard =  new YoungAccount();

        }
        return accountCard;
    }

   @Override
    public CreditCard getCreditCard() {
        if (crediCard == null) {
            crediCard =  new YoungCredit();

        }
        return crediCard;
    }
   @Override
    public DebitCard getDebitCard() {
        if (debitCard == null) {
            debitCard =  new YoungDebit();

        }
        return debitCard;
    }
}
