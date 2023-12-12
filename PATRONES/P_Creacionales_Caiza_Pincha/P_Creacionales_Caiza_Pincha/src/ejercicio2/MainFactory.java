/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import ejercicio2.CreadorFactura.AdministradorFactory;
import ejercicio2.CreadorFactura.CreadoFacturaIva;
import ejercicio2.CreadorFactura.CreadorFacturaIVAReducido;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class MainFactory {

    public static void main(String[] args) {
        String facturaType = JOptionPane.showInputDialog(null, "Tipo de Factura:", "Facturas", 2);
        AdministradorFactory facturaManager = null;
        if (facturaType.equalsIgnoreCase("iva")) {
            facturaManager = new AdministradorFactory(new CreadoFacturaIva());
        } else if (facturaType.equalsIgnoreCase("iva reducido")) {
            facturaManager = new AdministradorFactory(new CreadorFacturaIVAReducido());
        }

        if (facturaManager != null) {
            facturaManager.createFactura();
            //System.out.println(facturaManager.getFactura().importe());
            JOptionPane.showMessageDialog(null, facturaManager.getFactura().importe());
        }
    }
}
