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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.sistema;

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

    public boolean existeProductos(String codigo) {
        try {
            // Preparar la consulta para verificar si la cédula ya existe en la base de datos
            PreparedStatement statement = (PreparedStatement) conec.prepareStatement("SELECT COUNT(*) FROM productos WHERE codigo = ?");

            //java.sql.PreparedStatement psd = conec.prepareStatement(sql);
            //String sql = "SELECT COUNT(*) FROM clientes WHERE cedula = ?";
            statement.setString(1, codigo);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Obtener el resultado
            resultSet.next();
            int count = resultSet.getInt(1);

            // Cerrar los recursos
            // resultSet.close();
            //statement.close();
            // Verificar si el cliente existe
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean RegistrarProductos(Productos cl) {

        try {

            if (existeProductos(cl.getCodigo())) {
                JOptionPane.showMessageDialog(null, "El producto ya existe ");
                sistema ss = new sistema();
                ss.nuevoP();

            } else {
                String sql = "INSERT INTO productos (codigo, nombre, stock, precio ) VALUES (?,?,?,?)";
                java.sql.PreparedStatement psd = conec.prepareStatement(sql);

                psd.setString(1, cl.getCodigo());
                psd.setString(2, cl.getNombre());
                psd.setInt(3, cl.getStock());
                psd.setDouble(4, cl.getPrecio());
                psd.execute();
                JOptionPane.showMessageDialog(null, "Producto Registrado con Exito");
            }
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
        } finally {

            try {
                conec.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
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

    public Productos BuscarId(int id) {
        Productos pro = new Productos();
        String sql = "SELECT * FROM productos WHERE id = ?";
        try {

            java.sql.PreparedStatement psd = conec.prepareStatement(sql);
            psd.setInt(1, id);
            rs = psd.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }

}
