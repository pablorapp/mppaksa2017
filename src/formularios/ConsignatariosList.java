/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ConsignatariosControlador;
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
public class ConsignatariosList extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String modo;
    String usuario;
    /**
     * Creates new form ConsignatariosList
     * @param usu
     */
    public ConsignatariosList(String usu) {
        initComponents();
        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        usuario = usu;
        getColumnas();
        setFilas();     
    }
    
        private void getColumnas() {
        modelo.addColumn("Id");
        modelo.addColumn("RUC");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Cod. Tarifa");  
        }       
        
        private void setFilas(){
            String []Registros= new String[6];
            try {
                
                ResultSet rs = ConsignatariosControlador.consultaLista();
                while(rs.next()){
                        Registros[0]=rs.getString("consig_id");  
                        Registros[1]=rs.getString("cnruc");  
                        Registros[2]=rs.getString("cnnombre");  
                        Registros[3]=rs.getString("cndireccion");  
                        Registros[4]=rs.getString("cntelefono");  
                        Registros[5]=rs.getInt("cncodcab")+"-"+rs.getInt("cncodtar");
                        modelo.addRow(Registros);                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ConsignatariosList.class.getName()).log(Level.SEVERE, null, ex);
            }           
            tbConsignatario.setModel(modelo);  
            tbConsignatario.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbConsignatario.getColumnModel().getColumn(1).setPreferredWidth(130);
            tbConsignatario.getColumnModel().getColumn(2).setPreferredWidth(280);
            tbConsignatario.getColumnModel().getColumn(3).setPreferredWidth(280);
            tbConsignatario.getColumnModel().getColumn(4).setPreferredWidth(130);
            tbConsignatario.getColumnModel().getColumn(5).setPreferredWidth(130);           
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
        tbConsignatario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        newcn = new javax.swing.JButton();
        modicn = new javax.swing.JButton();
        elicn = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbConsignatario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbConsignatario);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consignatarios");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/search.png"))); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        newcn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/document_add.png"))); // NOI18N
        newcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newcnActionPerformed(evt);
            }
        });

        modicn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/document_edit.png"))); // NOI18N
        modicn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modicnActionPerformed(evt);
            }
        });

        elicn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/document_delete.png"))); // NOI18N
        elicn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elicnActionPerformed(evt);
            }
        });

        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/piechart.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newcn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modicn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elicn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newcn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modicn)
                    .addComponent(elicn)
                    .addComponent(imprimir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TableRowSorter tabla = new TableRowSorter(modelo);
        tabla.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().toUpperCase()));
        tbConsignatario.setRowSorter(tabla);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void newcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcnActionPerformed
        modo = "INS";
        try {
            new AddConsignatario(this,true,modo,"0",usuario).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ConsignatariosList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newcnActionPerformed

    private void modicnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modicnActionPerformed
        modo = "UPD";
        String cod = tbConsignatario.getValueAt(tbConsignatario.getSelectedRow(),0).toString();
        try {
            new AddConsignatario(this,true,modo,cod,usuario).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ConsignatariosList.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_modicnActionPerformed

    private void elicnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elicnActionPerformed
        int cod = Integer.parseInt(tbConsignatario.getValueAt(tbConsignatario.getSelectedRow(),0).toString()) ;
        String nombre = tbConsignatario.getValueAt(tbConsignatario.getSelectedRow(),2).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Desea eliminar "+nombre +" ?", modo, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          String res = ConsignatariosControlador.eliConsig(cod);
                if(!res.equals("")){
                    JOptionPane.showMessageDialog(null, res);
                }else{
                    JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");
                    limpiar();
                    setFilas();
                }          
        }                
    }//GEN-LAST:event_elicnActionPerformed

    private void limpiar(){
        while(0 <tbConsignatario.getRowCount()){
            modelo.removeRow(0);
        }
    }    
    
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(ConsignatariosList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsignatariosList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsignatariosList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsignatariosList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsignatariosList().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton elicn;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modicn;
    private javax.swing.JButton newcn;
    private javax.swing.JTable tbConsignatario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
