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
public class DemoBuilder {

    public static void main(String[] args) {
        VehiculoDirector directorAudi = new VehiculoDirector(new ConstructorVehiculoAudi());

        directorAudi.construirVehiculo();
        Vehiculo audiA3 = directorAudi.getVehiculo();
        System.out.println("******PRIMER VEHICULO******");
        System.out.println(audiA3.mostrarVehiculo());
        
        VehiculoDirector directorBMW = new VehiculoDirector(new ConstructorVehiculoAudi());
        
        directorBMW.construirVehiculo();
           Vehiculo BMW = directorBMW.getVehiculo();
        System.out.println("******PRIMER VEHICULO******");
           System.out.println(BMW.mostrarVehiculo());
        

    }
}
