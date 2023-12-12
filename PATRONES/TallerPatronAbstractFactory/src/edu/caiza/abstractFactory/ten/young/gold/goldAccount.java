/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten.young.gold;

import edu.caiza.abstractFactory.AccountCard;

/**
 *
 * @author USUARIO
 */
public class goldAccount implements AccountCard  {

    @Override
    public String view() {
        return "20 euros Max ,4000 euros";
    }
    
}
