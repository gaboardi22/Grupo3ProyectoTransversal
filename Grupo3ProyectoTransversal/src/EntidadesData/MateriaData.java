
package EntidadesData;

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
public class MateriaData {
    private Connection conn = null;
    
    public MateriaData(){
        conn = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String sql  = "INSERT INTO materia(nombre, cuatrimestre, estado)"
                    + " VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getCuatrimestre());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "materia guardada");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        } 
    }
    
    
    public void modificarMateria(Materia materia){
        try {
            String sql  = "UPDATE materia SET nombre = ?, cuatrimestre = ?, estado = ? "
                    + "WHERE idMateria  = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getCuatrimestre());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
             if(exito == 1){
               JOptionPane.showMessageDialog(null, "materia modificada con exito");
           }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        } 
    }
    
    public void eliminarMateria(int id){
        try {
            String sql = "UPDATE materia SET estado = 0 "
                    + "WHERE idMateria = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
             if(exito == 1){
               JOptionPane.showMessageDialog(null, "materia eliminada con exito");
           }
             ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
    }
    
    public Materia buscarMateria(int id){
        String sql = "SELECT  nombre, cuatrimestre, estado FROM materia "
                   + " WHERE idMateria = ? AND estado  = 1";
        Materia materia  = null;
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getString("cuatrimestre"));
                materia.setEstado(true);
            } else{
                 JOptionPane.showMessageDialog(null, "no existe una materia con ese id");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
        return materia;
    }
    
    public Materia buscarMateriaPorNombre(String nombre){
        String sql = "SELECT idMateria, nombre, cuatrimestre, estado FROM materia"
                + " WHERE nombre  = ? AND estado = 1";
        Materia materia  = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getString("cuatrimestre"));
                materia.setEstado(true);
            }else{
                 JOptionPane.showMessageDialog(null, "no existe una materia con ese nombre");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
         return materia; 
    }
    
    public List<Materia> listarMaterias(){
        String sql = "SELECT idMateria, nombre, cuatrimestre, estado FROM materia WHERE 1";
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs  = ps.executeQuery();
            while(rs.next()){
            Materia materia  = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setCuatrimestre(rs.getString("cuatrimestre"));
            materia.setEstado(true);
            materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
        return materias;
    } 
}
