/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.CreadorFactura;

import ejercicio2.Factura;
import ejercicio2.FacturaIVA;

/**
 *
 * @author USUARIO
 */
public class CreadoFacturaIva extends FacturaCreador{

    @Override
    public Factura createFactura() {
        return new FacturaIVA(1,30.00,0.12);
    }
    
}
