/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class conexion {
    private static conexion instance;
    private Connection connection;
    
    private conexion() {
        // Configurar la conexión a la base de datos
        String url = "jdbc:mysql://localhost/proyectoagua";
        String user = "root";
        String password = "";
        
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static conexion getInstance() {
        if (instance == null) {
            instance = new conexion();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
