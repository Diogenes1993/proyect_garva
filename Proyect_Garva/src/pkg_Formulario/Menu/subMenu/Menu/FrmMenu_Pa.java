
package pkg_Formulario.Menu.subMenu.Menu;

import javax.swing.JOptionPane;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Rol;
import pkg_utilidades.Utilidades;


public class FrmMenu_Pa extends javax.swing.JPanel {

   private final IMaster masterI;
    private final MenuTableModel menu_model;
    
    public FrmMenu_Pa(IMaster masterI) throws IException {
        initComponents();
         initComponents();
        menu_model =new MenuTableModel(masterI.getIMenu());
        tbl_Menu.setModel(menu_model);
        this.masterI=masterI;
        menu_model.getObtenerTodos();
        panel_detalle_menu.setEditable(false);
        panel_detalle_menu.setMenu(null);
        
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        
        this.tbl_Menu.getSelectionModel().addListSelectionListener(e ->{
                
            activarBotonesCRUD(tbl_Menu.getSelectedRow()!=-1);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_bg_frm = new javax.swing.JPanel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Menu = new javax.swing.JTable();
        panel_title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_crud = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        panel_detalle_menu = new pkg_Formulario.Menu.subMenu.Menu.PanelDetalleMenu();

        setLayout(new java.awt.BorderLayout());

        tbl_Menu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Menu);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel_title.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/crud_tamaño/cancel.png"))); // NOI18N
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

        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/crud_tamaño/new.png"))); // NOI18N
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

        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/crud_tamaño/Save.png"))); // NOI18N
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

        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/crud_tamaño/edit.png"))); // NOI18N
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

        btn_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/crud/crud_tamaño/clear.png"))); // NOI18N
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

        javax.swing.GroupLayout panel_crudLayout = new javax.swing.GroupLayout(panel_crud);
        panel_crud.setLayout(panel_crudLayout);
        panel_crudLayout.setHorizontalGroup(
            panel_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Borrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_crudLayout.setVerticalGroup(
            panel_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_crudLayout.createSequentialGroup()
                .addComponent(btn_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_bg_frmLayout = new javax.swing.GroupLayout(panel_bg_frm);
        panel_bg_frm.setLayout(panel_bg_frmLayout);
        panel_bg_frmLayout.setHorizontalGroup(
            panel_bg_frmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bg_frmLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panel_bg_frmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_bg_frmLayout.createSequentialGroup()
                        .addGroup(panel_bg_frmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_detalle_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_bg_frmLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addComponent(panel_crud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel_bg_frmLayout.setVerticalGroup(
            panel_bg_frmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bg_frmLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panel_bg_frmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bg_frmLayout.createSequentialGroup()
                        .addComponent(panel_detalle_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bg_frmLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(panel_crud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        add(panel_bg_frm, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        panel_detalle_menu.setMenu(null);
        panel_detalle_menu.DataLoad();
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        panel_detalle_menu.setEditable(false);
        tbl_Menu.clearSelection();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        try {
            activarBotonesGuardar(true);
            panel_detalle_menu.setEditable(true);
            panel_detalle_menu.setMenu(null);
            panel_detalle_menu.DataLoad();
            panel_detalle_menu.setCod(masterI.getIRol().newCodigo());
            tbl_Menu.clearSelection();
            activarBotonesCRUD(false);
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "ROL NEW ".concat(ex.toString()), 0);

        }
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        try {
            panel_detalle_menu.DataSave();
            Menu menu_existe = masterI.getIMenu().ObtenerOne(panel_detalle_menu.getCod());
            Menu menu_data = panel_detalle_menu.getMenu();
            if(menu_existe!=null)
            {
                masterI.getIMenu().Actualizar(menu_data);
            }else{
                masterI.getIMenu().Insertar(menu_data);
            }
            panel_detalle_menu.setMenu(null);
            panel_detalle_menu.setEditable(false);
            panel_detalle_menu.DataLoad();
            ObtenerTodos();
            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "ROL SAVE ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        try {
            activarBotonesGuardar(true);
            panel_detalle_menu.setEditable(true);
            panel_detalle_menu.setMenu(getMenuSelection());
            panel_detalle_menu.DataLoad();
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR", "ROL EDIT ".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null,"¿Seguro que quiere borrar este Cargo?","BORRAR CARGO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            try {
                Menu menu_borra = getMenuSelection();
                masterI.getIMenu().Eliminar(menu_borra);
                ObtenerTodos();
                tbl_Menu.clearSelection();

                activarBotonesCRUD(false);
                activarBotonesGuardar(false);

            } catch (IException ex) {
                Utilidades.Mensaje("ERROR", "ROL CLEAR ".concat(ex.toString()), 0);
            }
        }
    }//GEN-LAST:event_btn_BorrarActionPerformed
private void activarBotonesCRUD(boolean activo){
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
          } 
      
    private void activarBotonesGuardar(boolean activo){
        this.btn_Guardar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
       }
      
      private void ObtenerTodos() throws IException{
      menu_model.getObtenerTodos();
      menu_model.fireTableDataChanged();
    }
    
         private Menu getMenuSelection() throws IException{
        String id= tbl_Menu.getValueAt(tbl_Menu.getSelectedRow(),0).toString();
        return masterI.getIMenu().ObtenerOne(id);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_bg_frm;
    private javax.swing.JPanel panel_crud;
    private pkg_Formulario.Menu.subMenu.Menu.PanelDetalleMenu panel_detalle_menu;
    private javax.swing.JPanel panel_table;
    private javax.swing.JPanel panel_title;
    private javax.swing.JTable tbl_Menu;
    // End of variables declaration//GEN-END:variables
}
