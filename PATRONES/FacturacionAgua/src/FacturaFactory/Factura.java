/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaFactory;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public interface Factura {
    
    Date obtenerFecha();
    String getCedula();
    String mes();
    String tipo();
}
