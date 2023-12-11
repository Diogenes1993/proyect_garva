
package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.logging.Level;
import java.util.logging.Logger;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_Modelo.Entidades.Cliente;
import pkg_Modelo.Entidades.Detalle_Pedido;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Pedido;
import pkg_utilidades.Utilidades;

public class frmDetallePedido extends javax.swing.JPanel {

    private final IMaster masterI;
       
    private final PedidoTableModel pedido_model;

    public frmDetallePedido(IMaster masterI)  throws IException{
        initComponents();
        
        this.masterI=masterI;
        
        panel_Detalle_Pedido.setEditableTotal(false);
        panel_Detalle_Pedido.setCliente(null);
        panel_Detalle_Pedido.setPedido(null);
        panel_Detalle_Pedido.setMenu(null);
       panel_Detalle_Pedido.setModel_combo(new MenuComboModel(masterI.getIMenu()));
       panel_Detalle_Pedido.setModel_combo_cli(new ClienteComboModel(masterI.getICliente()));
       panel_Detalle_Pedido.setCod(masterI.getIPedido().NewCod());
        
       pedido_model = new PedidoTableModel(masterI.getIDetalle_pedido());
        tbl_Detalle.setModel(pedido_model);
        pedido_model.getObtenerTable(panel_Detalle_Pedido.getCod());
   //pedido_model.getObtenerTable("PE000017");
       formatTable();
       BtnBuscar(false);
       
    }
    
      private Menu getMenuSelection(String selectedMenu) throws IException{
        String id=selectedMenu ;
        return masterI.getIMenu().ObtenerOne(id);
    }
      
      private void BtnBuscar(boolean active){
      btn_Buscar.setEnabled(active);
      btn_Buscar_Men.setEnabled(active);
      }
    
    private void formatTable() throws IException
    {
        
        tbl_Detalle.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("icono"));
        tbl_Detalle.setRowHeight(24);
        
