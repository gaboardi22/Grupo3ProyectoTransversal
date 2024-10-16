
package vistas;

import Entidades.Alumno;
import Entidades.Materia;
import EntidadesData.InscripcionData;
import EntidadesData.MateriaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 3
 */
public class AlumnosXMateria extends javax.swing.JInternalFrame {
    private ArrayList<Materia> listaMaterias;
    private DefaultTableModel modelo;
    private MateriaData matData;
   
    public AlumnosXMateria() {
        initComponents();
        modelo  = new DefaultTableModel();
        armarCabecera();
        matData = new MateriaData();
        listaMaterias = (ArrayList<Materia>) matData.listarMaterias();
        cargarMaterias();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMateria = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jCBoxAlumXmateria = new javax.swing.JComboBox<>();
        jBSalirAxM = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de alumnos por materia ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jTMateria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMateria);

        jCBoxAlumXmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxAlumXmateriaActionPerformed(evt);
            }
        });

        jBSalirAxM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBSalirAxM.setText("Salir");
        jBSalirAxM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirAxMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jCBoxAlumXmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jBSalirAxM)))
                        .addGap(0, 19, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxAlumXmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jBSalirAxM)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirAxMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirAxMActionPerformed
         dispose();
    }//GEN-LAST:event_jBSalirAxMActionPerformed

    private void jCBoxAlumXmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxAlumXmateriaActionPerformed
       cargarDatosAlumno();
    }//GEN-LAST:event_jCBoxAlumXmateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalirAxM;
    private javax.swing.JComboBox<Materia> jCBoxAlumXmateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTMateria;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("DNI");
        filaCabecera.add("Apellido");
        filaCabecera.add("Nombre");
        filaCabecera.forEach(elem -> modelo.addColumn(elem));
        jTMateria.setModel(modelo);
    }
    private void cargarMaterias(){
        listaMaterias.forEach(elem -> jCBoxAlumXmateria.addItem(elem));
    }
    private void cargarDatosAlumno(){
        Materia matSelec = (Materia) jCBoxAlumXmateria.getSelectedItem();
        if(matSelec != null){
        int idMateria = matSelec.getIdMateria();
        ArrayList<Alumno> alumnos = new ArrayList<>();
       InscripcionData inscData = new InscripcionData();
       alumnos = (ArrayList<Alumno>) inscData.obtenerAlumnosPorAmaterias(idMateria);
       borrarFilasTabla();
            for (Alumno elem : alumnos) {
                 modelo.addRow(new Object[]{
                  elem.getIdAlumno(),
                     elem.getDni(),
                     elem.getApellido(),
                     elem.getNombre()     
                });
            }
    }
                
    }
     private void borrarFilasTabla(){
        int  indice = modelo.getRowCount() -1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

}
