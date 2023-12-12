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
import ejercicio6.abstractfactory.regalo.RegaloOro;
import ejercicio6.abstractfactory.tarjetacredito.TarjetaCreditoOro;
import ejercicio6.abstractfactory.tarjetadebito.TarjetaDebitoOro;
import ejercicio6.abstractfactory.tipocuenta.CuentaOro;

/**
 *
 * @author USUARIO
 */
public class FabricaCuentaOro implements FabricaAbstractTipoCuenta {

    private CuentaOro cuentaOro;
    private TarjetaDebitoOro tdebitoOro;
    private TarjetaCreditoOro tcreditoOro;
    private RegaloOro regaloOro;

    @Override
    public void crearCuenta() {
        cuentaOro = new CuentaOro();
        tdebitoOro = new TarjetaDebitoOro();
        tcreditoOro = new TarjetaCreditoOro();
        regaloOro = new RegaloOro();

    }

    @Override
    public ICuenta getCuenta() {
        return cuentaOro;
    }

    @Override
    public ITarjetaCredito getTarjetaCredito() {
        return tcreditoOro;
    }

    @Override
    public ITarjetaDebito getTarjetaDebito() {
        return tdebitoOro;
    }

    @Override
    public IRegalo getRegalo() {
        return regaloOro;

    }

}
