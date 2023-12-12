package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAOJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class TestPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);

            }
            IPersonaDAO personaDAO = new PersonaDAOJDBC(conexion);

            //Seleccion de registros de mi DataBase
            List<PersonaDTO> personas = personaDAO.seleccionar();
            for (PersonaDTO persona : personas) {
                System.out.println("persona = " + persona);
            }

            //INSERTAR PERSONA
//            PersonaDTO personNueva = new PersonaDTO("Fernand", "Naranjo", "fnaranjoo@gmail.com", "0973737373");
//            personaDAO.insertar(personNueva);
//Actualizar una persona
            PersonaDTO cambioPersona = new PersonaDTO();
            cambioPersona.setIdPersona(3);
            cambioPersona.setNombre("Angel");
            cambioPersona.setApellido("Caiza");
            cambioPersona.setEmail("acaiza@gmail.com");
            cambioPersona.setTelefono("1234567812");
            personaDAO.actualizar(cambioPersona);
            conexion.commit();

//ELIMINAR UNA PERSONA DE LA BD
            PersonaDTO elimnar = new PersonaDTO(5);
            personaDAO.eliminar(elimnar);
            conexion.commit();
            System.out.println("SE HA EMILINADO");
            System.out.println("Se ha realizado un comit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Entramos al rolback");

            try {
                conexion.rollback();

            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);

            }

        }

    }
}
