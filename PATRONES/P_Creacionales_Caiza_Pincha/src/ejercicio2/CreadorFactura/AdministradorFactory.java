/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.CreadorFactura;

import ejercicio2.Factura;

/**
 *
 * @author USUARIO
 */
public class AdministradorFactory {
    private Factura factura;
    private FacturaCreador creador;

    public AdministradorFactory(FacturaCreador creador) {
        this.creador = creador;
    }
  
    public void createFactura(){
        this.factura = this.creador.createFactura();
    }
    public Factura getFactura(){
        return factura;
    }
    
}
