
package pkg_Formulario.Menu.subMenu.Empleado;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pkg_Formulario.Menu.subMenu.ClassUtil.DistritoComboModel;
import pkg_Formulario.Menu.subMenu.ClassUtil.RolComboModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_Modelo.Entidades.Empleado;
import pkg_utilidades.Utilidades;


public class FrmEmpleado extends javax.swing.JPanel {

   private final IMaster master;
   private final EmpleadoTableModel table_empleado;
   
    public FrmEmpleado(IMaster master) throws IException {
        initComponents();
        table_empleado=new EmpleadoTableModel(master.getIEmpleado());
        tbl_Empleado.setModel(table_empleado);
        this.master=master;
        table_empleado.getObtenerTodos();
         panel_detalle_empleado.setEditable(false);
          panel_detalle_empleado.setEmpleado(null);
         panel_detalle_empleado.setCombo_distrito(new DistritoComboModel(master.getIDistrito()));
         panel_detalle_empleado.setCombo_rol(new RolComboModel(master.getIRol()));
                  
         activarBotonesCRUD(false);
         activarBotonesGuardar(false);
         rb_Cod.setSelected(true);
         valor=1;
         this.tbl_Empleado.getSelectionModel().addListSelectionListener(e ->
        {
            activarBotonesCRUD(tbl_Empleado.getSelectedRow()!=-1);
        });
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
      table_empleado.getObtenerTodos();
      table_empleado.fireTableDataChanged();
    }
    
         private Empleado getEmpleadoSelection() throws IException{
        String id= tbl_Empleado.getValueAt(tbl_Empleado.getSelectedRow(),0).toString();
        return master.getIEmpleado().ObtenerOne(id);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_bg = new javax.swing.JPanel();
        panel_data_empleado = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        panel_detalle_empleado = new pkg_Formulario.Menu.subMenu.Empleado.EmpleadoDataPanel();
        panel_busqueda = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Buscado = new javax.swing.JTextField();
        rb_Cod = new javax.swing.JRadioButton();
        rb_NombreA = new javax.swing.JRadioButton();
        rb_Distrito = new javax.swing.JRadioButton();
        btn_Buscar = new javax.swing.JButton();
        btn_pdf = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_txt = new javax.swing.JButton();
        panel_titulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Empleado = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        panel_bg.setBackground(new java.awt.Color(0, 0, 51));
        panel_bg.setMaximumSize(new java.awt.Dimension(815, 734));
        panel_bg.setLayout(new java.awt.GridBagLayout());

        panel_data_empleado.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(btn_Nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Cancelar)
            .addComponent(btn_Nuevo)
            .addComponent(btn_Borrar)
            .addComponent(btn_Editar)
            .addComponent(btn_Guardar)
        );

