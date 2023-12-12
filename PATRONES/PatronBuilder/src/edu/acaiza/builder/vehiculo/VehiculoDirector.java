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
public class VehiculoDirector {

    private ConstructorVehiculo builder;

    public VehiculoDirector(ConstructorVehiculo builder) {
        this.builder = builder;
    }

    public void construirVehiculo() {
        this.builder.nuevoVehiculo();
        this.builder.definirVehiculo();
        this.builder.construirMotor();
        this.builder.construirCarroceria();
        this.builder.construirRuedas();
        this.builder.definirExtra();

    }

    public Vehiculo getVehiculo() {

        return builder.getVehiculo();
    }

}
