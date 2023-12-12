/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.builder.vehiculo;

import edu.acaiza.builder.domain.Vehiculo;

/**
 *
 * @author USUARIO
 */
public abstract class ConstructorVehiculo {

    protected Vehiculo vehichulo;

    public void nuevoVehiculo() {
        vehichulo = new Vehiculo();

    }

    public Vehiculo getVehiculo() {
        return this.vehichulo;
    }

    //Region de los metodos abstractos
    public abstract void definirVehiculo();

    public abstract void construirRuedas();

    public abstract void construirCarroceria();

    public abstract void construirMotor();

    public abstract void definirExtra();

}
