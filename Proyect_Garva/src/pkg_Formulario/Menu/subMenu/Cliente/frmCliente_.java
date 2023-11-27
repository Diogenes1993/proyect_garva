
package pkg_Formulario.Menu.subMenu.Cliente;

import pkg_Formulario.Menu.subMenu.ClassUtil.DistritoComboModel;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Cliente1 = new javax.swing.JTable();
        panel_registro_cliente = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        panel_detalle_Cliente = new pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel();
        panel_busqueda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Buscado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btn_excel = new javax.swing.JButton();
        btn_txt = new javax.swing.JButton();
        btn_pdf = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(840, 242));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        panel_title.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        panel_table.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));
        panel_table.setPreferredSize(new java.awt.Dimension(480, 281));

        tbl_Cliente1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
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
        tbl_Cliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tbl_Cliente1);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_registro_cliente.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), java.awt.Color.white));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addComponent(btn_Nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Nuevo)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Guardar)
                    .addComponent(btn_Borrar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_registro_clienteLayout = new javax.swing.GroupLayout(panel_registro_cliente);
        panel_registro_cliente.setLayout(panel_registro_clienteLayout);
        panel_registro_clienteLayout.setHorizontalGroup(
            panel_registro_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registro_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_registro_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_registro_clienteLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_registro_clienteLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_registro_clienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_registro_clienteLayout.setVerticalGroup(
            panel_registro_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registro_clienteLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );

        panel_busqueda.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));

        jLabel2.setText("Buscar:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/buscar.png"))); // NOI18N

        jRadioButton1.setText("Codigo");

        jRadioButton2.setText("Nombre/Apellido");

        jRadioButton3.setText("Distritro");

        jLabel3.setText("Exportar:");

        btn_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Export/excel.png"))); // NOI18N
        btn_excel.setBorderPainted(false);
        btn_excel.setContentAreaFilled(false);
        btn_excel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_excel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Export/txt.png"))); // NOI18N
        btn_txt.setBorderPainted(false);
        btn_txt.setContentAreaFilled(false);
        btn_txt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_txt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_txtActionPerformed(evt);
            }
        });

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Export/pdf.png"))); // NOI18N
        btn_pdf.setBorderPainted(false);
        btn_pdf.setContentAreaFilled(false);
        btn_pdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_busquedaLayout = new javax.swing.GroupLayout(panel_busqueda);
        panel_busqueda.setLayout(panel_busquedaLayout);
        panel_busquedaLayout.setHorizontalGroup(
            panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_busquedaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel3))
                    .addGroup(panel_busquedaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panel_busquedaLayout.setVerticalGroup(
            panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_excel)
                            .addComponent(btn_txt)
                            .addComponent(btn_pdf)))
                    .addGroup(panel_busquedaLayout.createSequentialGroup()
                        .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txt_Buscado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_registro_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_registro_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_txtActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pdfActionPerformed
 
   
      
    private Cliente getClienteSelection() throws IException{
        String id= tbl_Cliente1.getValueAt(tbl_Cliente1.getSelectedRow(),0).toString();
        return masterI.getICliente().ObtenerOne(id);
    }
    
    private void activarBotonesCRUD(boolean activo){
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
      
       } 
      
    private void activarBotonesGuardar(boolean activo){
        this.btn_Guardar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
   
       }
      
    private void ObtenerTodos() throws IException{
      model_table.getObtenerTodos();
      model_table.fireTableDataChanged();
    }
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel_busqueda;
    private pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel panel_detalle_Cliente;
    private javax.swing.JPanel panel_registro_cliente;
    private javax.swing.JPanel panel_table;
    private javax.swing.JPanel panel_title;
    private javax.swing.JTable tbl_Cliente1;
    private javax.swing.JTextField txt_Buscado;
    // End of variables declaration//GEN-END:variables
}
