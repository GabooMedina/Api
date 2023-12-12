/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.CreadorFactura;

import ejercicio2.Factura;
import ejercicio2.FacturaIVAReducido;

/**
 *
 * @author USUARIO
 */
public class CreadorFacturaIVAReducido extends FacturaCreador{

    @Override
    public Factura createFactura() {
        return new FacturaIVAReducido(2,30.00,0.07);
    }
    
}
