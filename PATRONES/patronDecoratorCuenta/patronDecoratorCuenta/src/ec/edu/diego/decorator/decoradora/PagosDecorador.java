/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.diego.decorator.decoradora;

import ec.edu.diego.decorator.inter.ICuenta;

/**
 *
 * @author Asus
 */
public class PagosDecorador extends CuentaDecoradora {

    public PagosDecorador(ICuenta temporalCuenta) {
        super(temporalCuenta);
    }

    @Override
    public String getDescripcion() {
        return temporalCuenta.getDescripcion() + ", Se agrego un pago de servicio";

    }

    @Override
    public double getCosto() {
        System.out.println("Costo del servicio: " + 0.50);
        return temporalCuenta.getCosto() + 0.50;
    }
}
