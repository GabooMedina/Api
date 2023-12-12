/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.diego.decorator.modelo;

import ec.edu.diego.decorator.inter.ICuenta;

/**
 *
 * @author Asus
 */
public abstract class Cuenta implements ICuenta{

    private int id;
    protected String cliente;
    protected double costo;

    public Cuenta(int id, String cliente, double costo) {
        this.id = id;
        this.cliente = cliente;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    } 
}


