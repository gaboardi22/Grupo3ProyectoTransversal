/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.time.LocalDate;
import Entidades.Alumno;
import org.mariadb.jdbc.Connection;
import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Inscripcion;

/**
 *
 * @author Ezequiel
 */
public class main {

    public static void main(String[] args) {
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id = new InscripcionData();
 /*AGREGAR ALUMNO
            Alumno alumno = new Alumno(32345678,"Ezequiel","Aravena",LocalDate.now(),true);
            ad.guardarAlumno(alumno);
            alumnoData.eliminarAlumno(1);*/
 /*LISTAR ISCRIPCIONES DE UN ALUMNO
            for(Inscripcion insc:id.obtenerIscripciones()){
            System.out.println("id: "+insc.getIdInscripcion());
            System.out.println("Apellido: "+insc.getAlumno().getApellido());
            System.out.println("Materia: "+insc.getMateria().getNombre());
        }*/
    }
}
