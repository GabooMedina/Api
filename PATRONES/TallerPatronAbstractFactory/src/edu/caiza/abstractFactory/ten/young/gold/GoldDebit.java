/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten.young.gold;

import edu.caiza.abstractFactory.DebitCard;

/**
 *
 * @author USUARIO
 */
public class GoldDebit implements DebitCard {

    @Override
    public String view() {
        return "Cuesta  5 euros";
    }
    
}
