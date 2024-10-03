
package EntidadesData;

import Entidades.Alumno;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Grupo 3
 */
public class AlumnoData {
    private Connection conn  =null;

    public AlumnoData() {
        conn = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        try {
            
            String sql = "INSERT INTO alumno( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
                    + "VALUES (?,?,?,?,?)";
            
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                ps.setBoolean(5, alumno.isEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    alumno.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "alumno guardado");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
    }
    
    public void modificarAlumno(Alumno alumno){
        String sql= "UPDATE alumno SET dni = ?,apellido = ?, nombre = ?,fechaNacimiento = ?, estado = ? "
                + " WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
           int exito =  ps.executeUpdate();
           if(exito == 1){
               JOptionPane.showMessageDialog(null, "alumno modificado con exito");
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
    }
    
    public void eliminarAlumno(int id){
        String sql = " UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
             if(exito == 1){
               JOptionPane.showMessageDialog(null, "alumno eliminado con exito");
           }
             ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }  
    }
    
    public Alumno buscarAlumno(int id){
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate(("fechaNacimiento")).toLocalDate());
                alumno.setEstado(true); 
            }else{
                 JOptionPane.showMessageDialog(null, "no existe un alumno con ese id");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
        return alumno;
    } 
    
     public Alumno buscarAlumnoPorDni(int dni){
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate(("fechaNacimiento")).toLocalDate());
                alumno.setEstado(true); 
            }else{
                 JOptionPane.showMessageDialog(null, "no existe un alumno con ese id");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
        return alumno;
    } 
     public List<Alumno> listarAlumnos(){
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado = 1";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate(("fechaNacimiento")).toLocalDate());
                alumno.setEstado(true); 
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
        return alumnos;
    } 
}
