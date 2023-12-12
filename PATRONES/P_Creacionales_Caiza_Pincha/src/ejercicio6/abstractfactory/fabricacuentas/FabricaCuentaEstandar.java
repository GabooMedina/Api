/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.fabricacuentas;

import ejercicio6.abstractfactory.FabricaAbstractTipoCuenta;
import ejercicio6.abstractfactory.ICuenta;
import ejercicio6.abstractfactory.IRegalo;
import ejercicio6.abstractfactory.ITarjetaCredito;
import ejercicio6.abstractfactory.ITarjetaDebito;
import ejercicio6.abstractfactory.tarjetadebito.TarjetaDebitoEstandar;
import ejercicio6.abstractfactory.tipocuenta.CuentaEstandar;

/**
 *
 * @author USUARIO
 */
public class FabricaCuentaEstandar implements FabricaAbstractTipoCuenta {

    private CuentaEstandar cuentaEstandar;
    private TarjetaDebitoEstandar tdebitoEstandar;

    @Override
    public void crearCuenta() {
        cuentaEstandar = new CuentaEstandar();
        tdebitoEstandar = new TarjetaDebitoEstandar();
    }

    @Override
    public ICuenta getCuenta() {
        return cuentaEstandar;
    }

    @Override
    public ITarjetaCredito getTarjetaCredito() {
        return null;
    }

    @Override
    public ITarjetaDebito getTarjetaDebito() {
        return  tdebitoEstandar;
    }

    @Override
    public IRegalo getRegalo() {
        return null;
    }

}
