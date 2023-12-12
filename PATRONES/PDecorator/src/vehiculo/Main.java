
package vehiculo;

/**
 *
 * @author jaevi
 */
public class Main {
    public static void main(String[] args) {
        IVehiculo carro;
        
        carro= new VehiculoEstandar("Chevy");
        carro.encender();
        carro.detenerse();
        carro.detenerse();
        
        System.out.println("");
        
        carro= new VehiculoElectricoFeature(new VehiculoEstandar("Chevy"));
        carro.encender();
        carro.detenerse();
        carro.detenerse();
    }
}
