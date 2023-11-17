
package pkg_Formulario.Menu.subMenu.Cliente;

import javax.swing.JOptionPane;
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
        tbl_Cliente.setModel(model_table);
        this.masterI = masterI;
        model_table.getUpdate();
        panel_detalle_Cliente.setEditable(false);
        panel_detalle_Cliente.setCliente(null);
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        
        
         this.tbl_Cliente.getSelectionModel().addListSelectionListener(e ->
        {
            activarBotonesCRUD(tbl_Cliente.getSelectedRow()!=-1);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_Registro = new javax.swing.JPanel();
        panel_detalle_Cliente = new pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel();
        jToolBar1 = new javax.swing.JToolBar();
        btn_Nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_Editar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_Guardar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        panel_Muestra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cliente = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(840, 242));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

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

        javax.swing.GroupLayout panel_RegistroLayout = new javax.swing.GroupLayout(panel_Registro);
        panel_Registro.setLayout(panel_RegistroLayout);
        panel_RegistroLayout.setHorizontalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_RegistroLayout.setVerticalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegistroLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_detalle_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", panel_Registro);

        tbl_Cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Cliente);

        javax.swing.GroupLayout panel_MuestraLayout = new javax.swing.GroupLayout(panel_Muestra);
        panel_Muestra.setLayout(panel_MuestraLayout);
        panel_MuestraLayout.setHorizontalGroup(
            panel_MuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MuestraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addGap(130, 130, 130))
        );
        panel_MuestraLayout.setVerticalGroup(
            panel_MuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MuestraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cliente", panel_Muestra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
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
  
    private Cliente getClienteSelection() throws IException
    {
        long id=(long) tbl_Cliente.getValueAt(tbl_Cliente.getSelectedRow(),0);
        return masterI.getICliente().ObtenerOne(id);
    }
    private void activarBotonesCRUD(boolean activo)
       {
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
       
       } 
      
     private  void activarBotonesGuardar(boolean activo)
       {
        this.btn_Guardar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
       }
      
      private final void Update_table() throws IException
    {
        model_table.getUpdate();
        model_table.fireTableDataChanged();
    }
    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        activarBotonesGuardar(true);
        panel_detalle_Cliente.setEditable(true);
        panel_detalle_Cliente.setCliente(null);
        panel_detalle_Cliente.DataLoad();
    }//GEN-LAST:event_btn_NuevoActionPerformed

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

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null,"¿Seguro que quiere borrar este Cliente?","BORRAR CLIENTE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            try {
                Cliente cliente_borra = getClienteSelection();
                masterI.getICliente().Eliminar(cliente_borra);
                Update_table();
                tbl_Cliente.clearSelection();
                activarBotonesCRUD(false);
                activarBotonesGuardar(false);

            } catch (IException ex) {
           Utilidades.Mensaje("ERROR", "CLIENTE CLEAR ".concat(ex.toString()), 0);
          }
        }
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        try {
            panel_detalle_Cliente.DataSave();
            Cliente cliente_data = panel_detalle_Cliente.getCliente();
            if(cliente_data.getId()!=null)
            {
                masterI.getICliente().Actualizar(cliente_data);
            }else{
                masterI.getICliente().Insertar(cliente_data);
            }
            panel_detalle_Cliente.setCliente(null);
            panel_detalle_Cliente.setEditable(false);
            panel_detalle_Cliente.DataLoad();
            Update_table();
            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        } catch (IException ex) {
          Utilidades.Mensaje("ERROR", "CLIENTE SAVE ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        panel_detalle_Cliente.setCliente(null);
        panel_detalle_Cliente.setEditable(false);
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        tbl_Cliente.clearSelection();
        panel_detalle_Cliente.DataLoad();
    }//GEN-LAST:event_btn_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panel_Muestra;
    private javax.swing.JPanel panel_Registro;
    private pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel panel_detalle_Cliente;
    private javax.swing.JTable tbl_Cliente;
    // End of variables declaration//GEN-END:variables
}
