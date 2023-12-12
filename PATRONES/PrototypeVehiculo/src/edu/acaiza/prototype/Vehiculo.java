/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

/**
 *
 * @author USUARIO
 */
public class Vehiculo implements IVehiculo {

   protected String marca;
   protected String modelo;
   protected String motor;
   protected  String color;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String motor, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", color=" + color;
    }

    @Override
    public IVehiculo clonar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
