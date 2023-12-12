/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Conexion {
       Connection con;
       public Connection conectar( ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ventas2", "root", "");
            System.out.println("estas conectado");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return con;
    }
    
}
