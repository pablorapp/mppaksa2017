/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.TarifasControlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mauro
 */
public class TarifasList extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    String modo;
    String usuario;
    /**
     * Creates new form TarifasList
     */
    public TarifasList(String usu) {
        initComponents();
        setLocationRelativeTo(null);
        usuario = usu;
        modelo = new DefaultTableModel();
        getColumnas();
        setFilas();          
    }
    
        private void getColumnas() {
        modelo.addColumn("Codigo Tarifa");
        modelo.addColumn("Descripción");
        modelo.addColumn("Tarifa 1");
        modelo.addColumn("Tarifa 2");
        modelo.addColumn("Tarifa 3");  
        }       
        
        private void setFilas(){
            String []Registros= new String[5];
            try {
                
                ResultSet rs = TarifasControlador.consultaLista();
                while(rs.next()){
                        Registros[0]=rs.getString("tt_cod_cab")+"-"+rs.getString("tt_codigo");
                        Registros[1]=rs.getString("tt_abrevia");  
                        Registros[2]=rs.getString("tt_tarifa1");  
                        Registros[3]=rs.getString("tt_tarifa2");  
                        Registros[4]=rs.getString("tt_tarifa3");
                        modelo.addRow(Registros);                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ConsignatariosList.class.getName()).log(Level.SEVERE, null, ex);
            }           
            tbTarifa.setModel(modelo);  
            tbTarifa.getColumnModel().getColumn(0).setPreferredWidth(130);
            tbTarifa.getColumnModel().getColumn(1).setPreferredWidth(350);
            tbTarifa.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbTarifa.getColumnModel().getColumn(3).setPreferredWidth(90);
            tbTarifa.getColumnModel().getColumn(4).setPreferredWidth(90);              
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
        tbTarifa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        newtf = new javax.swing.JButton();
        moditf = new javax.swing.JButton();
        elitf = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbTarifa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbTarifa);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tarifas");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/search.png"))); // NOI18N
        jLabel2.setText("Buscar");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        newtf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/file_add.png"))); // NOI18N
        newtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtfActionPerformed(evt);
            }
        });

        moditf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/file_edit.png"))); // NOI18N
        moditf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moditfActionPerformed(evt);
            }
        });

        elitf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/file_delete.png"))); // NOI18N
        elitf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elitfActionPerformed(evt);
            }
        });

        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/document.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/notification_error.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newtf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moditf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elitf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newtf)
                        .addComponent(moditf)
                        .addComponent(elitf)
                        .addComponent(imprimir))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        TableRowSorter tabla = new TableRowSorter(modelo);
        tabla.setRowFilter(RowFilter.regexFilter(txtbuscar.getText().toUpperCase()));
        tbTarifa.setRowSorter(tabla);
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtfActionPerformed
        modo = "INS";
        new AddTarifa(this,true,modo,"0",usuario).setVisible(true);        
    }//GEN-LAST:event_newtfActionPerformed

    private void moditfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moditfActionPerformed
        modo = "UPD";
        String cod = tbTarifa.getValueAt(tbTarifa.getSelectedRow(),0).toString();
        new AddTarifa(this,true,modo,cod,usuario).setVisible(true);  
    }//GEN-LAST:event_moditfActionPerformed

    private void elitfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elitfActionPerformed
        String cod = tbTarifa.getValueAt(tbTarifa.getSelectedRow(),0).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Desea eliminar "+cod +" ?", modo, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          String res = TarifasControlador.eliTarif(cod);
                if(!res.equals("")){
                    JOptionPane.showMessageDialog(null, res);
                }else{
                    JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");
                }          
        }     
    }//GEN-LAST:event_elitfActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TarifasList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TarifasList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TarifasList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TarifasList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TarifasList().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton elitf;
    private javax.swing.JButton imprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moditf;
    private javax.swing.JButton newtf;
    private javax.swing.JTable tbTarifa;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