        tbl_Detalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_Detalle.getColumnModel().getColumn(1).setPreferredWidth(170);
        tbl_Detalle.getColumnModel().getColumn(2).setPreferredWidth(170);
        tbl_Detalle.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbl_Detalle.getColumnModel().getColumn(4).setPreferredWidth(90);
        tbl_Detalle.getColumnModel().getColumn(5).setPreferredWidth(2);
        tbl_Detalle.setModel(pedido_model);
        txt_total.setText(masterI.getIDetalle_pedido().ObtenerTotal(panel_Detalle_Pedido.getCod()));
        
    }
    
        private void ObtenerTodos() throws IException{
       
        pedido_model.getObtenerTable(panel_Detalle_Pedido.getCod());
        pedido_model.fireTableDataChanged();
         formatTable();
    }
    public void setCodEmpleado(String cod){
    panel_Detalle_Pedido.setCodUser(cod);
    }
    public void setNombreEmpleado(String user){
    panel_Detalle_Pedido.setUser(user);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Detalle = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btnRealizarVenta = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        btn_Buscar_Men = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        panel_Detalle_Pedido = new pkg_Formulario.Menu.subMenu.Pedido.PanelDetallePedido();

        tbl_Detalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Detalle);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextField1.setText("TOTAL:");

        txt_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnRealizarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/ir (1).png"))); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.setIconTextGap(20);

        jButton3.setText("Ver");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(391, 391, 391)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRealizarVenta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton3)
                        .addGap(33, 33, 33))))
        );

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/cocinar.png"))); // NOI18N
        btn_Agregar.setText("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Buscar.setText(">>");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        btn_Buscar_Men.setText(">>");
        btn_Buscar_Men.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_MenActionPerformed(evt);
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

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_Nuevo)
                        .addGap(3, 3, 3)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Cancelar)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btn_Buscar_Men, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_Detalle_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Nuevo)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btn_Cancelar)
                        .addGap(189, 189, 189)
                        .addComponent(btn_Buscar_Men))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btn_Buscar))
                    .addComponent(panel_Detalle_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
private int cantidad;
 private int fila ;
    private void tbl_DetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DetalleMouseClicked
  int columna = tbl_Detalle.getSelectedColumn();
      fila  = tbl_Detalle.getSelectedRow();
        if(columna==5){
            try {
                Pedido pedido=new Pedido();
                Menu menu=new Menu();
           
                pedido.setId(panel_Detalle_Pedido.getCod());
                menu.setId(tbl_Detalle.getValueAt(fila,1).toString());
              cantidad =Integer.parseInt(tbl_Detalle.getValueAt(fila,0).toString());
                Detalle_Pedido detalle=new Detalle_Pedido(pedido,menu,cantidad); 
                masterI.getIDetalle_pedido().Eliminar(detalle);
                menu.setStock(cantidad);
                masterI.getIMenu().SumarStock(menu);
                panel_Detalle_Pedido.setModel_combo(new MenuComboModel(masterI.getIMenu()));
                ObtenerTodos();
                if(tbl_Detalle.getRowCount()==0){
                    btn_Cancelar.setEnabled(true);
                }
                } catch (IException ex) {
                Logger.getLogger(frmDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(columna<5){
            if(tbl_Detalle.getSelectedRow()!=-1){
            try {
          
                panel_Detalle_Pedido.setMenu(getMenuSelection(tbl_Detalle.getValueAt( tbl_Detalle.getSelectedRow(),1).toString()));
               cantidad =Integer.parseInt(tbl_Detalle.getValueAt(fila,0).toString());
                panel_Detalle_Pedido.setCantidad(cantidad);
                panel_Detalle_Pedido.DataLoad2();
                panel_Detalle_Pedido.setEditableAgregue(false);
                panel_Detalle_Pedido.setSelect(cantidad);
                
            } catch (IException ex) {
                Logger.getLogger(frmDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_tbl_DetalleMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
             try{
             panel_Detalle_Pedido.DataSave();
             Menu menu=panel_Detalle_Pedido.getMenu();
               Menu menu_=panel_Detalle_Pedido.getMenu();
             Pedido pedido =panel_Detalle_Pedido.getPedido();
             String buscado=pedido.getId()+","+menu.getId();
             Detalle_Pedido detalle_existe=masterI.getIDetalle_pedido().ObtenerOne(buscado);
             Detalle_Pedido detalle = new Detalle_Pedido(pedido,menu,panel_Detalle_Pedido.getCantidad());
             if(detalle_existe!=null){
             masterI.getIDetalle_pedido().Actualizar(detalle);
             Menu men=new Menu();
             men.setId(tbl_Detalle.getValueAt(fila,1).toString());
             men.setStock(cantidad);
              masterI.getIMenu().SumarStock(men);
                masterI.getIMenu().RestarStock(menu);
             
             }else{
             masterI.getIDetalle_pedido().Insertar(detalle);    
             masterI.getIMenu().RestarStock(menu);
             }
             
            panel_Detalle_Pedido.setEditableAgregue(false);
            panel_Detalle_Pedido.setCliente(null);
            panel_Detalle_Pedido.setPedido(null);
            panel_Detalle_Pedido.setEmpleado(null);
            panel_Detalle_Pedido.setSelect(0);
             panel_Detalle_Pedido.setModel_combo(new MenuComboModel(masterI.getIMenu()));
            ObtenerTodos();
           if(tbl_Detalle.getRowCount()>0){
                btn_Cancelar.setEnabled(false);
            }
         }catch(IException ex){
               Utilidades.Mensaje("ERROR", "DETALLE PEDIDOQUE PASO".concat(ex.toString()), 0);
         }
    }//GEN-LAST:event_btn_AgregarActionPerformed
    
    public void setClienteBuscado(String clienteBuscado) throws IException
    {
         panel_Detalle_Pedido.setCliente(getClienteSelection(clienteBuscado));
         panel_Detalle_Pedido.DataLoadCli();
         
    }
      public void setMenuBuscado(String menuBuscado) throws IException
    {
         panel_Detalle_Pedido.setMenu(getMenuSelection(menuBuscado));
         panel_Detalle_Pedido.DataLoad2();
         
    }
    
       private Cliente getClienteSelection(String selectedCliente) throws IException{
        String id=selectedCliente ;
        return masterI.getICliente().ObtenerOne(id);
    }
    
    
    
    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        try {
            BusquedaCliente clientebusqueda=new BusquedaCliente(masterI);
            clientebusqueda.setVisible(true);
            if(clientebusqueda.isEnviar()){
            setClienteBuscado(clientebusqueda.getSelection());
            }
        } catch (IException ex) {
           Utilidades.Mensaje("ERROR","Mensaje "+ex.getMessage(),0);
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_Buscar_MenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_MenActionPerformed
 try {
            JDialogBusquedaMenu menubusqueda=new JDialogBusquedaMenu(masterI);
            menubusqueda.setVisible(true);
            if(menubusqueda.isEnviar()){
            setMenuBuscado(menubusqueda.getSelection());
            }
        } catch (IException ex) {
           Utilidades.Mensaje("ERROR","Mensaje "+ex.getMessage(),0);
        }
    }//GEN-LAST:event_btn_Buscar_MenActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
         try{
            panel_Detalle_Pedido.setEditableTotal(true);
            panel_Detalle_Pedido.setEmpleado(null);
            panel_Detalle_Pedido.setCliente(null);
            panel_Detalle_Pedido.setMenu(null);
            panel_Detalle_Pedido.setPedido(null);
             panel_Detalle_Pedido.setCod(masterI.getIPedido().NewCod());
             Pedido ped =masterI.getIPedido().ObtenerOne(masterI.getIPedido().NewCod());
             Pedido pedido=new Pedido();
             pedido.setId(masterI.getIPedido().NewCod());
             pedido.setEstado("2");
             if(ped==null){
             masterI.getIPedido().Insertar(pedido);
             }
             btn_Cancelar.setEnabled(true);
             btn_Nuevo.setEnabled(false);
             BtnBuscar(true);
        }catch(IException ex){
             Utilidades.Mensaje("ERROR", "INSERT PEDIDO INSERT".concat(ex.toString()), 0);
        }
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        try {
            
            
            btn_Cancelar.setEnabled(false);
            btn_Nuevo.setEnabled(true);
            panel_Detalle_Pedido.setEmpleado(null);
            panel_Detalle_Pedido.setCliente(null);
            panel_Detalle_Pedido.setMenu(null);
            panel_Detalle_Pedido.setPedido(null);
            panel_Detalle_Pedido.DataLoad();
            tbl_Detalle.clearSelection();
            panel_Detalle_Pedido.setEditableTotal(false);
            Pedido pedido=new Pedido();
            pedido.setId(masterI.getIPedido().Cod());
            masterI.getIPedido().Cod();
            masterI.getIPedido().Eliminar(pedido);
            BtnBuscar(false);
        
        } catch (IException ex) {
          Utilidades.Mensaje("ERROR","No se puedo Eliminar", 0);
        }
      
    }//GEN-LAST:event_btn_CancelarActionPerformed
 
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar_Men;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private pkg_Formulario.Menu.subMenu.Pedido.PanelDetallePedido panel_Detalle_Pedido;
    private javax.swing.JTable tbl_Detalle;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

}

