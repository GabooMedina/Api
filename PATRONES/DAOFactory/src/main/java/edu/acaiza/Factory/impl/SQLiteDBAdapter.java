/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.Factory.impl;

import edu.acaiza.Factory.IDBAdapter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USUARIO
 */
public class SQLiteDBAdapter implements IDBAdapter {

    private final String STR_DRIVER = "org.sqlite.JDBC";
    private final String DB_URL = "jdbc:sqlite:test.db";

    @Override
    public Connection getConnection() {
        try {
            Class.forName(STR_DRIVER);
            return DriverManager.getConnection(DB_URL);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }

    }
}


