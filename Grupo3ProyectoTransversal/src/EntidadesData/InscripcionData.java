
package EntidadesData;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import org.mariadb.jdbc.Connection; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class InscripcionData {
     private Connection conn = null;
     private MateriaData matData = new MateriaData();
     private AlumnoData aluData = new AlumnoData();

    public InscripcionData() {
        this.conn = Conexion.getConexion();
    }
     
     public void guardarInscripcion(Inscripcion inscripcion){
         String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota)"
                    + " VALUES (?, ?, ?)";
             
         try {
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
             ps.setInt(2, inscripcion.getMateria().getIdMateria());
             ps.setDouble(3, inscripcion.getNota());
             ps.executeUpdate();
             ResultSet rs = ps.getGeneratedKeys();
             if(rs.next()){
                 inscripcion.setIdInscripcion(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Inscripcion registrada con exito");
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         } 
     }
     
     public void actualizarNota(int idAlumno, int idMateria, double nota){
         String sql= "UPDATE inscripcion SET nota = ? "
                   + " WHERE idAlumno = ?  and idMateria = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setDouble(1, nota);
             ps.setInt(2, idAlumno);
             ps.setInt(3, idMateria);
             int filas =  ps.executeUpdate();
             if(filas > 0){
                  JOptionPane.showMessageDialog(null, "nota actualizada");
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
     }
     
     public void borrarIncripcion(int idAlumno, int idMateria){
         String sql = "DELETE FROM inscripcion"
                    + " WHERE idAlumno = ? AND idMateria = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ps.setInt(2, idMateria);
             int filas =  ps.executeUpdate();
             if(filas > 0){
                 JOptionPane.showMessageDialog(null, "Inscripcion borrada");
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
     }

     public List<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> materiasCursadas  =new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Inscripcion insc = new Inscripcion();
                 insc.setIdInscripcion(rs.getInt("idInscripcion"));
                 Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                 Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                 insc.setAlumno(alu);
                 insc.setMateria(mat);
                 insc.setNota(rs.getDouble("nota"));
                 materiasCursadas.add(insc);
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
         return materiasCursadas;
     }
     
      public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> materiasCursadas  =new ArrayList<>();
        String sql = "SELECT * FROM inscripcion"
                   + " WHERE  idAlumno  = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Inscripcion insc = new Inscripcion();
                 insc.setIdInscripcion(rs.getInt("idInscripcion"));
                 Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                 Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                 insc.setAlumno(alu);
                 insc.setMateria(mat);
                 insc.setNota(rs.getDouble("nota"));
                 materiasCursadas.add(insc);
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
         return materiasCursadas;
     }
      
      public List<Materia> obtenerMateriasCursadas(int idAlumno){
          ArrayList<Materia> materias = new ArrayList<>();
          String sql = "SELECT inscripcion.idMaterianombre cuatrimentre FROM inscripcion, materia "
                     + " WHERE inscripcion.idMateria = materia.idMateria "
                     + " AND inscripcion.idAlumno  = ? ";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, idAlumno);
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                   Materia materia  = new Materia();
                   materia.setIdMateria(rs.getInt("idMateria"));
                   materia.setNombre(rs.getString("nombre"));
                   materia.setCuatrimestre(rs.getString("cuatrimestre"));
                   materias.add(materia);
               }
               ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
         return materias;
      }
       public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
           ArrayList<Materia> materias = new ArrayList<>();
           String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN "
                      + " (SELECT idMateria FROM inscripcion WHERE idAlumno  = ?)";
            try {
             PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, idAlumno);
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                   Materia materia  = new Materia();
                   materia.setIdMateria(rs.getInt("idMateria"));
                   materia.setNombre(rs.getString("nombre"));
                   materia.setCuatrimestre(rs.getString("cuatrimestre"));
                   materias.add(materia);
               }
               ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
         return materias;
       }
       
       public List<Alumno> obtenerAlumnosPorAmaterias(int idMateria){
           ArrayList<Alumno> alumnosMaterias = new ArrayList<>();
           String sql = "SELECT idAlumno, nombre, apellido, fechaNacimiento, estado FROM inscripcion i , alumno a"
                   + " i.idAlumno = a.idAlumno AND idMateria = ? NAD estado = 1";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, idMateria);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  Alumno alumno  = new Alumno();
                  alumno.setIdAlumno(rs.getInt("idAlumno"));
                  alumno.setApellido(rs.getString("apellido"));
                  alumno.setNombre(rs.getString("nombre"));
                  alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                  alumno.setEstado(rs.getBoolean("estado"));
                  alumnosMaterias.add(alumno);
              }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }
         return alumnosMaterias;  
       }
}
