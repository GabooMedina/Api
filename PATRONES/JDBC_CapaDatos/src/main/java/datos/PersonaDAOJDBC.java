/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.*;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PersonaDAOJDBC implements IPersonaDAO {

    private Connection conexion;

    private static final String SQL_SELECT = "SELECT idpersona , nombre, apellido , email , telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO persona ( nombre, apellido , email , telefono ) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?,email=?,telefono=? WHERE idpersona = ?";
    private static final String SQL_DELETE=  "DELETE FROM persona  WHERE idpersona=? ";
    

    public PersonaDAOJDBC() {

    }

    public PersonaDAOJDBC(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<PersonaDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = this.conexion != null ? this.conexion : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }

        } finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexion == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return personas;
        }
    }

    @Override
    public int insertar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexion != null ? this.conexion : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();

        } finally {
            try {

                close(stmt);
                if (this.conexion == null) {
                    close(conn);
                }
            } catch (SQLDataException ex) {
                ex.printStackTrace();
            }
        }
        return registros;
    }

    @Override
    public int actualizar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexion != null ? this.conexion : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexion == null) {
                    close(conn);
                }
            } catch (SQLDataException ex) {
                ex.printStackTrace();
            }
        }
        return registros;
    }

    @Override
    public int eliminar(PersonaDTO persona) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexion != null ? this.conexion : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
          
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexion == null) {
                    close(conn);
                }
            } catch (SQLDataException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
       
    }

