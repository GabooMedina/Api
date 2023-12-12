
package vehiculo;

/**
 *
 * @author jaevi
 */
public abstract class VehiculoIDecorator  implements IVehiculo{

    private IVehiculo vehiculo;

    public VehiculoIDecorator(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public IVehiculo getVehiculo() {
        return vehiculo;
    }
}
