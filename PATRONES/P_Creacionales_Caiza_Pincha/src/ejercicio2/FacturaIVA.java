/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author USUARIO
 */
public class FacturaIVA extends Factura{
    private final double iva;

    public FacturaIVA(int id, double importe, double iva) {
        super(id, importe);
        this.iva= iva;
    }

    @Override
    public double importe() {
        return getImporte() + (getImporte()*iva);
    }

    public double getIva() {
        return iva;
    }

    @Override
    public String toString() {
        return "FacturaIVA{" + "iva=" + iva + '}';
    }
    
    
}
