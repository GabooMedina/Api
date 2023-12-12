/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author USUARIO
 */
public class FacturaIVAReducido extends Factura{
    private final double ivaReducido;

   public FacturaIVAReducido(int id, double importe, double iva) {
        super(id, importe);
        this.ivaReducido= iva;
    }

   

    @Override
    public double importe() {
        return getImporte() + (getImporte() * ivaReducido);
    }
    
    public double getIva() {
        return ivaReducido;
    }

    @Override
    public String toString() {
        return "FacturaIVA{" + "iva=" + ivaReducido + '}';
    }
    
}
