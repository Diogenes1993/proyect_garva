package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_Modelo.Entidades.Cliente;
import pkg_Modelo.Entidades.Empleado;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Pedido;
import pkg_utilidades.Calculos;


public class PanelDetallePedido extends javax.swing.JPanel {

private Menu menu;
private Pedido pedido;
private Cliente cliente;
private Empleado empleado;
private boolean editable;
private MenuComboModel model_combo;
private ClienteComboModel model_combo_cli;

    public ClienteComboModel getModel_combo_cli() {
        return model_combo_cli;
    }

    public void setModel_combo_cli(ClienteComboModel model_combo_cli) throws IException {
        this.model_combo_cli = model_combo_cli;
        cm_Cliente.setModel(model_combo_cli);
        model_combo_cli.updateCombo();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    public MenuComboModel getModel_combo() {
        return model_combo;
    }

    public void setModel_combo(MenuComboModel model_combo) throws IException {
        this.model_combo = model_combo;
       cm_Menu.setModel(model_combo);
        model_combo.updateCombo();
    }

    public String getCod() {
        return txt_Cod.getText();
    }

    public void setUser(String user) {
        this.txt_empleado.setText(user);
    }
    
     public String getUser() {
        return txt_empleado.getText();
    }
     private String cod;
     public void setCodUser(String user) {
        this.cod=user;
    }
    
     public String getCodUser() {
        return cod;
    }

    public void setCod(String Cod) {
        this.txt_Cod.setText(Cod);
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditableTotal(boolean editable) {
        this.editable = editable;
              
        // MENU
        txt_Cod.setEnabled(false);
        cm_Menu.setEnabled(editable);
        txt_empleado.setEnabled(false);
        
        //CLIENTE
        cm_Cliente.setEnabled(editable);
        btn_NuevoCli.setEnabled(editable);
    }
 public void setEditableAgregue(boolean editable) {
        this.editable = editable;
              
        // MENU
        txt_Cod.setEnabled(false);
        cm_Menu.setEnabled(!editable);
        txt_empleado.setEnabled(false);
        
        //CLIENTE
        cm_Cliente.setEnabled(editable);
        btn_NuevoCli.setEnabled(editable);
    }
    
    public void DataLoad(){
            if(menu!=null&& pedido!=null){
            txt_Cod.setText(pedido.getId());
            lblFechaPedido.setText(pedido.getFecha().toString());
            
            List<AdapterMenuView> menus= model_combo.getMenus();
            AdapterMenuView menuSeleccionado = getAdapterMenu(menu.getNombre(), menus);
            
             List<AdapterClienteView>clientes=model_combo_cli.getClientes() ;
             AdapterClienteView clienteSeleccionado = getAdapterCliente(cliente.getNombre(),clientes);
            if(clienteSeleccionado !=null)
            {
                cm_Cliente.setSelectedItem(clienteSeleccionado.getCliente().getNombre());
                lbl_Apellido.setText(clienteSeleccionado.getCliente().getApellido());
                lblTelefono.setText(clienteSeleccionado.getCliente().getTelefono());
                lblDistrito.setText(clienteSeleccionado.getCliente().getDistrito());
            }
            if (menuSeleccionado != null ) {
                cm_Menu.setSelectedItem(menuSeleccionado.getMenu().getNombre());
                lbl_Stock.setText(String.valueOf(menuSeleccionado.getMenu().getStock()));
                lbl_Precio.setText("S/. "+String.valueOf(menuSeleccionado.getMenu().getPrecio()));
                lblFechaPedido.setText("Fecha Menu: "+menuSeleccionado.getMenu().getFecha().toString());
                lbl_Image.setIcon(new ImageIcon(menuSeleccionado.getMenu().getRuta()));
                }
            }
            else{
                txt_Cod.setText("-----------");
                cm_Menu.setSelectedIndex(0);
                cm_Cliente.setSelectedIndex(0);
                lbl_Detalle.setText("--------");
                lbl_Stock.setText("-----");
                lbl_Precio.setText("S/. 0,00");
                lblFechaPedido.setText("");
                lbl_Image.setIcon(new ImageIcon());
                lbl_Apellido.setText("----------");
                lblTelefono.setText("----------");
                lblDistrito.setText("----------");
            }
    }
    private int canti;
    public void setCantidad(int cantidad){
    this.canti=cantidad;
    }
    
    public int getCantidad(){
    return canti;
    }
    public void DataLoadCli(){
        if(cliente!=null){
         List<AdapterClienteView>clientes=model_combo_cli.getClientes() ;
             AdapterClienteView clienteSeleccionado = getAdapterCliente(cliente.getNombre(),clientes);
            if(clienteSeleccionado !=null)
            {
                cm_Cliente.setSelectedItem(clienteSeleccionado);
                System.out.println(cm_Cliente.getSelectedItem()+"------------------------");
                lbl_Apellido.setText(clienteSeleccionado.getCliente().getApellido());
                lblTelefono.setText(clienteSeleccionado.getCliente().getTelefono());
                lblDistrito.setText(clienteSeleccionado.getCliente().getDistrito());
            }
        }
    }
    public void DataLoad2(){
            if(menu!=null){
        
            List<AdapterMenuView> menus= model_combo.getMenus();
            AdapterMenuView menuSeleccionado = getAdapterMenu(menu.getNombre(), menus);
            
            if (menuSeleccionado != null ) {
                cm_Menu.setSelectedItem(menuSeleccionado);
                lbl_Stock.setText(String.valueOf(menuSeleccionado.getMenu().getStock()));
                lbl_Precio.setText("S/. "+String.valueOf(menuSeleccionado.getMenu().getPrecio()));
                txtPrecio.setText("S/. "+String.valueOf(menuSeleccionado.getMenu().getPrecio()));
                lblFechaPedido.setText("Fecha Menu: "+menuSeleccionado.getMenu().getFecha().toString());
                sp_Cantidad.setValue(canti);
                calculo.SetImageLabel(lbl_Image, menuSeleccionado.getMenu().getRuta());
                }
            
            
            }
            else{
                txt_Cod.setText("-----------");
                cm_Menu.setSelectedIndex(0);
                cm_Cliente.setSelectedIndex(0);
                lbl_Detalle.setText("--------");
                lbl_Stock.setText("-----");
                lbl_Precio.setText("S/. 0,00");
                lblFechaPedido.setText("");
                lbl_Image.setIcon(new ImageIcon());
                lbl_Apellido.setText("----------");
                lblTelefono.setText("----------");
                lblDistrito.setText("----------");
                lblFechaMenu.setText("--/--/--");
            }
    }
    
    private String ruta;
    
      private AdapterMenuView getAdapterMenu(String menuId, List<AdapterMenuView> menu) {
      for (AdapterMenuView menuView : menu) {
        if (menuView.getMenu().getNombre().equals(menuId)) {
            return menuView;
        }
    }
    return null;
}
         private AdapterClienteView getAdapterCliente(String clienteId, List<AdapterClienteView> cliente) {
    for (AdapterClienteView clienteView : cliente) {
        if (clienteView.getCliente().getNombre().equals(clienteId)) {
            return clienteView;
        }
    }
    return null;
}

 
         
    public void DataSave(){
    if(menu==null || cliente == null || pedido==null || empleado == null ){
        menu = new Menu();
        cliente = new Cliente();
        pedido= new Pedido();
        empleado = new Empleado();

    }
        
    AdapterMenuView menu_selecionado=(AdapterMenuView) cm_Menu.getSelectedItem();
    Menu menu_select=menu_selecionado.getMenu();
    
    menu.setId(menu_select.getId());
   
    
    canti=Integer.parseInt(sp_Cantidad.getValue().toString());
    menu.setStock(canti);
    AdapterClienteView cliente_selecionado=(AdapterClienteView) cm_Cliente.getSelectedItem();
    Cliente cliente_select=cliente_selecionado.getCliente();
    cliente.setId(cliente_select.getId());
    empleado.setId(cod);
    pedido.setId(txt_Cod.getText());
    pedido.setEstado("2");

    }
    
    



    public PanelDetallePedido() {

        initComponents();
         model_combo=new MenuComboModel(null);
         model_combo_cli = new ClienteComboModel(null);
          
    }
    
    public PanelDetallePedido(IMenu Imenu,ICliente Icliente) {
        initComponents();
        model_combo=new MenuComboModel(Imenu);
       model_combo_cli = new ClienteComboModel(Icliente);
       cm_Cliente.setModel(model_combo_cli);
       cm_Menu.setModel(model_combo);
         
   
        
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_bg = new javax.swing.JPanel();
        panel_Cod = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Cod = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panel_Cod1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_empleado = new javax.swing.JTextField();
        lblFechaPedido = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_NuevoCli = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cm_Cliente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbl_Apellido = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDistrito = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_Image = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Stock = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_Precio = new javax.swing.JLabel();
        lblFechaMenu = new javax.swing.JLabel();
        lbl_Detalle = new javax.swing.JLabel();
        cm_Menu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sp_Cantidad = new javax.swing.JSpinner();
        txtPrecio = new javax.swing.JTextField();

        panel_Cod.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        javax.swing.GroupLayout panel_CodLayout = new javax.swing.GroupLayout(panel_Cod);
        panel_Cod.setLayout(panel_CodLayout);
        panel_CodLayout.setHorizontalGroup(
            panel_CodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Cod, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_CodLayout.setVerticalGroup(
            panel_CodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_CodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Cod1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENDEDOR:");

        txt_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Cod1Layout = new javax.swing.GroupLayout(panel_Cod1);
        panel_Cod1.setLayout(panel_Cod1Layout);
        panel_Cod1Layout.setHorizontalGroup(
            panel_Cod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Cod1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_Cod1Layout.setVerticalGroup(
            panel_Cod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Cod1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Cod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        btn_NuevoCli.setText("Nuevo");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Cliente:");

        cm_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_ClienteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("Apellido:");

        jLabel10.setText("Distrito:");

        jLabel11.setText("Telefono:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_NuevoCli))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(30, 30, 30)
                        .addComponent(lblDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_NuevoCli)
                    .addComponent(jLabel7)
                    .addComponent(cm_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(lblDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbl_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, null, null));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Precio:");

        lbl_Detalle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Detalle.setText("Fecha Menu:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lbl_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lbl_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cm_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_MenuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Nombre Menu:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(sp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cm_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(sp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_bgLayout = new javax.swing.GroupLayout(panel_bg);
        panel_bg.setLayout(panel_bgLayout);
        panel_bgLayout.setHorizontalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(314, 314, 314)
                        .addComponent(panel_Cod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_bgLayout.setVerticalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_Cod1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empleadoActionPerformed

    private void cm_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_ClienteActionPerformed
     AdapterClienteView cliente_selecionado=(AdapterClienteView) cm_Cliente.getSelectedItem();
    Cliente cliente_select=cliente_selecionado.getCliente();
    
    lbl_Apellido.setText(cliente_select.getApellido());
    lblDistrito.setText(cliente_select.getDistrito());
    lblTelefono.setText(cliente_select.getTelefono());
    
    
    }//GEN-LAST:event_cm_ClienteActionPerformed
private int select;

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }
    private void cm_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_MenuActionPerformed

     
        AdapterMenuView menu_selecionado=(AdapterMenuView) cm_Menu.getSelectedItem();
        Menu menu_select=menu_selecionado.getMenu();
        txtPrecio.setText("S/ "+String.valueOf(menu_select.getPrecio()));
        lbl_Stock.setText(String.valueOf(menu_select.getStock()));
        lbl_Precio.setText("S/ "+String.valueOf(menu_select.getPrecio()));
        lblFechaMenu.setText(menu_select.getFecha().toString());
        lbl_Image.setSize(148,132);
        calculo.SetImageLabel(lbl_Image, menu_select.getRuta());
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
        modeloSpinner.setMaximum(menu_select.getStock()+select);
        modeloSpinner.setMinimum(1);
        modeloSpinner.setValue(1);
        sp_Cantidad.setModel(modeloSpinner);

    }//GEN-LAST:event_cm_MenuActionPerformed
private Calculos calculo=new Calculos();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NuevoCli;
    private javax.swing.JComboBox<AdapterClienteView> cm_Cliente;
    private javax.swing.JComboBox<AdapterMenuView> cm_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblFechaMenu;
    private javax.swing.JLabel lblFechaPedido;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lbl_Apellido;
    private javax.swing.JLabel lbl_Detalle;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_Precio;
    private javax.swing.JLabel lbl_Stock;
    private javax.swing.JPanel panel_Cod;
    private javax.swing.JPanel panel_Cod1;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JSpinner sp_Cantidad;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextField txt_empleado;
    // End of variables declaration//GEN-END:variables
}
