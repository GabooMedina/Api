/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.prototype;

import java.util.Hashtable;

/**
 *
 * @author USUARIO
 */
public class RegistroVehiculos {

    private final Hashtable<String, IVehiculo> prototipos = new Hashtable<>();

    public RegistroVehiculos() {
        //Adicionar objetos de prototipos con valores iniciales
        Taxi taxi1 = new Taxi("Toyota", "1998", "1.6 C.C", "amarillo", 5);
        prototipos.put("Taxi", taxi1);
    }

    public void adicionaPrototipo(String llave, IVehiculo vehiculo) {
        prototipos.put(llave, vehiculo);
    }

    public IVehiculo obtenerPrototipo(String llave) {
        return prototipos.get(llave).clonar();
    }
}
