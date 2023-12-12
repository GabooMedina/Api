/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.Factory.impl;

import edu.acaiza.Factory.IDBAdapter;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class PostgreDBAdapter implements IDBAdapter{
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private final String USER = "postgres";
    private final String PASS = "admin";
    
    @Override
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
        
    }
}