        javax.swing.GroupLayout panel_data_empleadoLayout = new javax.swing.GroupLayout(panel_data_empleado);
        panel_data_empleado.setLayout(panel_data_empleadoLayout);
        panel_data_empleadoLayout.setHorizontalGroup(
            panel_data_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_data_empleadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_data_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_detalle_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(917, 917, 917))
        );
        panel_data_empleadoLayout.setVerticalGroup(
            panel_data_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_data_empleadoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(panel_detalle_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -913;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 0, 0);
        panel_bg.add(panel_data_empleado, gridBagConstraints);

        panel_busqueda.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));

        jLabel2.setText("Buscar:");

        buttonGroup1.add(rb_Cod);
        rb_Cod.setText("Codigo");
        rb_Cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_CodActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_NombreA);
        rb_NombreA.setText("Nombre/Apellido");
        rb_NombreA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_NombreAActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Distrito);
        rb_Distrito.setText("Distrito");
        rb_Distrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_DistritoActionPerformed(evt);
            }
        });

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/buscar.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(rb_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_NombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_Distrito, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(btn_pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Buscado))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_Cod)
                            .addComponent(rb_NombreA)
                            .addComponent(rb_Distrito)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_excel)
                        .addComponent(btn_txt)
                        .addComponent(btn_pdf))))
        );

        javax.swing.GroupLayout panel_busquedaLayout = new javax.swing.GroupLayout(panel_busqueda);
        panel_busqueda.setLayout(panel_busquedaLayout);
        panel_busquedaLayout.setHorizontalGroup(
            panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busquedaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 927, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_busquedaLayout.setVerticalGroup(
            panel_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        panel_bg.add(panel_busqueda, gridBagConstraints);

        panel_titulo.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLEADO");

        javax.swing.GroupLayout panel_tituloLayout = new javax.swing.GroupLayout(panel_titulo);
        panel_titulo.setLayout(panel_tituloLayout);
        panel_tituloLayout.setHorizontalGroup(
            panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_tituloLayout.setVerticalGroup(
            panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tituloLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        panel_bg.add(panel_titulo, gridBagConstraints);

        panel_tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));

        tbl_Empleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Empleado);

        javax.swing.GroupLayout panel_tablaLayout = new javax.swing.GroupLayout(panel_tabla);
        panel_tabla.setLayout(panel_tablaLayout);
        panel_tablaLayout.setHorizontalGroup(
            panel_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_tablaLayout.setVerticalGroup(
            panel_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 38, 0);
        panel_bg.add(panel_tabla, gridBagConstraints);

        add(panel_bg, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        panel_detalle_empleado.setEmpleado(null);
        panel_detalle_empleado.DataLoad();
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        tbl_Empleado.clearSelection();
        panel_detalle_empleado.setEditable(false);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
             try {
            activarBotonesGuardar(true);
            panel_detalle_empleado.setEditable(true);
            panel_detalle_empleado.setEmpleado(null);
            panel_detalle_empleado.DataLoad();
            panel_detalle_empleado.setCod(master.getIEmpleado().NewCodigo());
            activarBotonesCRUD(false);
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "EMPLEADO NEW ".concat(ex.toString()), 0);

        }
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        try { 
            panel_detalle_empleado.DataSave();
            Empleado cliente_existe = master.getIEmpleado().ObtenerOne(panel_detalle_empleado.getCod());
            Empleado cliente_data = panel_detalle_empleado.getEmpleado();
            if(cliente_existe!=null)
            {
                master.getIEmpleado().Actualizar(cliente_data);
            }else{
                master.getIEmpleado().Insertar(cliente_data);
            }
            panel_detalle_empleado.setEmpleado(null);
            panel_detalle_empleado.setEditable(false);
            panel_detalle_empleado.DataLoad();
            ObtenerTodos();
            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "EMPLEADO SAVE ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
 try {
            activarBotonesGuardar(true);
            panel_detalle_empleado.setEditable(true);
            panel_detalle_empleado.setEmpleado(getEmpleadoSelection());
            panel_detalle_empleado.DataLoad();
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "EMPLEADO EDIT ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
   if(JOptionPane.showConfirmDialog(null,"¿Seguro que quiere borrar este Empleado?","BORRAR CLIENTE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            try {
                Empleado empleado_borra = getEmpleadoSelection();
                master.getIEmpleado().Eliminar(empleado_borra);
                ObtenerTodos();
                tbl_Empleado.clearSelection();

                activarBotonesCRUD(false);
                activarBotonesGuardar(false);

            } catch (IException ex) {
                Utilidades.Mensaje("ERROR", "CLIENTE CLEAR ".concat(ex.toString()), 0);
            }
        }
    }//GEN-LAST:event_btn_BorrarActionPerformed
private int valor;
    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
       try {
        String textoBuscado = txt_Buscado.getText();
        EmpleadoTableModel tablita=new EmpleadoTableModel(master.getIEmpleado());
           switch (valor) {
               case 1:
                   tablita.getObtenerIDS(textoBuscado);
                   break;
               case 2:
                   tablita.getObtenerNombreApellido(textoBuscado);
                   break;
               case 3:
                   tablita.getObtenerDistrito(textoBuscado);
                   break;
               default:
                   break;
           }
            tbl_Empleado.setModel(tablita);
        
    } catch (IException ex) {
        Logger.getLogger(FrmEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed

    }//GEN-LAST:event_btn_pdfActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed

    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_txtActionPerformed

    }//GEN-LAST:event_btn_txtActionPerformed

    private void rb_CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_CodActionPerformed
     valor=1;
    }//GEN-LAST:event_rb_CodActionPerformed

    private void rb_NombreAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_NombreAActionPerformed
        valor=2;
    }//GEN-LAST:event_rb_NombreAActionPerformed

    private void rb_DistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_DistritoActionPerformed
       valor=3;
    }//GEN-LAST:event_rb_DistritoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JPanel panel_busqueda;
    private javax.swing.JPanel panel_data_empleado;
    private pkg_Formulario.Menu.subMenu.Empleado.EmpleadoDataPanel panel_detalle_empleado;
    private javax.swing.JPanel panel_tabla;
    private javax.swing.JPanel panel_titulo;
    private javax.swing.JRadioButton rb_Cod;
    private javax.swing.JRadioButton rb_Distrito;
    private javax.swing.JRadioButton rb_NombreA;
    private javax.swing.JTable tbl_Empleado;
    private javax.swing.JTextField txt_Buscado;
    // End of variables declaration//GEN-END:variables
}
