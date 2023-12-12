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
import ejercicio6.abstractfactory.regalo.Regalo10;
import ejercicio6.abstractfactory.regalo.RegaloJoven;
import ejercicio6.abstractfactory.tarjetadebito.TarjetaDebitoJoven;
import ejercicio6.abstractfactory.tipocuenta.CuentaJoven;

/**
 *
 * @author USUARIO
 */
public class FabricaCuentaJoven implements FabricaAbstractTipoCuenta {

    private CuentaJoven cuentaJoven;
    private TarjetaDebitoJoven tdebitoJoven;
    private RegaloJoven regaloJoven;

    @Override
    public void crearCuenta() {
        cuentaJoven = new CuentaJoven();
        tdebitoJoven = new TarjetaDebitoJoven();
        regaloJoven = new RegaloJoven();

    }

    @Override
    public ICuenta getCuenta() {
        return cuentaJoven;
    }

    @Override
    public ITarjetaCredito getTarjetaCredito() {
        return null;
    }

    @Override
    public ITarjetaDebito getTarjetaDebito() {
        return tdebitoJoven;
    }

    @Override
    public IRegalo getRegalo() {
        return regaloJoven;
    }

}
