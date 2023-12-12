/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.caiza.abstractFactory.ten.young;

import edu.caiza.abstractFactory.AccountCard;

/**
 *
 * @author USUARIO
 */
public class YoungAccount implements AccountCard {

    @Override
    public String view() {
        return "Tiene 15 % de ineteres";
    }
    
    
}
