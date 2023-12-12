/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.providers;

import ec.edu.vichi.strategy.impl.IAutenticateStrategy;
import ec.edu.vichi.strategy.impl.Principal;
import ec.edu.vichi.strategy.util.MySQLDBAdapter;
import java.sql.*;

/**
 *
 * @author jaevi
 */
public class SQLAutenticationProvider implements IAutenticateStrategy {

    private static final String USER_QUERY = "SELECT userName,rol from users where userName='%s' and password = '%s'";
    private MySQLDBAdapter mysqlAdapter;

    public SQLAutenticationProvider() {
        mysqlAdapter = new MySQLDBAdapter();
    }

    @Override
    public Principal autenticate(String username, String password) {

        try {
            Connection connection = mysqlAdapter.getConnection();
            Statement statement = connection.createStatement();
            String queryUser = String.format(USER_QUERY, username, password);
            ResultSet query = statement.executeQuery(queryUser);
            while (query.next()) {
                return new Principal(query.getString("userName"),
                        query.getString("rol"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
