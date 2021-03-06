/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Contreras
 */
public class Modificar extends javax.swing.JDialog {

    boolean modif = false;

    /**
     * Creates new form Modificar
     */
    public Modificar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setSize(188, 280);
        this.setLocationRelativeTo(null);
        this.setTitle("TSP - Modificar");
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        tabela.getColumnModel().getColumn(0).setMaxWidth(30);
        // tabla.getColumnModel().getColumn(0).setPreferredWidth(15);
        for (int i = 0; i < Mapa.Cuidades.size(); i++) {
            modelo.addRow(new Object[0]);

        }
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i + 1 + ".- ", i, 0);
            modelo.setValueAt(Mapa.Cuidades.get(i).nombre, i, 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Estados"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        aceptar.setBackground(new java.awt.Color(0, 153, 51));
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (tabela.getSelectedRow() >= 0) {


            Mapa.Cuidades.get(tabela.getSelectedRow()).setNombre(JOptionPane.showInputDialog("Ingrese el nombre de su vertice"));
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.removeRow(tabela.getSelectedRow());
            modelo.addRow(new Object[0]);
            for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.setValueAt(i + 1 + ".- ", i, 0);
                modelo.setValueAt(Mapa.Cuidades.get(i).nombre, i, 1);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        this.setVisible(false);
        if (Mapa_TSP.recorridox) {
            Mapa_TSP.dialog.setVisible(false);
        }
        if (Mapa_TSP.dibujar_ruta) {
            Mapa.ruta.clear();
            Mapa.rutacorta();
            Mapa.costo = 0;
            Mapa.get_costo();
            Mapa_TSP.dialog = new Recorrido(new javax.swing.JFrame(), false);
            Mapa_TSP.dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    Mapa_TSP.ventana_recorrido = true;
                    Mapa.ruta.clear();
                    Mapa_TSP.dialog.setVisible(false);

                }
            });
            Mapa_TSP.dialog.setVisible(true);

        }
        Mapa_TSP.panel.repaint();


        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (tabela.getSelectedRow() >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();


            Mapa.Estados.get(Mapa.Cuidades.get(tabela.getSelectedRow()).getPosición()).contador--;
            Mapa.Cuidades.remove(tabela.getSelectedRow());
            modelo.removeRow(tabela.getSelectedRow());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Modificar dialogo = new Modificar(new javax.swing.JFrame(), false);
                dialogo.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);

                    }
                });
                dialogo.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
