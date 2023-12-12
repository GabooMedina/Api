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
public class CuentaDecoradora implements ICuenta {

    protected ICuenta temporalCuenta;

    public CuentaDecoradora(ICuenta temporalCuenta) {
        this.temporalCuenta = temporalCuenta;
    }

    @Override
    public String getDescripcion() {
        return temporalCuenta.getDescripcion();
    }

    @Override
    public double getCosto() {
        return temporalCuenta.getCosto();
    }
}
