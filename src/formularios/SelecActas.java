/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ActasControlador;
import static formularios.LisActas.Combo;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import modelos.Actas;

/**
 *
 * @author Pablo
 */
public class SelecActas extends javax.swing.JDialog {
        int mic;
        int acta;
        String fec;
        String hour;
    /**
     * Creates new form SelecActas
     */
    DefaultTableModel tabla;
    public SelecActas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        tabla = (DefaultTableModel)tblActa.getModel();
        setLocationRelativeTo(null);
        redimensionarTabla();
        llenarCB();
        MyItemListener actionListener = new MyItemListener();
        combobox.addItemListener(actionListener);        
        cargaTabla();
    }
    
    private void llenarCB() throws SQLException{
        combobox.removeAllItems(); 
        ArrayList<String> resultat;
        resultat = ActasControlador.consulta();
        String pos = "";
        for(int i=0; i<resultat.size();i++){
            if(!pos.equals(resultat.get(i))){
                combobox.addItem(resultat.get(i));                
            }
            pos = resultat.get(i);
        }
        Combo = combobox.getSelectedItem();
    }      

    private void cleanJtable(){
            for (int i = 0; i < tabla.getRowCount(); i++) {
                tabla.removeRow(i);
                i-=1;
            }
    }           
    
    
    private void redimensionarTabla(){
        TableColumnModel colum = tblActa.getColumnModel();
//        colum.getColumn(0).setMaxWidth(80);
//        colum.getColumn(0).setMinWidth(80);
//        colum.getColumn(0).setWidth(80);
//        colum.getColumn(1).setMaxWidth(80);
//        colum.getColumn(1).setMinWidth(80);
//        colum.getColumn(1).setWidth(80);
    }
    
    private void cargaTabla(){
        List<Actas> acts = ActasControlador.recListActaTbl2(Combo);
        for(Actas act : acts){
            Object[] obj = {act.getMa_nro_act(),act.getMa_mic_dta(),act.getMa_fec_act(),act.getMa_hora()};
            tabla.addRow(obj);
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActa = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        combobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar Acta");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        tblActa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Acta", "MIC", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblActa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblActa);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        TableRowSorter sorter = new TableRowSorter(tabla);
        tblActa.setRowSorter(sorter);
        RowFilter filter = RowFilter.regexFilter("(?i)"+txtFiltro.getText().trim());
        sorter.setRowFilter(filter);
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(tblActa.getSelectedRow()>= 0){
            this.acta = Integer.parseInt(tblActa.getValueAt( tblActa.getSelectedRow(),0)+"");
            this.mic = Integer.parseInt(tblActa.getValueAt( tblActa.getSelectedRow(),1)+"");
            this.fec = String.valueOf(tblActa.getValueAt(tblActa.getSelectedRow(),2));
            this.hour = String.valueOf(tblActa.getValueAt(tblActa.getSelectedRow(),3));
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un registro");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblActaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActaMouseClicked
        if(evt.getClickCount()==2 && tblActa.getSelectedRow()>=0){
            this.acta = Integer.parseInt(tblActa.getValueAt( tblActa.getSelectedRow(),0)+"");            
            this.mic = Integer.parseInt(tblActa.getValueAt( tblActa.getSelectedRow(),1)+"");
            this.fec = String.valueOf(tblActa.getValueAt(tblActa.getSelectedRow(),2));
            this.hour = String.valueOf(tblActa.getValueAt(tblActa.getSelectedRow(),3));            
            this.dispose();            
        }
    }//GEN-LAST:event_tblActaMouseClicked

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
//            java.util.logging.Logger.getLogger(SelecActas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SelecActas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SelecActas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SelecActas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SelecActas dialog = new SelecActas(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblActa;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evt) {

          Combo = evt.getItem();

          if (evt.getStateChange() == ItemEvent.SELECTED) {
              cleanJtable();
              cargaTabla();
          } 
          
        }
        
    }


}


