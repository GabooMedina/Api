/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.diego.decorator.modelo;

/**
 *
 * @author Asus
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(int id, String cliente, double costo) {
        super(id, cliente, costo);
    }
    //componente concreto

    @Override
    public String getDescripcion() {
        return "cuenta de ahorros, Cliente: " + this.cliente;

    }

    @Override
    public double getCosto() {
        System.out.println("Costo de la apertura de la cuenta " + this.costo);
        return costo;
    }
}
