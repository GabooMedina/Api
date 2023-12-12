/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class CuentaAH implements ICuentaPrototype {
    
    private String tipo;
    private double monto;
    
    public CuentaAH() {
        this.tipo = "AHORROS";
        
    }
    
    @Override
    public ICuentaPrototype clonar() {
        CuentaAH cuenta = null;
        try {
            cuenta = (CuentaAH) clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace(System.out);
        }
        return cuenta;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "CuentaAH{" + "tipo=" + tipo + ", monto=" + monto + '}';
    }
    
    
}
