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
import javax.swing.JOptionPane;
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
                    JOptionPane.showMessageDialog(null, "Alumno guardado correctamente");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET dni = ?,apellido = ?, nombre = ?,fechaNac = ?, estado = ?"
                + " WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            ps.executeUpdate();
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos1");
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
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "Alumno inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
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
            JOptionPane.showMessageDialog(null, "Alumno dado de baja");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
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
            JOptionPane.showMessageDialog(null, "Alumno dado de alta");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE `alumnos`.`idAlumno` = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alumno eliminado de la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public Alumno buscarAlumnoPorDNI(int dni) {
        String sql = "SELECT * "
                + "FROM alumnos "
                + "WHERE dni = ?";
        Alumno alumno = null;

        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(dni);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "Alumno inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
        return alumno;
    }
}
