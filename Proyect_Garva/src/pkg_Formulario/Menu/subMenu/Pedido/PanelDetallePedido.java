package pkg_Formulario.Menu.subMenu.Pedido;

import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_Modelo.Entidades.Detalle_Pedido;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Pedido;
import pkg_utilidades.Calculos;


public class PanelDetallePedido extends javax.swing.JPanel {

private Menu menu;
private Pedido pedido;
private Detalle_Pedido detalle_pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Detalle_Pedido getDetalle_pedido() {
        return detalle_pedido;
    }

    public void setDetalle_pedido(Detalle_Pedido detalle_pedido) {
        this.detalle_pedido = detalle_pedido;
    }
private boolean editable;
private MenuComboModel model_combo;

    public MenuComboModel getModel_combo() {
        return model_combo;
    }

    public void setModel_combo(MenuComboModel model_combo) {
        this.model_combo = model_combo;
    }

    public String getCod() {
        return txt_Cod.getText();
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

    public void setEditable(boolean editable) {
        this.editable = editable;
        txt_Cod.setEnabled(false);
        cm_Menu.setEnabled(editable);
        txt_Detalle.setEnabled(editable);
        lbl_Stock.setEnabled(editable);
        lbl_Precio.setEnabled(editable);
        if(editable)cm_Menu.requestFocus();
    }
    
    public void DataLoad(){
            if(menu!=null&& pedido!=null){
            txt_Cod.setText(pedido.getId());
            lblFechaPedido.setText(pedido.getFecha().toString());
            
            List<AdapterMenuView> menus= model_combo.getMenus();
            AdapterMenuView menuSeleccionado = getAdapterMenu(menu.getNombre(), menus);
            
            
            if (menuSeleccionado != null ) {
                cm_Menu.setSelectedItem(menuSeleccionado.getMenu().getNombre());
                lbl_Stock.setText(String.valueOf(menuSeleccionado.getMenu().getStock()));
                lbl_Precio.setText(String.valueOf((char) menuSeleccionado.getMenu().getPrecio()));
                lblFechaPedido.setText("Fecha Menu: "+menuSeleccionado.getMenu().getFecha().toString());
                lbl_Image.setIcon(new ImageIcon(menuSeleccionado.getMenu().getRuta()));
                ch_Estado.setSelected("PROCESO".equals(pedido.getEstado()));
                ch_Estado.setText(pedido.getEstado());
                }
            
            }
            else{
                txt_Cod.setText("-----------");
                cm_Menu.setSelectedIndex(0);
                txt_Detalle.setText("");
                lbl_Stock.setText("");
                lbl_Precio.setText("");
                lblFechaPedido.setText("");
                lbl_Image.setIcon(new ImageIcon());
                ch_Estado.setSelected(true);
                ch_Estado.setText("PROCESO");
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
    
    
    public void DataSave(){
    if(menu==null){
        menu = new Menu();
    }
    menu.setId(txt_Cod.getText());
    
    AdapterMenuView menu_selecionado=(AdapterMenuView) cm_Menu.getSelectedItem();
    Menu menu_select=menu_selecionado.getMenu();
    menu.setNombre(menu_select.getId());
        
    menu.setDetalle(txt_Detalle.getText());
    menu.setStock(Integer.parseInt(lbl_Stock.getText()));
    menu.setPrecio(Double.parseDouble(lbl_Precio.getText()));
    pedido.setEstado(ch_Estado.isSelected()?"2":"3");
    if(ruta!=null)
    menu.setRuta(ruta);
    
    }



    public PanelDetallePedido() {
        initComponents();
         model_combo=new MenuComboModel(null);
    }
    
    public PanelDetallePedido(IMenu Imenu) {
        initComponents();
        model_combo=new MenuComboModel(Imenu);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFechaPedido = new javax.swing.JLabel();
        cm_Menu = new javax.swing.JComboBox<>();
        txt_Detalle = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbl_Image = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Stock = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_Precio = new javax.swing.JLabel();
        lblFechaMenu = new javax.swing.JLabel();
        ch_Estado = new javax.swing.JCheckBox();

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
                .addComponent(txt_Cod, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
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

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Nombre Menu:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, null, null));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Precio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_Stock, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblFechaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblFechaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ch_Estado.setText("PROCESO");

        javax.swing.GroupLayout panel_bgLayout = new javax.swing.GroupLayout(panel_bg);
        panel_bg.setLayout(panel_bgLayout);
        panel_bgLayout.setHorizontalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(lblFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(txt_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(cm_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addComponent(ch_Estado)
                        .addGap(263, 263, 263)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)))
        );
        panel_bgLayout.setVerticalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cm_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_bgLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txt_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_bgLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4))
                            .addGroup(panel_bgLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ch_Estado)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 902, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
private Calculos calculo=new Calculos();
     
   public void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            ruta=calculo.copiarImagen(archivoSeleccionado,"src/pkg_utilidades/images/icons/menu/");
            lbl_Image.setIcon(new ImageIcon(ruta));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch_Estado;
    private javax.swing.JComboBox<AdapterMenuView> cm_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFechaMenu;
    private javax.swing.JLabel lblFechaPedido;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_Precio;
    private javax.swing.JLabel lbl_Stock;
    private javax.swing.JPanel panel_Cod;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextField txt_Detalle;
    // End of variables declaration//GEN-END:variables
}
