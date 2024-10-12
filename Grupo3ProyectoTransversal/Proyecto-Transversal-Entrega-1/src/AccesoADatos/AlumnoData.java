/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidades.Alumno;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Ezequiel
 */
public class AlumnoData {

    private Connection conn = null;

    public AlumnoData() {
        conn = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        try {

            String sql = "INSERT INTO alumnos( `dni`, `nombre`, `apellido`, `fechaNac`, `estado`) "
                    + "VALUES (?,?,?,?,?)";

            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getNombre());
                ps.setString(3, alumno.getApellido());
                ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
                ps.setBoolean(5, alumno.isEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    alumno.setIdAlumno(rs.getInt(1));
                    System.out.println("Alumno guardado en la base de datos");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET dni = ?,apellido = ?, nombre = ?,fechaNacimiento = ?"
                + " WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                System.out.println("Alumno guardado en la base de datos");
            }
            ps.close();
            System.out.println("Alumno modificado");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT * "
                + "FROM alumnos "
                + "WHERE idAlumno = ?";
        Alumno alumno = null;

        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

            }else{
                System.out.println("No existe ese alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
        return alumno;
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE alumnos SET estado = 0 "
                + "WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno dado de baja");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE alumnos SET estado = 1 "
                + "WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno dado de alta");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE `alumnos`.`idAlumno` = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno borrado de la base de datos");
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla alumnos");
        }
    }
}
