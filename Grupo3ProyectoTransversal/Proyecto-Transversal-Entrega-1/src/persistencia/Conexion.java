/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import org.mariadb.jdbc.Connection;
import java.sql.*;


/**
 *
 * @author Ezequiel
 */
public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "universidad";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al intentar conectarse con la base de datos");

        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse con la base de datos");

        }
        return connection;
    }
}
