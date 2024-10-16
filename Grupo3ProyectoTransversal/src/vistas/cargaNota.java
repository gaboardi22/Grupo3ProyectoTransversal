
package vistas;

import Entidades.Alumno;
import Entidades.Inscripcion;
import EntidadesData.AlumnoData;
import EntidadesData.InscripcionData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargaNota extends javax.swing.JInternalFrame {

    private List<Inscripcion> listaIns;
    private List<Alumno> listaA;
    private InscripcionData inscData;
    private AlumnoData aluData;
    private DefaultTableModel modelo;

   
    public cargaNota() {
        initComponents();
        aluData = new AlumnoData();
        inscData = new InscripcionData();
        listaA = aluData.listarAlumnos();
        modelo = new DefaultTableModel();
        this.cargarAlumnos();
        this.armarCabeceraTabla();
        this.cargarDatos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNotas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jBGuardarNotas = new javax.swing.JButton();
        jCBoxNotas = new javax.swing.JComboBox<>();
        jBSalirNotas = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Carga de notas");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jTNotas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTNotas);

        jBGuardarNotas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBGuardarNotas.setText("Guardar");
        jBGuardarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarNotasActionPerformed(evt);
            }
        });

        jCBoxNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxNotasActionPerformed(evt);
            }
        });

        jBSalirNotas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jBSalirNotas.setText("Salir");
        jBSalirNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirNotasActionPerformed(evt);
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
                        .addComponent(jCBoxNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jBGuardarNotas)
                        .addGap(42, 42, 42)
                        .addComponent(jBSalirNotas)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardarNotas)
                    .addComponent(jBSalirNotas))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirNotasActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirNotasActionPerformed

    private void jBGuardarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarNotasActionPerformed
        int filaSeleccionada = jTNotas.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                int idAlumno = listaIns.get(filaSeleccionada).getAlumno().getIdAlumno();
                double nota = Double.parseDouble(modelo.getValueAt(filaSeleccionada, 2).toString());
                int idMateria = listaIns.get(filaSeleccionada).getMateria().getIdMateria();
                inscData.actualizarNota(idAlumno, idMateria, nota);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al parsear la nota");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila válida");
        }

    }//GEN-LAST:event_jBGuardarNotasActionPerformed

    private void jCBoxNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxNotasActionPerformed
        cargarDatos();
    }//GEN-LAST:event_jCBoxNotasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardarNotas;
    private javax.swing.JButton jBSalirNotas;
    private javax.swing.JComboBox<Alumno> jCBoxNotas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTNotas;
    // End of variables declaration//GEN-END:variables
    private void cargarAlumnos() {
        for (Alumno alumno : listaA) {
            jCBoxNotas.addItem(alumno);
        }
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Nota");
        for (Object object : filaCabecera) {
            modelo.addColumn(object);
        }
        jTNotas.setModel(modelo);
    }

    private void cargarDatos() {
        Alumno selec = (Alumno) jCBoxNotas.getSelectedItem();
        if (selec != null) {
            listaIns = (ArrayList) inscData.obtenerInscripcionesPorAlumno(selec.getIdAlumno());
            modelo.setRowCount(0);
            for (Inscripcion insc : listaIns) {
                modelo.addRow(new Object[]{insc.getIdInscripcion(), insc.getMateria().getNombre(), insc.getNota()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno");
        }
    }
}
