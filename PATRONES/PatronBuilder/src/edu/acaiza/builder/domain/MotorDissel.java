/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.builder.domain;

/**
 *
 * @author USUARIO
 */
public class MotorDissel implements IMotor {

    int cilindraje = 0;
    int potencia = 0;

    @Override
    public void setPotencia(int potencia) {
     this.potencia= potencia;
    }

    @Override
    public void setCilindraje(int cilindraje) {
       this.cilindraje=cilindraje;
    }

    @Override
    public String getDefinicionMotor() {
        return "CILINDRAJE" + this.cilindraje + "POTENCIA " + this.potencia;
    }

    @Override
    public String consumirCombutible() {
        return "Motor Disel : Realiza combustion de Gasolina";
        
    }

    @Override
    public String inyectarCombustible(int cantidad) {
        return String.format("Motor Disel: Inyectando %d ml. de Gasoil", cantidad);
    }

}
