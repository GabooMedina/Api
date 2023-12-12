/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ProductosDAO extends JFrame {

    Conexion cc = new Conexion();
    Connection conec = cc.conectar();
    ResultSet rs;

    public Productos BuscarPro(String cod) {
        Productos producto = new Productos();
        try {

            String sql = "SELECT * FROM productos WHERE codigo = ?";
            java.sql.PreparedStatement psd = conec.prepareStatement(sql);
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

            }
            return producto;
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    public boolean RegistrarProductos(Productos cl) {

        try {
            String sql = "INSERT INTO productos (codigo, nombre, stock, precio ) VALUES (?,?,?,?)";
            java.sql.PreparedStatement psd = conec.prepareStatement(sql);

            psd.setString(1, cl.getCodigo());
            psd.setString(2, cl.getNombre());
            psd.setInt(3, cl.getStock());
            psd.setDouble(4, cl.getPrecio());

            psd.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {

        }
    }

    public List ListarProductos() {
        List<Productos> ListaPro = new ArrayList();
        try {
            String sql = "SELECT * FROM productos";
            Statement psd = conec.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                Productos pl = new Productos();
                pl.setId(rs.getInt("id"));
                pl.setCodigo(rs.getString("codigo"));
                pl.setNombre(rs.getString("nombre"));
                pl.setStock(rs.getInt("stock"));
                pl.setPrecio(rs.getDouble("precio"));
                ListaPro.add(pl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPro;

    }

    public boolean EliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

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

    public boolean ModificarProducto(Productos cl) {
        String sql = "UPDATE productos SET codigo=?, nombre=?,stock=?, precio=? WHERE id=?";
        try {
            java.sql.PreparedStatement psd = conec.prepareStatement(sql);

            psd.setString(1, cl.getCodigo());
            psd.setString(2, cl.getNombre());
            psd.setInt(3, cl.getStock());
            psd.setDouble(4, cl.getPrecio());
            psd.setInt(5, cl.getId());

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
