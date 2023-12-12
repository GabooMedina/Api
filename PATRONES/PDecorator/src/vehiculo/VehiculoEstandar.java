
package vehiculo;

public class VehiculoEstandar implements IVehiculo{

    private String nombre;

    public VehiculoEstandar(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void encender() {
        System.out.println("Encenciando el carro");}

    @Override
    public void acelerar() {
        System.out.println("Aceleracion estandar");}

    @Override
    public void detenerse() {
        System.out.println("Deteniendo carro");}
    
}
