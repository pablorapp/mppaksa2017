/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ActasControlador;
import controladores.ConsignatariosControlador;
import controladores.MercaderiasControlador;
import controladores.OrigenControlador;
import controladores.TarifasControlador;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelos.Actas;
import modelos.Consignatarios;
import modelos.Mercaderias;
import modelos.Origen;
import modelos.Tarifas;
import programas.Formato;

/**
 *
 * @author Pablo
 */
public class ActasCarga extends javax.swing.JDialog {
    String usuario;
    int codActa;
    String mode;
    /**
     * Creates new form ActasCarga
     */
    DefaultTableModel tabla;
    public ActasCarga(java.awt.Frame parent, boolean modal,String modo,int codigo,String usu) throws SQLException {
        super(parent, modal);
        initComponents();
        usuario = usu;
        codActa = codigo;
        mode = modo;
        tabla = (DefaultTableModel) tblDet.getModel();
        setLocationRelativeTo(null);       
        redimencionarTabla();
        final int limite  = 6;
        if("INS".equals(mode)){
            this.setTitle("Lista de Actas");
            titulo.setText("Carga de Actas");
            txtFecha.setText(Formato.FechaHoy());
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            txtHora.setText(sdf.format(date));           
            txtNroActa.setText(ActasControlador.recUtlNroAct()+"");
        }else{
            this.setTitle("Modificación de Actas");
            titulo.setText("Modificación de Actas");
            ResultSet rs = ActasControlador.recCab(codActa);
            if(rs.next()){
                txtNroActa.setText(String.valueOf(codActa));
                String df = rs.getString("ma_fec_act");
                String anho = df.substring(0, 4);
                String mes = df.substring(5,7);
                String dia = df.substring(8, 10);
                String fecha = dia + "/" + mes + "/" + anho;                 
                txtFecha.setText(fecha);
                txtHora.setText(rs.getString("ma_hora"));
                txtOri.setText(rs.getString("ma_nro_ing"));
                Origen ori = OrigenControlador.recOri(Integer.parseInt(txtOri.getText()));
                if(ori!=null){
                    txtOriDesc.setText(ori.getOri_descri().trim());
                }    
                List<Actas> ls = ActasControlador.recudet(codActa);
                for(Actas res : ls) {
                  
                    String valor = String.valueOf(res.getMa_val_fot());
                    String fob = valor.replace(".", ",");                    
                    Consignatarios cons = ConsignatariosControlador.recConsig(res.getMa_cod_con());
                    Mercaderias merca = MercaderiasControlador.recMerc(res.getMa_cod_mer());
                    Tarifas tar = TarifasControlador.recTar(res.getMa_cod_cab(), res.getMa_cod_tar());
                    Object[] obj = {(String.valueOf(res.getMa_mic_dta())),String.valueOf(res.getMa_cod_con())
                            ,cons.getCnnombre().trim(),fob,String.valueOf(res.getMa_cod_mer())
                            ,merca.getTm_descrip().trim(),String.valueOf(res.getMa_cod_cab()),String.valueOf(res.getMa_cod_tar())
                            ,tar.getTt_abrevia().trim(),res.getMa_des_mer().trim(),res.getMa_marcar().trim()};
                    tabla.addRow(obj);
                } 
            }
        }

        txtNroActa.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e)                    
            {if (txtNroActa.getText().length()== limite)
                 e.consume();
            }
            public void keyPressed(KeyEvent arg0) {
            }
            public void keyReleased(KeyEvent arg0) {
            }            
        });

        txtNroActa.requestFocus();
    }

    private void redimencionarTabla(){
        TableColumnModel colum = tblDet.getColumnModel();
        colum.getColumn(0).setMinWidth(80);
        colum.getColumn(0).setMaxWidth(80);
        colum.getColumn(0).setWidth(80);
        colum.getColumn(1).setMinWidth(0);
        colum.getColumn(1).setMaxWidth(0);
        colum.getColumn(1).setPreferredWidth(0);
        colum.getColumn(2).setMinWidth(200);
        colum.getColumn(2).setPreferredWidth(200);
        colum.getColumn(2).setMaxWidth(200);
        colum.getColumn(3).setMinWidth(100);
        colum.getColumn(3).setPreferredWidth(80);
        colum.getColumn(3).setMaxWidth(100);
        colum.getColumn(4).setMinWidth(0);
        colum.getColumn(4).setPreferredWidth(0);
        colum.getColumn(4).setMaxWidth(0);
        colum.getColumn(6).setMinWidth(0);
        colum.getColumn(6).setPreferredWidth(0);
        colum.getColumn(6).setMaxWidth(0);
        colum.getColumn(7).setMinWidth(0);
        colum.getColumn(7).setPreferredWidth(0);
        colum.getColumn(7).setMaxWidth(0);
        colum.getColumn(8).setMinWidth(0);
        colum.getColumn(8).setPreferredWidth(0);
        colum.getColumn(8).setMaxWidth(0);
        colum.getColumn(9).setMinWidth(0);
        colum.getColumn(9).setPreferredWidth(0);
        colum.getColumn(9).setMaxWidth(0);
        colum.getColumn(10).setMinWidth(0);
        colum.getColumn(10).setPreferredWidth(0);
        colum.getColumn(10).setMaxWidth(0);        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dcdFecha = new datechooser.beans.DateChooserDialog();
        titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNroActa = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOri = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        txtOriDesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtConsig = new javax.swing.JTextField();
        txtConsigNom = new javax.swing.JTextField();
        txtMic = new javax.swing.JTextField();
        txtCab = new javax.swing.JTextField();
        txtTar = new javax.swing.JTextField();
        txtTarNom = new javax.swing.JTextField();
        txtSFac = new javax.swing.JTextField();
        txtMercaNom = new javax.swing.JTextField();
        txtDescrip = new javax.swing.JTextField();
        txtMerca = new javax.swing.JTextField();
        btnMod = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btndlt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDet = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        txtFOB = new javax.swing.JFormattedTextField();
        txtCodNom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 10));

        titulo.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CABECERA");

        jLabel3.setText("1. Acta de Recepción :");

        jLabel4.setText("2. Hora :");

        txtNroActa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroActaActionPerformed(evt);
            }
        });
        txtNroActa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroActaKeyTyped(evt);
            }
        });

        jLabel5.setText("3. Fecha :");

        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFocusLost(evt);
            }
        });
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        jLabel6.setText("4. Lugar de Ingreso :");

        txtOri.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOriFocusLost(evt);
            }
        });
        txtOri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOriActionPerformed(evt);
            }
        });
        txtOri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOriKeyTyped(evt);
            }
        });

        jLabel7.setText("Numerac :");

        txtFecha1.setEditable(false);

        txtOriDesc.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("DETALLES");

        jLabel9.setText("5. MIC/DTA Nro");

        jLabel10.setText("6. Cód. Consignatario");

        jLabel11.setText("7. Valor FOB");

        jLabel12.setText("8. Cod. Cabecera");

        jLabel13.setText("9. Cód Tarifa");

        jLabel14.setText("10. Cod Mercaderia");

        jLabel15.setText("11. Descripción");

        jLabel16.setText("12. Salida s/ Fac.");

        jLabel17.setText("13. Tipo Salida");

        jLabel18.setText("Estado Actual");

        jLabel19.setText("14. Importe:");

        jLabel20.setText(":");

        jLabel21.setText(":");

        jLabel22.setText(":");

        jLabel23.setText(":");

        jLabel24.setText(":");

        jLabel25.setText(":");

        jLabel26.setText(":");

        jLabel27.setText(":");

        jLabel28.setText(":");

        jLabel29.setText(":");

        txtConsig.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConsigFocusLost(evt);
            }
        });
        txtConsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsigActionPerformed(evt);
            }
        });
        txtConsig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsigKeyTyped(evt);
            }
        });

        txtConsigNom.setEditable(false);

        txtMic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMicActionPerformed(evt);
            }
        });
        txtMic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMicKeyTyped(evt);
            }
        });

        txtCab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCabFocusLost(evt);
            }
        });
        txtCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCabActionPerformed(evt);
            }
        });

        txtTar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTarFocusLost(evt);
            }
        });
        txtTar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarActionPerformed(evt);
            }
        });
        txtTar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarKeyTyped(evt);
            }
        });

        txtTarNom.setEditable(false);

        txtSFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSFacActionPerformed(evt);
            }
        });

        txtMercaNom.setEditable(false);
        txtMercaNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMercaNomFocusGained(evt);
            }
        });

        txtDescrip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripFocusGained(evt);
            }
        });
        txtDescrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripActionPerformed(evt);
            }
        });

        txtMerca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMercaFocusLost(evt);
            }
        });
        txtMerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMercaActionPerformed(evt);
            }
        });
        txtMerca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMercaKeyTyped(evt);
            }
        });

        btnMod.setText("Modificar");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btndlt.setText("Eliminar");
        btndlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndltActionPerformed(evt);
            }
        });

        tblDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MIC", "Consignatario", "ConsigNom", "FOB", "CodMerc", "Mercaderia", "Cab", "Tarifa", "TarifaDesc", "Descrip", "Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDet);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        txtFOB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtFOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFOBActionPerformed(evt);
            }
        });

        txtCodNom.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOri, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOriDesc))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNroActa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFOB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDescrip, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMic, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCab, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMerca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSFac, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConsig, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTarNom, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(txtConsigNom, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(txtMercaNom, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(txtCodNom)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndlt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNroActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtOri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOriDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel20)
                    .addComponent(txtMic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel21)
                    .addComponent(txtConsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsigNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtCodNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel24)
                    .addComponent(txtTar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel25)
                    .addComponent(txtMercaNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel26)
                    .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel27)
                    .addComponent(txtSFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29)
                    .addComponent(btnMod)
                    .addComponent(btnAdd)
                    .addComponent(btndlt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGrabar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
        if (evt.isMetaDown() ){
            Dimension dim = new Dimension(400,200);
            dcdFecha.setCalendarPreferredSize(dim);
            dcdFecha.showDialog(null, true, this.getLocation());
            Calendar cal = dcdFecha.getSelectedDate();
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);
            String fecha = "";
            if(dia<10){
                fecha += "0"+dia;
            }else{
                fecha += dia;
            }
            if(mes<10){
                fecha += "/0"+mes;
            }else{
                fecha += "/"+mes;
            }
            fecha += "/"+ano;
            txtFecha.setText(fecha);
        }
    }//GEN-LAST:event_txtFechaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        
        if(tblDet.getRowCount()>0){
            if(txtNroActa.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese un numero de acta");
                txtNroActa.requestFocus();
            }else if(txtHora.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese la hora");
                txtHora.requestFocus();
            }else if(txtFecha.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese la fecha");
                txtFecha.requestFocus();
            }else if(txtOri.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese el lugar de ingreso");
                txtOri.requestFocus();
            }else{
                if("UPD".equals(mode)){
                    String eli = ActasControlador.eliActa(Integer.parseInt(txtNroActa.getText()));
//                    if("".equals(eli)){
//                        JOptionPane.showMessageDialog(null, "Aca ya borro todo el detalle");                        
//                    }
                }                
                List<Actas> acts = new ArrayList<>();
                for(int i = 0;i<tblDet.getRowCount();i++){
                    int Acta = Integer.parseInt(txtNroActa.getText());
                    int ori = Integer.parseInt(txtOri.getText());
                    String Desc = (String)tblDet.getValueAt(i, 9);                   
                    String descr = txtFecha.getText();
                    String dia = descr.substring(0, 2);
                    String mes = descr.substring(3,5);
                    String anho = descr.substring(6, 10);
                    String fecha = anho + "-" + mes + "-" + dia;                    
                    int mic = Integer.parseInt((String) tblDet.getValueAt(i, 0)) ; 
                    int codcab = Integer.parseInt((String) tblDet.getValueAt(i, 6)) ;
                    int codtar = Integer.parseInt((String) tblDet.getValueAt(i, 7)) ;
                    int consig_id = Integer.parseInt((String) tblDet.getValueAt(i, 1)) ;
                    int codmer = Integer.parseInt((String) tblDet.getValueAt(i, 4)) ;
                    String valor = (String)tblDet.getValueAt(i, 3);
                    String text = valor.replace(".", "");
                    double fob= Double.parseDouble(text.replace(",", "."));                        
                    acts.add(new Actas(Acta,txtHora.getText(), fecha, mic,0,codcab,codtar, consig_id,codmer,"",ori,0,"","",fob,Desc,"","",0,0,"1900-01-01","",0,0,0,0,"","",0,"",0,0,0,0,0,0,"",0,0,"","","","",usuario,fecha,txtHora.getText(),"A","",""));                                              
                    String res = ActasControlador.adMerc(acts);
                    if("".equals(res)){
                        boolean re = ActasControlador.modiConfig(Acta);
                        if(re){
                            this.dispose();   
                        }
                    }                                    
                }                                    
            }
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un Mic para grabar");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtNroActaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroActaActionPerformed
        txtFecha.requestFocus();
    }//GEN-LAST:event_txtNroActaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        txtOri.requestFocus();
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        Formato For = new Formato();
        txtFecha.setText(For.SetFomatoD(txtFecha.getText()));
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusLost
        Formato ft = new Formato();
        if(txtFecha.getText().isEmpty()){
            Calendar cal = Calendar.getInstance();
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH) + 1;
            String fecha="";
            if(dia<10){
                fecha +="0"+dia+"/";
            }else{
                fecha += dia+"/";
            }
            if(mes<10){
                fecha += "0"+mes+"/";
            }else{
                fecha += mes+"/";
            }
            fecha += cal.get(Calendar.YEAR);
            txtFecha.setText(fecha);
        }
        String fecha = ft.SetFomatoD(txtFecha.getText());
        try {
            if(!fecha.isEmpty()){
                if(!ft.VerifFecha(fecha)){
                    txtFecha.requestFocus();
                }
            }

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtFechaFocusLost

    private void txtOriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOriActionPerformed
        txtMic.requestFocus();
    }//GEN-LAST:event_txtOriActionPerformed

    private void txtOriFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOriFocusLost
        if(txtOri.getText().isEmpty()){
            SelecOrigen selOri = new SelecOrigen(null,true);
            selOri.setVisible(true);
            txtOri.setText(selOri.codigo+"");
            txtOriDesc.setText(selOri.desc);
        }else{
            Origen ori = OrigenControlador.recOri(Integer.parseInt(txtOri.getText()));
            if(ori!=null){
                txtOriDesc.setText(ori.getOri_descri().trim());
            }else{
                SelecOrigen selOri = new SelecOrigen(null,true);
                selOri.setVisible(true);
                txtOri.setText(selOri.codigo+"");
                txtOriDesc.setText(selOri.desc);
            }
        }
        
    }//GEN-LAST:event_txtOriFocusLost

    private void txtOriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOriKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtOriKeyTyped

    private void txtNroActaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroActaKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNroActaKeyTyped

    private void txtMicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMicKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMicKeyTyped

    private void txtConsigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsigKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtConsigKeyTyped

    private void txtMicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMicActionPerformed
        txtConsig.requestFocus();
    }//GEN-LAST:event_txtMicActionPerformed

    private void txtConsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsigActionPerformed
        txtFOB.requestFocus();
    }//GEN-LAST:event_txtConsigActionPerformed

    private void txtFOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFOBActionPerformed
        txtCab.requestFocus();
    }//GEN-LAST:event_txtFOBActionPerformed

    private void txtCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCabActionPerformed
        txtTar.requestFocus();
    }//GEN-LAST:event_txtCabActionPerformed

    private void txtTarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarActionPerformed
        txtMerca.requestFocus();
    }//GEN-LAST:event_txtTarActionPerformed

    private void txtMercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMercaActionPerformed
        txtDescrip.requestFocus();
    }//GEN-LAST:event_txtMercaActionPerformed

    private void txtDescripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripActionPerformed
        txtSFac.requestFocus();
    }//GEN-LAST:event_txtDescripActionPerformed

    private void txtSFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSFacActionPerformed
        btnAdd.requestFocus();
    }//GEN-LAST:event_txtSFacActionPerformed

    private void txtConsigFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConsigFocusLost
        if(txtConsig.getText().isEmpty()){
            SelecConsignatario selCons = new SelecConsignatario(null,true);
            selCons.setVisible(true);
            txtConsig.setText(selCons.codigo+"");
            txtConsigNom.setText(selCons.desc);
            txtCab.setText(selCons.codcab+"");
            txtTar.setText(selCons.codtar+"");
        }else{
            Consignatarios cons = ConsignatariosControlador.recConsig(Integer.parseInt(txtConsig.getText()));
            if(cons!=null){
                txtConsigNom.setText(cons.getCnnombre().trim());
            }else{
                SelecConsignatario selCons = new SelecConsignatario(null,true);
                selCons.setVisible(true);
                txtConsig.setText(selCons.codigo+"");
                txtConsigNom.setText(selCons.desc);
                txtCab.setText(selCons.codcab+"");
                txtTar.setText(selCons.codtar+"");                
            }
        }
    }//GEN-LAST:event_txtConsigFocusLost

    private void txtTarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTarKeyTyped

    private void txtTarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTarFocusLost
        if(txtTar.getText().isEmpty()||txtCab.getText().isEmpty()){
            SelecTarifas selTar = new SelecTarifas(null,true);
            selTar.setVisible(true);
            txtTar.setText(selTar.cab+"");
            txtCab.setText(selTar.codigo+"");
            txtTarNom.setText(selTar.desc);
        }else{
            int cab = Integer.parseInt(txtCab.getText());
            String res = TarifasControlador.RecupCodDes(cab);
            txtCodNom.setText(res);              
            int tarifa = Integer.parseInt(txtTar.getText());
            Tarifas tar = TarifasControlador.recTar(cab, tarifa);
            if(tar!=null){
                txtTarNom.setText(tar.getTt_abrevia());
            }else{
                SelecTarifas selTar = new SelecTarifas(null,true);
                selTar.setVisible(true);
                txtTar.setText(selTar.cab+"");
                txtCab.setText(selTar.codigo+"");
                cab = Integer.parseInt(txtCab.getText());
                res = TarifasControlador.RecupCodDes(cab);
                txtCodNom.setText(res);                  
                txtTarNom.setText(selTar.desc);
            }
        }  
    }//GEN-LAST:event_txtTarFocusLost

    private void txtMercaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMercaKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMercaKeyTyped

    private void txtMercaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMercaFocusLost
