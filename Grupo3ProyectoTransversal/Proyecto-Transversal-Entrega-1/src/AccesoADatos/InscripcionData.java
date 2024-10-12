/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Ezequiel
 */
public class InscripcionData {

    private Connection conn = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public InscripcionData() {
        this.conn = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO `inscripcion`(`idAlumno`, `idMateria`, `nota`) "
                + "VALUES (?, ?, ?)";
        try {
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                System.out.println("Inscripcion guardada en la base de datos");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla inscripcion");
        }

    }
    
    public void actualizarNota(int idAlumno,int idMateria, double not){
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try {
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, not);
            ps.setInt(2, idAlumno);
            ps.setInt(idMateria, 3);
            int filas = ps.executeUpdate();
            if(filas==1){
                System.out.println("Nota actualizada");
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla inscripcion");
        }
    }
    
    public void borrarInscripcion(int idAlumno,int idMateria){
    String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if(filas == 1){
                System.out.println("Inscripcion borrada correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla inscripcion");
        }
    
    }
    
    public List<Inscripcion> obtenerIscripciones(){
    ArrayList<Inscripcion> cursadas = new ArrayList<>(); 
    String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
            Alumno alu =ad.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat =md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla inscripcion");
        }
    return cursadas;
    }
}
