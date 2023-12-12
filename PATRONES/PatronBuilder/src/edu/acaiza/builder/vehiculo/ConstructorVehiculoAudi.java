/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.builder.vehiculo;

import edu.acaiza.builder.domain.Carroceria;
import edu.acaiza.builder.domain.MotorDissel;
import edu.acaiza.builder.domain.Ruedas;

/**
 *
 * @author USUARIO
 */
public class ConstructorVehiculoAudi extends ConstructorVehiculo {

    @Override
    public void definirVehiculo() {

        vehichulo.marca = "Audi";
        vehichulo.modelo = "A3 Sport";
    }

    @Override
    public void construirRuedas() {
        vehichulo.tipoRueda = new Ruedas();
        vehichulo.tipoRueda.setDiametro(17);
        vehichulo.tipoRueda.setLlantas("Aluminio");
        vehichulo.tipoRueda.setNeumatico("Michaleda");
    }

    @Override
    public void construirCarroceria() {
        vehichulo.tipoCarroceria = new Carroceria();
        vehichulo.tipoCarroceria.setTipoCarroceria("Deportivo");
        vehichulo.tipoCarroceria.setHabitaculosReforzados(true);
        vehichulo.tipoCarroceria.setMaterial("Fibra de Carbono");
        vehichulo.color = "Ploma";

    }

    @Override
    public void construirMotor() {
        vehichulo.motor = new MotorDissel();
        vehichulo.motor.setPotencia(3000);
        vehichulo.motor.setCilindraje(1600);
        
    }

    @Override
    public void definirExtra() {
        
        vehichulo.bloqueoCentralizado = true;
        vehichulo.direccionAsistida =true;
    }

}
