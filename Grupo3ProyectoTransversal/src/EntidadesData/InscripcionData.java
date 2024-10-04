
package EntidadesData;

import Entidades.Inscripcion;
import org.mariadb.jdbc.Connection; 
import java.sql.*;

/**
 *
 * @author NETBOOK G5
 */
public class InscripcionData {
     private Connection conn = null;
     private MateriaData matData;
     private AlumnoData aluData;

    public InscripcionData() {
        this.conn = Conexion.getConexion();
    }
     
     public void guardarInscripcion(Inscripcion inscripcion){
         String sql = "";
     }
}
