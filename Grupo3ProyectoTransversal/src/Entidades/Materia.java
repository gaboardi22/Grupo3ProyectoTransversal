
package Entidades;

/**
 *
 * @author Grupo 3
 */
public class Materia {
    
    private int idMateria;
    private String nombre;
    private String cuatrimestre;
    private boolean estado;

    public Materia(int idMateria, String nombre, String cuatrimestre, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public Materia(String nombre, String cuatrimestre, boolean estado) {
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "idMateria = " + idMateria + ", nombre = " + nombre + ", cuatrimestre = " + cuatrimestre;
    }

   
}
