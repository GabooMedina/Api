/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.util;

import java.sql.*;

/**
 *
 * @author jaevi
 */
public class MySQLDBAdapter {
       private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
  
    
    public Connection getConnection(){
        try {
             Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             System.out.println("Connection class ==> "
                + connection.getClass().getName());
        return connection;
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
            return null;
        }
    }

}
