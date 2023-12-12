/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ClienteDAO {

    Conexion cc = new Conexion();
    Connection conec = cc.conectar();
    ResultSet rs;

    public boolean RegistrarCliente(Clientes cl) {

        try {
            String sql = "INSERT INTO clientes (cedula, nombre, apellido, telefono, direccion) VALUES (?,?,?,?,?)";
            java.sql.PreparedStatement psd = conec.prepareStatement(sql);

            psd.setString(1, cl.getCedula());
            psd.setString(2, cl.getNombre());
             psd.setString(3, cl.getApellido());
            psd.setString(4, cl.getTelefono());
            psd.setString(5, cl.getDireccion());
            psd.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {

        }
    }

    public List ListarCliente() {
        List<Clientes> ListaCl = new ArrayList();
        try {
            String sql = "SELECT * FROM clientes";
            Statement psd = conec.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                Clientes cl = new Clientes();
                cl.setId(rs.getInt("id"));
                cl.setCedula(rs.getString("cedula"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellido(rs.getString("apellido"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;

    }

    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try {

            java.sql.PreparedStatement psd = conec.prepareStatement(sql);
            psd.setInt(1, id);
            psd.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
//        } finally {
//
//            try {
//                conec.close();
//            } catch (SQLException ex) {
//                System.out.println(ex.toString());
//            }
//        }
        }
    }

    public boolean ModificarCliente(Clientes cl) {
        String sql = "UPDATE clientes SET cedula=?, nombre=?,apellido=?, telefono=?, direccion=? WHERE id=?";
        try {
            java.sql.PreparedStatement psd = conec.prepareStatement(sql);
            psd.setString(1, cl.getCedula());
            psd.setString(2, cl.getNombre());
            psd.setString(3, cl.getApellido());
            psd.setString(4, cl.getTelefono());
            psd.setString(5, cl.getDireccion());
            psd.setInt(6, cl.getId());
            psd.execute();
            return true;
        } catch (SQLException e) {
//            System.out.println(e.toString());
//            return false;
//        } finally {
//            try {
//                conec.close();
//            } catch (SQLException e) {
//                System.out.println(e.toString());
//            }
//        }
        }
        return false;
    }

   
}
