/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaFactory;

import PatronSingleton.conexion;
import PersonaDao.User;
import PersonaDao.UserDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class FacturaDao {

    private Connection connection;

    UserDAO personaDAO;

    public FacturaDao() {
        connection = conexion.getInstance().getConnection();
    }

    public void guardarFactura(Factura factura) {
        try {
            String query = "INSERT INTO facturas (tipo, id_cliente, fecha) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, factura.getClass().getSimpleName());
//            statement.setInt(2, factura.getIdCliente()); // Supongamos que la factura tiene un campo "idCliente"
            statement.setDate(3, new java.sql.Date(factura.obtenerFecha().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cobrarDosTiposFacturas(Factura factura) {
        try {
            String sql = "UPDATE FACTURAS SET EST_FACT='PAGADO', FEC_PAGO='" + factura.obtenerFecha() + "' WHERE ID_LEC_PER = (SELECT ID_LEC\n"
                    + "FROM LECTURAS\n"
                    + "WHERE CED_USU_PER='" + factura.getCedula() + "'\n"
                    + "AND MES_CON='" + factura.mes() + "'\n"
                    + "AND TIPO_LEC='CONSUMO')";
            PreparedStatement psd = connection.prepareStatement(sql);
            psd.executeUpdate();

            String sqlI = "UPDATE FACTURAS SET EST_FACT='PAGADO', FEC_PAGO='" + factura.obtenerFecha() + "' WHERE ID_LEC_PER = (SELECT ID_LEC\n"
                    + "FROM LECTURAS\n"
                    + "WHERE CED_USU_PER='" + factura.getCedula() + "'\n"
                    + "AND MES_CON='" + factura.mes() + "'\n"
                    + "AND TIPO_LEC='RIEGO')";
            PreparedStatement psdi = connection.prepareStatement(sqlI);
            psdi.executeUpdate();

            Map fec = new HashMap();
            fec.put("cedula", factura.getCedula());
            fec.put("fecha", factura.mes());
            JasperReport reporte;
            reporte = JasperCompileManager.compileReport("C:/reportesAgua/facturaMaestro.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, fec, connection);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void cobrarFacturaConsumoRiego(Factura factura) {
        try {
            String sql = "UPDATE FACTURAS SET EST_FACT='PAGADO', FEC_PAGO='" + factura.obtenerFecha() + "' WHERE ID_LEC_PER = (SELECT ID_LEC\n"
                    + "FROM LECTURAS\n"
                    + "WHERE CED_USU_PER='" + factura.getCedula() + "'\n"
                    + "AND MES_CON='" + factura.mes() + "'\n"
                    + "AND TIPO_LEC='" + factura.tipo() + "')";
            PreparedStatement psd = connection.prepareStatement(sql);
            psd.executeUpdate();

            Map fec = new HashMap();
            fec.put("cedula", factura.getCedula());
            fec.put("tipo", factura.tipo());
            fec.put("mes", factura.mes());
            JasperReport reporte;
            reporte = JasperCompileManager.compileReport("C:/reportesAgua/facturaIndividual.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, fec, connection);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
}
