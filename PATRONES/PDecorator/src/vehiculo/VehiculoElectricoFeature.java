/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author jaevi
 */
public class VehiculoElectricoFeature extends VehiculoIDecorator {

    public VehiculoElectricoFeature(IVehiculo vehiculo) {
        super(vehiculo);
    }
    
    @Override
    public void encender() {
        getVehiculo().encender();
        System.out.println(" Iniciando electricamente");
    }

    @Override
    public void acelerar() {
    getVehiculo().detenerse();
        System.out.println(" Iniciando sistema operativo");
    }

    @Override
    public void detenerse() {
    getVehiculo().detenerse();
        System.out.println(" Comprobando frenos electricos");
    }

}
