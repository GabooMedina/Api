/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.builder.vehiculo;

import edu.acaiza.builder.domain.Carroceria;
import edu.acaiza.builder.domain.MotorDissel;
import edu.acaiza.builder.domain.MotorGasolina;
import edu.acaiza.builder.domain.Ruedas;

/**
 *
 * @author USUARIO
 */
public class ConstructorVehiculoBMW extends ConstructorVehiculo {

    @Override

    public void definirVehiculo() {

        vehichulo.marca = "BMW";
        vehichulo.modelo = "BMW Serie 5 ";
    }

    @Override
    public void construirRuedas() {
        vehichulo.tipoRueda = new Ruedas();
        vehichulo.tipoRueda.setDiametro(17);
        vehichulo.tipoRueda.setLlantas("Hierro");
        vehichulo.tipoRueda.setNeumatico("Fireston");
    }

    @Override
    public void construirCarroceria() {
        vehichulo.tipoCarroceria = new Carroceria();
        vehichulo.tipoCarroceria.setTipoCarroceria("Monovalente ");
        vehichulo.tipoCarroceria.setHabitaculosReforzados(true);
        vehichulo.tipoCarroceria.setMaterial("Fibra de Acero");
        vehichulo.color = "Negro";

    }

    @Override
    public void construirMotor() {
        vehichulo.motor = new MotorGasolina();
        vehichulo.motor.setPotencia(560);
        vehichulo.motor.setCilindraje(4300);

    }

    @Override
    public void definirExtra() {

        vehichulo.bloqueoCentralizado = true;
        vehichulo.direccionAsistida = false;
    }

}
