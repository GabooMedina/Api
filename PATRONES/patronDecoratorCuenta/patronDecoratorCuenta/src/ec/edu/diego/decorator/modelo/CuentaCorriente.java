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
public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(int id, String cliente, double costo) {
        super(id, cliente, costo);
    }
    @Override
    public String getDescripcion() {
        return "cuenta de corriente, Cliente: " + this.cliente;
    }

    @Override
    public double getCosto() {
        System.out.println("Costo de la apertura de la cuenta " + this.costo);
        return costo;
    }
}
