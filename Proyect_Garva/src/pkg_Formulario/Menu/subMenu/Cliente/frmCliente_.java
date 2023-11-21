
package pkg_Formulario.Menu.subMenu.Cliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_Modelo.Entidades.Cliente;
import pkg_utilidades.Utilidades;

public class frmCliente_ extends javax.swing.JPanel {

   private final IMaster masterI;
private ClienteTableModel model_table;

    public frmCliente_(IMaster masterI) throws IException {
        initComponents();
        this.model_table = new ClienteTableModel(masterI.getICliente());
        tbl_Cliente1.setModel(model_table);
        this.masterI = masterI;
        model_table.getObtenerTodos();
        panel_detalle_Cliente.setEditable(false);
        
        panel_detalle_Cliente.setCliente(null);
        panel_detalle_Cliente.setModel_combo_distrito(new DistritoComboModel(masterI.getIDistrito()));
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        
        
         this.tbl_Cliente1.getSelectionModel().addListSelectionListener(e ->
        {
            activarBotonesCRUD(tbl_Cliente1.getSelectedRow()!=-1);
        });
         Init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_Registro = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btn_Nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_Editar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_Guardar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        panel_detalle_Cliente = new pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Cliente1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_Pagar_adelanto = new javax.swing.JButton();
        btn_Cancelar_pago = new javax.swing.JButton();
        panel_Container_pago = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Buscado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Nuevo1 = new javax.swing.JButton();
        btn_Nuevo2 = new javax.swing.JButton();
        btn_Nuevo3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(840, 242));

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));
        jToolBar1.setRollover(true);

        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/new.png"))); // NOI18N
        btn_Nuevo.setText("Nuevo");
        btn_Nuevo.setBorderPainted(false);
        btn_Nuevo.setContentAreaFilled(false);
        btn_Nuevo.setFocusable(false);
        btn_Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Nuevo);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jToolBar1.add(jSeparator1);

        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/edit.png"))); // NOI18N
        btn_Editar.setText("Editar");
        btn_Editar.setBorderPainted(false);
        btn_Editar.setContentAreaFilled(false);
        btn_Editar.setEnabled(false);
        btn_Editar.setFocusable(false);
        btn_Editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Editar);

        btn_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/clear.png"))); // NOI18N
        btn_Borrar.setText("Borrar");
        btn_Borrar.setBorderPainted(false);
        btn_Borrar.setContentAreaFilled(false);
        btn_Borrar.setEnabled(false);
        btn_Borrar.setFocusable(false);
        btn_Borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Borrar);

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jToolBar1.add(jSeparator2);

        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/Save.png"))); // NOI18N
        btn_Guardar.setText("Guardar");
        btn_Guardar.setBorderPainted(false);
        btn_Guardar.setContentAreaFilled(false);
        btn_Guardar.setEnabled(false);
        btn_Guardar.setFocusable(false);
        btn_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Guardar);

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/cancel.png"))); // NOI18N
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.setBorderPainted(false);
        btn_Cancelar.setContentAreaFilled(false);
        btn_Cancelar.setEnabled(false);
        btn_Cancelar.setFocusable(false);
        btn_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_Cancelar);

        panel_detalle_Cliente.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));

        tbl_Cliente1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_Cliente1);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));

        btn_Pagar_adelanto.setText("Pagar Adelanto");
        btn_Pagar_adelanto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pagar_adelantoActionPerformed(evt);
            }
        });

        btn_Cancelar_pago.setText("Cancelar");
        btn_Cancelar_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_pagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Container_pagoLayout = new javax.swing.GroupLayout(panel_Container_pago);
        panel_Container_pago.setLayout(panel_Container_pagoLayout);
        panel_Container_pagoLayout.setHorizontalGroup(
            panel_Container_pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panel_Container_pagoLayout.setVerticalGroup(
            panel_Container_pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_Cancelar_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Pagar_adelanto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_Container_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_Pagar_adelanto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cancelar_pago))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panel_Container_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));

        jLabel2.setText("Buscar:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/buscar.png"))); // NOI18N

        jRadioButton1.setText("Codigo");

        jRadioButton2.setText("Nombre");

        jRadioButton3.setText("Apellido");

        jLabel3.setText("Exportar:");

        btn_Nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/new.png"))); // NOI18N
        btn_Nuevo1.setText("Nuevo");
        btn_Nuevo1.setBorderPainted(false);
        btn_Nuevo1.setContentAreaFilled(false);
        btn_Nuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Nuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nuevo1ActionPerformed(evt);
            }
        });

        btn_Nuevo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/new.png"))); // NOI18N
        btn_Nuevo2.setText("Nuevo");
        btn_Nuevo2.setBorderPainted(false);
        btn_Nuevo2.setContentAreaFilled(false);
        btn_Nuevo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Nuevo2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Nuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nuevo2ActionPerformed(evt);
            }
        });

        btn_Nuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/new.png"))); // NOI18N
        btn_Nuevo3.setText("Nuevo");
        btn_Nuevo3.setBorderPainted(false);
        btn_Nuevo3.setContentAreaFilled(false);
        btn_Nuevo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Nuevo3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Nuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nuevo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(btn_Nuevo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Nuevo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Nuevo2)
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Nuevo2)
                            .addComponent(btn_Nuevo1)
                            .addComponent(btn_Nuevo3))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_RegistroLayout = new javax.swing.GroupLayout(panel_Registro);
        panel_Registro.setLayout(panel_RegistroLayout);
        panel_RegistroLayout.setHorizontalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addGroup(panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addGroup(panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_RegistroLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_RegistroLayout.setVerticalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Cancelar_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancelar_pagoActionPerformed
        Init();
        btn_Cancelar_pago.setVisible(false);
    }//GEN-LAST:event_btn_Cancelar_pagoActionPerformed

    private void btn_Pagar_adelantoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pagar_adelantoActionPerformed
        initSelection(new DetalleAdelantoPanel());
        btn_Cancelar_pago.setVisible(true);
    }//GEN-LAST:event_btn_Pagar_adelantoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        panel_detalle_Cliente.setCliente(null);
        panel_detalle_Cliente.DataLoad();
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        tbl_Cliente1.clearSelection();
        panel_detalle_Cliente.setEditable(false);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        try {
            panel_detalle_Cliente.DataSave();
            Cliente cliente_existe = masterI.getICliente().ObtenerOne(panel_detalle_Cliente.getCod());
            Cliente cliente_data = panel_detalle_Cliente.getCliente();
            if(cliente_existe!=null)
            {
                masterI.getICliente().Actualizar(cliente_data);
            }else{
                masterI.getICliente().Insertar(cliente_data);
            }
            panel_detalle_Cliente.setCliente(null);
            panel_detalle_Cliente.setEditable(false);
            panel_detalle_Cliente.DataLoad();
            ObtenerTodos();
            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "CLIENTE SAVE ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null,"¿Seguro que quiere borrar este Cliente?","BORRAR CLIENTE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            try {
                Cliente cliente_borra = getClienteSelection();
                masterI.getICliente().Eliminar(cliente_borra);
                ObtenerTodos();
                tbl_Cliente1.clearSelection();

                activarBotonesCRUD(false);
                activarBotonesGuardar(false);

            } catch (IException ex) {
                Utilidades.Mensaje("ERROR", "CLIENTE CLEAR ".concat(ex.toString()), 0);
            }
        }
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed

        try {
            activarBotonesGuardar(true);
            panel_detalle_Cliente.setEditable(true);
            panel_detalle_Cliente.setCliente(getClienteSelection());
            panel_detalle_Cliente.DataLoad();
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "CLIENTE EDIT ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        try {
            activarBotonesGuardar(true);
            panel_detalle_Cliente.setEditable(true);
            panel_detalle_Cliente.setCliente(null);
            panel_detalle_Cliente.DataLoad();
            panel_detalle_Cliente.setCod(masterI.getICliente().NewCodigo());
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "CLIENTE NEW ".concat(ex.toString()), 0);

        }
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_Nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Nuevo1ActionPerformed

    private void btn_Nuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nuevo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Nuevo2ActionPerformed

    private void btn_Nuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nuevo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Nuevo3ActionPerformed
 
    private void Init(){
        panel_Container_pago.removeAll();
        panel_Container_pago.repaint();
        panel_Container_pago.revalidate();
    }
    
    private void initSelection(JPanel panel){
        panel.setSize(175,79);
        panel.setLocation(10,10);
        
        panel_Container_pago.removeAll();
        panel_Container_pago.add(panel);
        panel_Container_pago.repaint();
        panel_Container_pago.revalidate();
    }
      
    private Cliente getClienteSelection() throws IException{
        String id= tbl_Cliente1.getValueAt(tbl_Cliente1.getSelectedRow(),0).toString();
        return masterI.getICliente().ObtenerOne(id);
    }
    
    private void activarBotonesCRUD(boolean activo){
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
        this.btn_Pagar_adelanto.setVisible(activo);
        this.btn_Cancelar_pago.setVisible(false);
         Init();
       } 
      
    private void activarBotonesGuardar(boolean activo){
        this.btn_Guardar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
        this.btn_Pagar_adelanto.setVisible(activo);
        this.btn_Cancelar_pago.setVisible(false);
         Init();
       }
      
    private void ObtenerTodos() throws IException{
      model_table.getObtenerTodos();
      model_table.fireTableDataChanged();
    }
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Cancelar_pago;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Nuevo1;
    private javax.swing.JButton btn_Nuevo2;
    private javax.swing.JButton btn_Nuevo3;
    private javax.swing.JButton btn_Pagar_adelanto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panel_Container_pago;
    private javax.swing.JPanel panel_Registro;
    private pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel panel_detalle_Cliente;
    private javax.swing.JTable tbl_Cliente1;
    private javax.swing.JTextField txt_Buscado;
    // End of variables declaration//GEN-END:variables
}
