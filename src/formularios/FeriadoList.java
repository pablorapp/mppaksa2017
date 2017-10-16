/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.FeriadosControlador;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class FeriadoList extends javax.swing.JFrame {
    DefaultTableModel modelo;
    String modo;    
    String usuario;
    static Object Combo;
    /**
     * Creates new form FeriadoList
     */
    public FeriadoList(String usu) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        usuario = usu;
        llenarCB();
        getColumnas();
        setFilas();       

        MyItemListener actionListener = new MyItemListener();
        combobox.addItemListener(actionListener);
        
    }
    
        private void getColumnas() {
        modelo.addColumn("Fecha");
        modelo.addColumn("Feriado");
        }           
        
        private void setFilas(){
            String []Registros= new String[2];
            try {
                
                ResultSet rs = FeriadosControlador.consultaLista(Combo);
                while(rs.next()){
                        Registros[0]=rs.getString("tf_fec_nh");  
                        Registros[1]=rs.getString("tf_descrip");  
                        modelo.addRow(Registros);                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ConsignatariosList.class.getName()).log(Level.SEVERE, null, ex);
            }           
            tbFeriado.setModel(modelo);  
            tbFeriado.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbFeriado.getColumnModel().getColumn(1).setPreferredWidth(170);           
        }           

    private void llenarCB() throws SQLException{
        combobox.removeAllItems(); 
        ArrayList<String> resultat;
        resultat = FeriadosControlador.consulta();
        String pos = "";
        for(int i=0; i<resultat.size();i++){
            if(!pos.equals(resultat.get(i))){
                combobox.addItem(resultat.get(i));                
            }
            pos = resultat.get(i);
        }
        Combo = combobox.getSelectedItem();
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
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        combobox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFeriado = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnModi = new javax.swing.JButton();
        btnElim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Feriados");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/search.png"))); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbFeriado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbFeriado);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/notification_add.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnModi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/notification_warning.png"))); // NOI18N
        btnModi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiActionPerformed(evt);
            }
        });

        btnElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/notification_error.png"))); // NOI18N
        btnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElim, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnElim, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
            TableRowSorter tabla = new TableRowSorter(modelo);
            tabla.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().toUpperCase()));
            tbFeriado.setRowSorter(tabla);    
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
        String cod = tbFeriado.getValueAt(tbFeriado.getSelectedRow(),0).toString();
        int reply = JOptionPane.showConfirmDialog(null, "Desea eliminar el Feriado de : "+cod +" ?", modo, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
          String res = FeriadosControlador.eliFer(cod);
                if(!res.equals("")){
                    JOptionPane.showMessageDialog(null, res);
                }else{
                    JOptionPane.showMessageDialog(null, "Eliminado Exitosamente");
                    cleanJtable();
                    setFilas();
              try {
                  llenarCB();
              } catch (SQLException ex) {
                  Logger.getLogger(FeriadoList.class.getName()).log(Level.SEVERE, null, ex);
              }
                }          
        }  
    }//GEN-LAST:event_btnElimActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        modo = "INS";
        new AddFeriado(this,true,modo,"",usuario).setVisible(true);           
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnModiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiActionPerformed
        modo = "UPD";
        String cod = tbFeriado.getValueAt(tbFeriado.getSelectedRow(),0).toString();
        new AddFeriado(this,true,modo,cod,usuario).setVisible(true);  
    }//GEN-LAST:event_btnModiActionPerformed
    
    private void cleanJtable(){
                for (int i = 0; i < tbFeriado.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
                }
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btnModi;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFeriado;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evt) {

          Combo = evt.getItem();

          if (evt.getStateChange() == ItemEvent.SELECTED) {
              cleanJtable();
              setFilas();
          } 
          
        }
        
    }
    
}