//        if(txtMerca.getText().isEmpty()){
//            SelecMerca selMer = new SelecMerca(null,true);
//            selMer.setVisible(true);
//            txtMerca.setText(selMer.codigo+"");
//            txtMercaNom.setText(selMer.desc);
//        }else{
//            Mercaderias merca = MercaderiasControlador.recMerc(Integer.parseInt(txtMerca.getText()));
//            if(merca!=null){
//                txtMercaNom.setText(merca.getTm_descrip());
//            }else{
//                SelecMerca selMer = new SelecMerca(null,true);
//                selMer.setVisible(true);
//                txtMerca.setText(selMer.codigo+"");
//                txtMercaNom.setText(selMer.desc);
//            }
//        }
    }//GEN-LAST:event_txtMercaFocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Object[] obj = {txtMic.getText(),txtConsig.getText(),txtConsigNom.getText(),txtFOB.getText(),txtMerca.getText()
                ,txtMercaNom.getText(),txtCab.getText(),txtTar.getText(),txtTarNom.getText(),txtDescrip.getText(),txtSFac.getText()};
        tabla.addRow(obj);
        //txtMic.setText("");
        txtMic.requestFocus();
        txtConsig.setText("");
        txtConsigNom.setText("");
        txtFOB.setText("");
        txtMerca.setText("");
        txtMercaNom.setText("");
        txtCab.setText("");
        txtTar.setText("");
        txtTarNom.setText("");
        txtDescrip.setText("");
        txtSFac.setText("");
        txtCodNom.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btndltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndltActionPerformed
        if(tblDet.getSelectedRow()>=0){
            tabla.removeRow(tblDet.getSelectedRow());
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el registro");
        }
    }//GEN-LAST:event_btndltActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        if(tblDet.getSelectedRow()>=0){
            txtMic.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 0).toString());
            txtConsig.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 1).toString());
            txtConsigNom.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 2).toString());
            txtFOB.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 3).toString());
            txtMerca.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 4).toString());
            txtMercaNom.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 5).toString());
            txtCab.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 6).toString());
            txtTar.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 7).toString());
            txtTarNom.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 8).toString());
            txtDescrip.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 9).toString());
            txtSFac.setText(tblDet.getValueAt(tblDet.getSelectedRow(), 10).toString());
        int cab = Integer.parseInt(txtCab.getText());
        String res = TarifasControlador.RecupCodDes(cab);
        txtCodNom.setText(res);      

            tabla.removeRow(tblDet.getSelectedRow());
        txtMic.requestFocus();            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el registro");
        }
    }//GEN-LAST:event_btnModActionPerformed

    private void txtCabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCabFocusLost
        int cab = Integer.parseInt(txtCab.getText());
        String res = TarifasControlador.RecupCodDes(cab);
        txtCodNom.setText(res);
    }//GEN-LAST:event_txtCabFocusLost

    private void txtDescripFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripFocusGained
        if(txtMerca.getText().isEmpty()){
            SelecMerca selMer = new SelecMerca(null,true);
            selMer.setVisible(true);
            txtMerca.setText(selMer.codigo+"");
            txtMercaNom.setText(selMer.desc);
        }else{
            Mercaderias merca = MercaderiasControlador.recMerc(Integer.parseInt(txtMerca.getText()));
            if(merca!=null){
                txtMercaNom.setText(merca.getTm_descrip());
            }else{
                SelecMerca selMer = new SelecMerca(null,true);
                selMer.setVisible(true);
                txtMerca.setText(selMer.codigo+"");
                txtMercaNom.setText(selMer.desc);
            }
        }
    }//GEN-LAST:event_txtDescripFocusGained

    private void txtMercaNomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMercaNomFocusGained
        if(txtMerca.getText().isEmpty()){
            SelecMerca selMer = new SelecMerca(null,true);
            selMer.setVisible(true);
            txtMerca.setText(selMer.codigo+"");
            txtMercaNom.setText(selMer.desc);
        }else{
            Mercaderias merca = MercaderiasControlador.recMerc(Integer.parseInt(txtMerca.getText()));
            if(merca!=null){
                txtMercaNom.setText(merca.getTm_descrip());
            }else{
                SelecMerca selMer = new SelecMerca(null,true);
                selMer.setVisible(true);
                txtMerca.setText(selMer.codigo+"");
                txtMercaNom.setText(selMer.desc);
            }
        }      
    }//GEN-LAST:event_txtMercaNomFocusGained

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
//            java.util.logging.Logger.getLogger(ActasCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ActasCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ActasCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ActasCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ActasCarga dialog = new ActasCarga(new javax.swing.JFrame());
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btndlt;
    private datechooser.beans.DateChooserDialog dcdFecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDet;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtCab;
    private javax.swing.JTextField txtCodNom;
    private javax.swing.JTextField txtConsig;
    private javax.swing.JTextField txtConsigNom;
    private javax.swing.JTextField txtDescrip;
    private javax.swing.JFormattedTextField txtFOB;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMerca;
    private javax.swing.JTextField txtMercaNom;
    private javax.swing.JTextField txtMic;
    private javax.swing.JTextField txtNroActa;
    private javax.swing.JTextField txtOri;
    private javax.swing.JTextField txtOriDesc;
    private javax.swing.JTextField txtSFac;
    private javax.swing.JTextField txtTar;
    private javax.swing.JTextField txtTarNom;
    // End of variables declaration//GEN-END:variables
}
