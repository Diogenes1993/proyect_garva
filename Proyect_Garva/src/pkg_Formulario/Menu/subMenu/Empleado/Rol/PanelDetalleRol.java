package pkg_Formulario.Menu.subMenu.Empleado.Rol;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import pkg_Modelo.Entidades.Rol;
import pkg_utilidades.Calculos;


public class PanelDetalleRol extends javax.swing.JPanel {

private Rol rol;
private boolean editable;

    public String getCod() {
        return txt_Cod.getText();
    }

    public void setCod(String Cod) {
        this.txt_Cod.setText(Cod);
    }


    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        txt_Cod.setEnabled(false);
        txt_Nombre.setEnabled(editable);
        btn_cargar_image.setEnabled(editable);
        if(editable)txt_Nombre.requestFocus();
    }
    
    public void DataLoad(){
            if(rol!=null){
            txt_Cod.setText(rol.getId());
            txt_Nombre.setText(rol.getRol());
            lbl_Image.setIcon(new ImageIcon(rol.getRuta()));
            }
            else{
                txt_Cod.setText("-----------");
                txt_Nombre.setText("");
                lbl_Image.setIcon(new ImageIcon());
            }
    }
    private String ruta;
    public void DataSave(){
    if(rol==null){
        rol = new Rol();
    }
    rol.setId(txt_Cod.getText());
    rol.setRol(txt_Nombre.getText());
    if(ruta!=null)
    rol.setRuta(ruta);
    
    }



    public PanelDetalleRol() {
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
        jLabel3.setText("Nombre Cargo:");

        btn_cargar_image.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cargar_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Export/subir_Image.png"))); // NOI18N
        btn_cargar_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_imageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_bgLayout = new javax.swing.GroupLayout(panel_bg);
        panel_bg.setLayout(panel_bgLayout);
        panel_bgLayout.setHorizontalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btn_cargar_image, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel_bgLayout.setVerticalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(panel_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_cargar_image))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     
   public void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            ruta=calculo.copiarImagen(archivoSeleccionado,"src\\pkg_utilidades\\images\\icons\\");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JPanel panel_Cod;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables
}
