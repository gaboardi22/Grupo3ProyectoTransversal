
package EntidadesData;

import org.mariadb.jdbc.Connection;

/**
 *
 * @author NETBOOK G5
 */
public class InscripcionData {
     private Connection conn = null;
     private MateriaData matData;
     private AlumnoData aluData;

    public InscripcionData() {
        conn = Conexion.getConexion();
    }
     
     
}
