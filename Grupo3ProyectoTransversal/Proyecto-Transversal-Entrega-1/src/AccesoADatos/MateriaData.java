/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.Materia;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Ezequiel
 */
public class MateriaData {

    private Connection conn = null;

    public MateriaData() {
        conn = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO `materia`(`nombre`, `anio`, `estado`) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                System.out.println("Materia guardada en la base de datos");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }

    }

    public void buscarMateria(int id) {
        String sql = "SELECT * "
                + "FROM materia "
                + "WHERE idMateria = ?";

        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Datos de la Materia:");
                System.out.println("ID: " + rs.getInt("idMateria"));
                System.out.println("DNI: " + rs.getString("nombre"));
                System.out.println("Nombre: " + rs.getInt("anio"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }

    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?,anio = ?, estado = ?"
                + " WHERE idMateria = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                System.out.println("Materia guardada en la base de datos");
            }
            ps.close();
            System.out.println("Alumno modificado");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE materia SET estado = 0 "
                + "WHERE idMateria = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia dada de baja");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }
    }

    public void AltaLogica(int id) {
        String sql = "UPDATE materia SET estado = 1 "
                + "WHERE idMateria = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia dada de alta");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }
    }

}
