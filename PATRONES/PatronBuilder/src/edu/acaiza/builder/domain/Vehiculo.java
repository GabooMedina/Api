/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.builder.domain;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {

    public String color;
    public String marca;
    public String modelo;
    public IMotor motor;
    public Ruedas tipoRueda;
    public Carroceria carroceria;
    public Carroceria tipoCarroceria;
    public boolean bloqueoCentralizado;
    public boolean direccionAsistida;

    public String mostrarVehiculo() {
        StringBuilder sb = new StringBuilder();
        String nl = System.getProperty("line.separator");
        sb.append("El presente vehiculo es un:").append("marca").append(" ").append(modelo);
        sb.append(" estilo ").append(tipoCarroceria.getTipoCarroceria()).append(nl);
        sb.append("Color: ").append(color).append(nl);
        sb.append(direccionAsistida ? "Con " : ":Sin ").append("Direccion asistida").append(nl);
        sb.append(bloqueoCentralizado ? "Con " : ":Sin ").append("Bloqueo centralizado").append(nl);
        sb.append("Carroceria de: ").append(tipoCarroceria.getMaterial());
        sb.append(tipoCarroceria.isHabitaculosReforzados() ? ":Con " : ":Sin ").append("Con el habitaculo Reforzado").append(nl);
        sb.append("Ruedas con llantas: ").append(tipoRueda.getLlantas()).append(" de ").append(tipoRueda.getDiametro())
                .append(" cm ").append(nl);
        sb.append("Neumatico: ").append(tipoRueda.getNeumatico()).append(nl);
        sb.append("Motor: ").append(motor.getDefinicionMotor()).append(nl);
        sb.append("Respuesta del motor: ").append(motor.inyectarCombustible(100));
        return sb.toString();
    }

}
