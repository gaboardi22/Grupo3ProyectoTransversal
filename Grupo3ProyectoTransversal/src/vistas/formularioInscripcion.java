/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import EntidadesData.AlumnoData;
import EntidadesData.InscripcionData;
import EntidadesData.MateriaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class formularioInscripcion extends javax.swing.JInternalFrame {

    private List<Materia> listM;
    private List<Alumno> listA;
    private InscripcionData insData = new InscripcionData();
    private MateriaData mData;
    private AlumnoData aData;
    private DefaultTableModel modelo;
    
    public formularioInscripcion() {
        initComponents();
        
        aData = new AlumnoData();
        listA = aData.listarAlumnos();
        modelo = new DefaultTableModel();
        cargarAlumnos();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jRBMateriasInscrip = new javax.swing.JRadioButton();
        jRBMateriasNoInscrip = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBAnularInscrip = new javax.swing.JButton();
        jBInscribirse = new javax.swing.JButton();
        jBSalirInscrip = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBInscrip = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jRBMateriasInscrip.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRBMateriasInscrip.setText("Materias con inscripcion");
        jRBMateriasInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMateriasInscripActionPerformed(evt);
            }
        });

        jRBMateriasNoInscrip.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRBMateriasNoInscrip.setText("Materias sin inscripcion");
        jRBMateriasNoInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMateriasNoInscripActionPerformed(evt);
            }
        });

        jTMaterias.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTMaterias);

        jBAnularInscrip.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBAnularInscrip.setText("Anular inscripcion");
        jBAnularInscrip.setEnabled(false);
        jBAnularInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularInscripActionPerformed(evt);
            }
        });

        jBInscribirse.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBInscribirse.setText("Inscribirse");
        jBInscribirse.setEnabled(false);
        jBInscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirseActionPerformed(evt);
            }
        });

        jBSalirInscrip.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBSalirInscrip.setText("Salir");
        jBSalirInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirInscripActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Formulario de inscripcion");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Listado de materias:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRBMateriasInscrip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBMateriasNoInscrip)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInscribirse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAnularInscrip)
                        .addGap(39, 39, 39)
                        .addComponent(jBSalirInscrip)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBMateriasNoInscrip)
                    .addComponent(jRBMateriasInscrip))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribirse)
                    .addComponent(jBAnularInscrip)
                    .addComponent(jBSalirInscrip))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirInscripActionPerformed
         dispose();
    }//GEN-LAST:event_jBSalirInscripActionPerformed

    private void jRBMateriasInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMateriasInscripActionPerformed
       borrarFila();
       jRBMateriasNoInscrip.setSelected(false);
       cargaMateriasIns();
       jBInscribirse.setEnabled(false);
       jBAnularInscrip.setEnabled(true);
    }//GEN-LAST:event_jRBMateriasInscripActionPerformed

    private void jRBMateriasNoInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMateriasNoInscripActionPerformed
       borrarFila();
       jRBMateriasInscrip.setSelected(false);
       cargaMateriasNoIns();
       jBInscribirse.setEnabled(true);
       jBAnularInscrip.setEnabled(false);
    }//GEN-LAST:event_jRBMateriasNoInscripActionPerformed

    private void jBInscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirseActionPerformed
       int fSeleccionada = jTMaterias.getSelectedRow();
       if (fSeleccionada !=-1){
           Alumno a = (Alumno) jCBInscrip.getSelectedItem();
           int id = (Integer) modelo.getValueAt(fSeleccionada, 0);
           String nom  = (String) modelo.getValueAt(fSeleccionada, 1);
           String cuatri = (String) modelo.getValueAt(fSeleccionada, 2);
           Materia m = new Materia(id,nom,cuatri,true);
           Inscripcion i = new Inscripcion(a,m,0);
           InscripcionData x = new InscripcionData();
           x.guardarInscripcion(i);
           borrarFila();
       }
    }//GEN-LAST:event_jBInscribirseActionPerformed

    private void jBAnularInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularInscripActionPerformed
        int fSelec = jTMaterias.getSelectedRow();
        if (fSelec !=-1){
            Alumno a = (Alumno) jCBInscrip.getSelectedItem();
            int id = (Integer) modelo.getValueAt(fSelec, 0);
            InscripcionData x = new InscripcionData();
            x.borrarIncripcion(a.getIdAlumno(), id);
            borrarFila();
        }
    }//GEN-LAST:event_jBAnularInscripActionPerformed
 
    private void cargaMateriasNoIns(){
        Alumno sele = (Alumno)jCBInscrip.getSelectedItem();
        listM = (ArrayList) insData.obtenerMateriasNoCursadas(sele.getIdAlumno());
        for(Materia x: listM){
            modelo.addRow(new Object[] {x.getIdMateria(),x.getNombre(),x.getCuatrimestre()});
        }
    }
    
     private void cargaMateriasIns(){
        Alumno sele = (Alumno)jCBInscrip.getSelectedItem();
        List <Materia> list = insData.obtenerMateriasCursadas(sele.getIdAlumno());
        for(Materia x: list){
            modelo.addRow(new Object[] {x.getIdMateria(),x.getNombre(),x.getCuatrimestre()});
        }
    }
    private void cargarAlumnos(){
        for(Alumno item: listA){
            jCBInscrip.addItem(item);
        }
    }

    private void armarCabecera(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Cuatrimestre");
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTMaterias.setModel(modelo);
    }
    
    private void borrarFila(){
        int ind = modelo.getRowCount() -1;
        for(int i = ind ; i>=0;i--){
            modelo.removeRow(i);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAnularInscrip;
    private javax.swing.JButton jBInscribirse;
    private javax.swing.JButton jBSalirInscrip;
    private javax.swing.JComboBox<Alumno> jCBInscrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRBMateriasInscrip;
    private javax.swing.JRadioButton jRBMateriasNoInscrip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables
}
