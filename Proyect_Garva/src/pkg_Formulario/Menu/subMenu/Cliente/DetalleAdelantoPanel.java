
package pkg_Formulario.Menu.subMenu.Cliente;

import pkg_Modelo.Entidades.Pago_Guardado;

public class DetalleAdelantoPanel extends javax.swing.JPanel {

    public DetalleAdelantoPanel() {
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
        txt_Monto.setEditable(Editable);
    }
 public void DataLoad()
 {
     if(pago_guardado!=null)
     {
        txt_Monto.setText(String.valueOf(pago_guardado.getMonto()));
     }else
     {
        txt_Monto.setText("");
     }
 }
   public void DataSave()
   {
       if(pago_guardado==null)
       {
           pago_guardado=new Pago_Guardado();
       }
        pago_guardado.setMonto(Double.parseDouble(txt_Monto.getText()));
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Monto = new javax.swing.JTextField();

        jLabel1.setText("Monto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Monto, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Monto;
    // End of variables declaration//GEN-END:variables
}
