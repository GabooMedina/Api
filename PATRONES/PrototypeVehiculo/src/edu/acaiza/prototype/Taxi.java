/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

/**
 *
 * @author USUARIO
 */
public class Taxi extends Vehiculo {

    private int numPuertas;
    
    public Taxi(){
        
    }

    public Taxi(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Taxi(String marca, String modelo, String motor, String color, int numPuertas) {
        super(marca, modelo, motor, color);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Taxi{" + super.toString() +" numero de puertas"+ numPuertas + '}';
    }


    @Override
    public IVehiculo clonar(){
        Taxi clon =new Taxi();
        clon.setMarca(this.marca);
        clon.setModelo(this.modelo);
        clon.setMotor(this.motor);
        clon.setColor(this.color);
        clon.setNumPuertas(this.numPuertas);
        return clon;
    }
}
