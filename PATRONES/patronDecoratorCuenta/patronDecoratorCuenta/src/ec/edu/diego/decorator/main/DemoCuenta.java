/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.diego.decorator.main;

import ec.edu.diego.decorator.decoradora.PagosDecorador;
import ec.edu.diego.decorator.decoradora.SegurosDecorador;
import ec.edu.diego.decorator.inter.ICuenta;
import ec.edu.diego.decorator.modelo.Cuenta;
import ec.edu.diego.decorator.modelo.CuentaAhorros;
import ec.edu.diego.decorator.modelo.CuentaCorriente;

/**
 *
 * @author Asus
 */
public class DemoCuenta {

    public static void main(String[] args) {
        ICuenta cuentaAhorros = new CuentaAhorros(1, "JUAN PEREZ", 25);
        System.out.println("Cuenta: " + cuentaAhorros.getDescripcion());
        System.out.println("Costo Total; " + cuentaAhorros.getCosto());

        System.out.println("*****************************************");
        ICuenta cuentasSeguros = new SegurosDecorador(cuentaAhorros);
        System.out.println("Cuenta: " + cuentasSeguros.getDescripcion());
        System.out.println("Costo Total; " + cuentasSeguros.getCosto());

        System.out.println("*****************************************");
        ICuenta cuentasPagos = new SegurosDecorador(cuentasSeguros);
        System.out.println("Cuenta: " + cuentasPagos.getDescripcion());
        System.out.println("Costo Total; " + cuentasPagos.getCosto());
        System.out.println("*****************************************");
        System.out.println("**Cuenta Corriente**");
        ICuenta cuentaCorriente = new SegurosDecorador(new PagosDecorador(new CuentaCorriente(2, "Veronica", 50)));
        System.out.println("Cuenta: " + cuentaCorriente.getDescripcion());
        System.out.println("Costo Total: " + cuentaCorriente.getCosto());
    }
}
