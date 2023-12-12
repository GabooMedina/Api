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
public class FacturaFactory {
    
    public static Factura crearFactura(String tipo, String cedula, String mes, Date fecha, String tipofactura) {
        if (tipo.equalsIgnoreCase("riego")) {
            return new FacturaRiego(cedula, mes, fecha, tipofactura);
        } else if (tipo.equalsIgnoreCase("consumo")) {
            return new FacturaConsumo(cedula, mes, fecha, tipofactura);
        }
        return null; // Manejo de casos inválidos
    }
}
