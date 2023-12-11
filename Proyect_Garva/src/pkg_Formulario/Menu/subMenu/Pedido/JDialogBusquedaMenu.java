
package pkg_Formulario.Menu.subMenu.Pedido;

import javax.swing.JTextField;
import pkg_Formulario.Menu.subMenu.Menu.MenuTableModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_utilidades.Utilidades;

public class JDialogBusquedaMenu extends javax.swing.JDialog {

     private final IMaster masterI;
  private MenuTableModel model_table;
    private boolean enviar;
    public JDialogBusquedaMenu( IMaster masterI) throws IException {
        super((javax.swing.JFrame)null, true);
        initComponents();
         setLocationRelativeTo(null);
          this.model_table = new MenuTableModel(masterI.getIMenu());
        tbl_Menu.setModel(model_table);
        ObtenerTodos();
        this.masterI = masterI;
        activarBotones(false);
          this.tbl_Menu.getSelectionModel().addListSelectionListener(e ->
        {
            activarBotones(tbl_Menu.getSelectedRow()!=-1);
        });
    }

 private void activarBotones(boolean active){
 btn_Enviar.setEnabled(active);
 }
     public boolean isEnviar() {
        return enviar;
    }

    public void setEnviar(boolean enviar) {
        this.enviar = enviar;
    }
    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
    
      private void ObtenerTodos() throws IException{
      model_table.getObtenerTodos();
      model_table.fireTableDataChanged();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Menu = new javax.swing.JTable();
        btn_Enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("CODIGO MENU");

        txt_Busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_BusquedaMouseClicked(evt);
            }
        });
        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyTyped(evt);
            }
        });

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

        btn_Enviar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_Enviar.setText("<< Enviar");
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_Enviar)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_Enviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BusquedaMouseClicked
        tbl_Menu.clearSelection();
    }//GEN-LAST:event_txt_BusquedaMouseClicked

    private void txt_BusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyPressed
        try {
            if(txt_Busqueda.getText().equals("")){
                activarBotones(false);
            }else{
                MenuTableModel tablita=new MenuTableModel(masterI.getIMenu());
                tablita.getObtenerIds(txt_Busqueda.getText());
                tbl_Menu.setModel(tablita);
                activarBotones(false);
            }
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR","No encontrado",0);
        }
    }//GEN-LAST:event_txt_BusquedaKeyPressed
private int cantidad;
    private void txt_BusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyTyped

        cantidad = 8;
        longitud(evt, txt_Busqueda);

    }//GEN-LAST:event_txt_BusquedaKeyTyped

      private void longitud(java.awt.event.KeyEvent evt,JTextField textbox){
        char c= evt.getKeyChar();
       
         String cantidad_de_caracteres = textbox.getText();
         if(cantidad_de_caracteres.length()>=cantidad && c!='\b'){
         evt.consume();
         }
    }
      
    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        enviar=true;
        setSelection(tbl_Menu.getValueAt(tbl_Menu.getSelectedRow(),0).toString());
        dispose();
    }//GEN-LAST:event_btn_EnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Menu;
    private javax.swing.JTextField txt_Busqueda;
    // End of variables declaration//GEN-END:variables
}
