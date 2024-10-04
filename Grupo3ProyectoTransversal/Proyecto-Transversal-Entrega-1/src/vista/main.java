/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.time.LocalDate;
import modelo.Alumno;
import org.mariadb.jdbc.Connection;
import persistencia.AlumnoData;
import persistencia.Conexion;

/**
 *
 * @author Ezequiel
 */
public class main {
    public static void main(String[] args){
        AlumnoData alumnoData = new AlumnoData();
         //AGREGAR ALUMNO
        Alumno alumno = new Alumno(32345678,"Ezequiel","Aravena",LocalDate.now(),true);
        alumnoData.guardarAlumno(alumno);
        //alumnoData.eliminarAlumno(1);
        
    }
}
