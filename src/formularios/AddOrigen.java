/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.OrigenControlador;
import javax.swing.JOptionPane;
import modelos.Origen;
import programas.Formato;

/**
 *
 * @author Mauro
 */
public class AddOrigen extends javax.swing.JFrame {
    String mode;
    String usuario;
    int cod;
    /**
     * Creates new form AddOrigen
     * @param parent
     * @param modal
     * @param usu
     * @param codigo
     * @param modo
     */
    public AddOrigen(java.awt.Frame parent, boolean modal,String modo,int codigo,String usu) {
        initComponents();
        setLocationRelativeTo(null);
        mode = modo;
        usuario = usu;        
        if("INS".equals(modo)){
            titulo.setText("Ingresar Origen");                       
        }else{
            titulo.setText("Modificar Origen");
            cod = codigo;
            Origen mec  = OrigenControlador.recOri(cod);
            txtcod.setText(String.valueOf(mec.getOri_codigo()));
            txtdesc.setText(mec.getOri_descri());
            txtTel.setText(mec.getOri_telef());
            txtContacto.setText(mec.getOri_contac());
            txtcod.setEnabled(false);
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

        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        Contacto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel2.setText("Descripción");

        Contacto.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Contacto.setText("Contacto");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel4.setText("Teléfono");

        btnConfirm.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnConfirm.setText("Confirmar");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(Contacto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdesc)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtContacto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contacto)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if(txtcod.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese el Codigo de Origen");
        }else if(txtdesc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese Descripción de Origen");
        }else{
            int cod = Integer.parseInt(txtcod.getText());
            String descr = txtdesc.getText();
            String fecha = Formato.FechaHoy2();
            String tel = txtTel.getText();
            String contacto = txtContacto.getText();

            if("INS".equals(mode)){
                Origen mc = new Origen(cod,descr,tel,contacto,fecha,usuario,"00:00","M");
                String res = OrigenControlador.adMerc(mc);
                if(!res.equals("")){
                    JOptionPane.showMessageDialog(null, res);
                }else{
                    limpiar();
                }
            }else{
                Origen mc = new Origen(cod,descr,tel,contacto,fecha,usuario,"00:00","M");
                String res = OrigenControlador.modiOri(mc);
                if(!res.equals("")){
                    JOptionPane.showMessageDialog(null, res);
                }else{
                    JOptionPane.showMessageDialog(null, "Modificado Exitosamente");
                    limpiar();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void limpiar(){
            txtcod.setText("");            
            txtdesc.setText("");            
            txtTel.setText("");
            txtContacto.setText("");
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contacto;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdesc;
    // End of variables declaration//GEN-END:variables
}
