/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

/**
 *
 * @author USUARIO
 */
public class Autobus extends Vehiculo {

    private int numPasajeros;

    public Autobus() {
        {

        }
    }

    public Autobus(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public Autobus(String marca, String modelo, String motor, String color, int numPasajeros) {
        super(marca, modelo, motor, color);
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
        return "Autobus{" +super.toString()+ "numPasajeros=" + numPasajeros + '}';
    }

    @Override
    public IVehiculo clonar() {
        Autobus clon = new Autobus();
        clon.setMarca(this.marca);
        clon.setModelo(this.modelo);
        clon.setMotor(this.motor);
        clon.setColor(this.color);
        clon.setNumPasajeros(this.numPasajeros);
        return clon;
    }

}
