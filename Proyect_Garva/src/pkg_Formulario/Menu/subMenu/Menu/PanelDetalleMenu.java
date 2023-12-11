package pkg_Formulario.Menu.subMenu.Menu;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import pkg_Modelo.Entidades.Menu;
import pkg_utilidades.Calculos;


public class PanelDetalleMenu extends javax.swing.JPanel {

private Menu menu;
private boolean editable;

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
        txt_Nombre.setEnabled(editable);
        txt_Detalle.setEnabled(editable);
        txt_Stock.setEnabled(editable);
        txt_Precio.setEnabled(editable);
        btn_cargar_image.setEnabled(editable);
        if(editable)txt_Nombre.requestFocus();
    }
    
    public void DataLoad(){
            if(menu!=null){
            txt_Cod.setText(menu.getId());
            txt_Nombre.setText(menu.getNombre());
            txt_Detalle.setText(menu.getDetalle());
            txt_Stock.setText(String.valueOf(menu.getStock()));
            txt_Precio.setText(String.valueOf(menu.getPrecio()));
            lblFechaMenu.setText("Fecha Menu: "+menu.getFecha().toString());
           calculo.SetImageLabel(lbl_Image, menu.getRuta());
           repaint();
            }
            else{
                txt_Cod.setText("-----------");
                txt_Nombre.setText("");
                txt_Detalle.setText("");
                txt_Stock.setText("");
                txt_Precio.setText("");
                lblFechaMenu.setText("");
                lbl_Image.setIcon(new ImageIcon());
                
            }
    }
    private String ruta;
    public void DataSave(){
    if(menu==null){
        menu = new Menu();
    }
    menu.setId(txt_Cod.getText());
    menu.setNombre(txt_Nombre.getText());
    menu.setDetalle(txt_Detalle.getText());
    menu.setStock(Integer.parseInt(txt_Stock.getText()));
    menu.setPrecio(Double.parseDouble(txt_Precio.getText()));
    if(ruta!=null)
    menu.setRuta(ruta);
    
    }



    public PanelDetalleMenu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_bg = new javax.swing.JPanel();
        panel_Cod = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Cod = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Image = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        btn_cargar_image = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Detalle = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txt_Stock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        lblFechaMenu = new javax.swing.JLabel();

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

        btn_cargar_image.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cargar_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Export/subir_Image.png"))); // NOI18N
        btn_cargar_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_imageActionPerformed(evt);
            }
        });

        txt_Detalle.setColumns(20);
        txt_Detalle.setRows(5);
        jScrollPane1.setViewportView(txt_Detalle);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Detalle:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Precio:");

        javax.swing.GroupLayout panel_bgLayout = new javax.swing.GroupLayout(panel_bg);
        panel_bg.setLayout(panel_bgLayout);
        panel_bgLayout.setHorizontalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_cargar_image, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_bgLayout.setVerticalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btn_cargar_image)))
                .addGap(6, 6, 6)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cargar_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_imageActionPerformed
        seleccionarImagen();
        
    }//GEN-LAST:event_btn_cargar_imageActionPerformed
private Calculos calculo=new Calculos();
     
   private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
          
                ruta=calculo.copiarImagen(archivoSeleccionado,"src/pkg_utilidades/images/icons/menu/");
            
            lbl_Image.setIcon(new ImageIcon(ruta));
            calculo.SetImageLabel(lbl_Image,ruta);
             this.repaint();
        }
       }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFechaMenu;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JPanel panel_Cod;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextArea txt_Detalle;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_Stock;
    // End of variables declaration//GEN-END:variables
}
