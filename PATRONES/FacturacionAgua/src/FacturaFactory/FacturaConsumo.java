/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaFactory;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class FacturaConsumo implements Factura{
    private String cedula;
    private String mes;
    private Date fecha;
    private String tipo;

    public FacturaConsumo(String cedula, String mes, Date fecha, String tipo) {
        this.cedula = cedula;
        this.mes = mes;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    @Override
    public Date obtenerFecha() {
        return fecha;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    @Override
    public String mes() {
        return mes;
    }

    @Override
    public String tipo() {
        return tipo;
    }
}
