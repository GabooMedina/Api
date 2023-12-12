/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.acaiza.Factory;

import java.net.ConnectException;
import java.sql.Connection;

/**
 *
 * @author USUARIO
 */
public interface IDBAdapter {

    public Connection getConnection();

}
