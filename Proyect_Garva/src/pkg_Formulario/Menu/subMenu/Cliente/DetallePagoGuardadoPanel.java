
package pkg_Formulario.Menu.subMenu.Cliente;

import pkg_Modelo.Entidades.Pago_Guardado;

public class DetallePagoGuardadoPanel extends javax.swing.JPanel {

    public DetallePagoGuardadoPanel() {
        initComponents();
    }

    private Pago_Guardado pago_guardado;
    private boolean Editable;

    public Pago_Guardado getPago_guardado() {
        return pago_guardado;
    }

    public void setPago_guardado(Pago_Guardado pago_guardado) {
        this.pago_guardado = pago_guardado;
    }

    public boolean isEditable() {
        return Editable;
    }

    public void setEditable(boolean Editable) {
        this.Editable = Editable;
        cm_Cliente.setEditable(Editable);
        txt_Monto.setEditable(Editable);
    }
 public void DataLoad()
 {
     if(pago_guardado!=null)
     {
        cm_Cliente.setSelectedItem(pago_guardado.getId_cliente());
        txt_Monto.setText(String.valueOf(pago_guardado.getMonto()));
     }else
     {
         cm_Cliente.setSelectedItem("");
        txt_Monto.setText("");
     }
     cm_Cliente.requestFocus();
 }
   public void DataSave()
   {
       if(pago_guardado==null)
       {
           pago_guardado=new Pago_Guardado();
       }
        pago_guardado.setId_cliente(Long.parseLong(cm_Cliente.getSelectedItem().toString()));
        pago_guardado.setMonto(Double.parseDouble(txt_Monto.getText()));
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Monto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cm_Cliente = new javax.swing.JComboBox<>();

        jLabel1.setText("Monto:");

        jLabel2.setText("Cliente:");

        jButton1.setText("Agregar");

        cm_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Monto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cm_Cliente, 0, 218, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(cm_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cm_Cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Monto;
    // End of variables declaration//GEN-END:variables
}
