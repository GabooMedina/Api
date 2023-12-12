/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonaDao;

import PatronSingleton.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = conexion.getInstance().getConnection();
    }

    public void addUser(User user) {
        // Insertar un nuevo usuario en la base de datos
        String query = "INSERT INTO usuarios (CED_USU, NOM_USU, APE_USU, TEL_USU, ESTADO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getCedula());
            statement.setString(2, user.getNombre());
            statement.setString(3, user.getApellido());
            statement.setString(4, user.getTelefono());
            statement.setString(5, user.getEstado());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        // Obtener todos los usuarios de la base de datos
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM usuarios WHERE estado='A' ORDER BY APE_USU ASC";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String cedula = resultSet.getString("CED_USU");
                String nombre = resultSet.getString("NOM_USU");
                String apellido = resultSet.getString("APE_USU");
                String telefono = resultSet.getString("TEL_USU");

                User user = new User(cedula, nombre, apellido, telefono);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM usuarios WHERE CED_USU = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String cedula = resultSet.getString("CED_USU");
                    String nombre = resultSet.getString("NOM_USU");
                    String apellido = resultSet.getString("APE_USU");
                    String telefono = resultSet.getString("TEL_USU");

                    return new User(cedula, nombre, apellido, telefono);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateUser(User user) {
        String query = "UPDATE usuarios SET NOM_USU = ? , APE_USU = ? , TEL_USU = ? WHERE CED_USU = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getTelefono());
            statement.setString(4, user.getCedula());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userId) {
        String query = "UPDATE usuarios SET ESTADO = ? WHERE CED_USU = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "P");
            statement.setString(2, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
