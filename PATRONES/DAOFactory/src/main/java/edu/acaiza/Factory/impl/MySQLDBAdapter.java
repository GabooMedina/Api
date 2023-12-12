/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.Factory.impl;

import edu.acaiza.Factory.IDBAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLDBAdapter implements IDBAdapter {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }
}
