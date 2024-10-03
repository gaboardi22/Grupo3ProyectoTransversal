
package grupo3proyectotransversal;

import Entidades.Alumno;
import EntidadesData.AlumnoData;
import java.time.LocalDate;

/**
 *
 * @author Grupo 3
 */
public class Grupo3ProyectoTransversal {

   
    public static void main(String[] args) {
      
        Alumno pablo = new Alumno(1,29311374, "gabo", "pablo", LocalDate.of(1982, 03, 19), true);
        AlumnoData alu = new AlumnoData();
        //alu.guardarAlumno(pablo);
        //alu.modificarAlumno(pablo);
        alu.eliminarAlumno(1);
    }
    
}
