package pkg_Formulario.Menu.subMenu.Cliente;

import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Cliente;
import pkg_Modelo.Entidades.Distrito;

public class DetalleClientePanel extends javax.swing.JPanel {

    private Cliente cliente;
    private boolean Editable;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditable() {
        return Editable;
    }

    public void setEditable(boolean Editable) {
        this.Editable = Editable;
        txt_Nombre.setEnabled(Editable);
        txt_Apellido.setEnabled(Editable);
        cm_Distrito.setEnabled(Editable);
        txt_Telefono.setEnabled(Editable);
        txt_Correo.setEnabled(Editable);
        txt_Cod.setEnabled(false);
        if(Editable)txt_Nombre.requestFocus();
    }
    public void setCod(String cod){
    txt_Cod.setText(cod);
    }
    
    public String getCod(){
    return txt_Cod.getText();
    }
 public void DataLoad()
 {
     if(cliente!=null)
     {
        txt_Cod.setText(cliente.getId());
        txt_Nombre.setText(cliente.getNombre());
        txt_Apellido.setText(cliente.getApellido());
        cm_Distrito.setSelectedItem(cliente.getDistrito());
        txt_Telefono.setText(cliente.getTelefono());
        txt_Correo.setText(cliente.getCorreo());
     }else
     {
        
        txt_Cod.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        cm_Distrito.setSelectedItem("Selecciona Distritos");
        txt_Telefono.setText("");
        txt_Correo.setText("");
        
     }
    
 }
   public void DataSave()
   {
       if(cliente==null)
       {
           cliente=new Cliente();
       }
        cliente.setId(txt_Cod.getText().trim());
        cliente.setNombre(txt_Nombre.getText().trim());
        cliente.setApellido(txt_Apellido.getText().trim());
        
        AdapterDistritoView distrito_selecionado=(AdapterDistritoView)cm_Distrito.getSelectedItem();
        Distrito distrito_select=distrito_selecionado.getDistrito();
        cliente.setDistrito(distrito_select.getId());
        cliente.setTelefono(txt_Telefono.getText());
        cliente.setCorreo(txt_Correo.getText());
   }
    
    private DistritoComboModel model_combo_distrito;
    public DetalleClientePanel() {
        initComponents();
        model_combo_distrito=new DistritoComboModel(null);
    }
    
    public DetalleClientePanel(IDistrito Idistrito) {
        initComponents();
        model_combo_distrito=new DistritoComboModel(Idistrito);
        cm_Distrito.setModel(model_combo_distrito);
    }

    public DistritoComboModel getModel_combo_distrito() {
        return model_combo_distrito;
    }

    public void setModel_combo_distrito(DistritoComboModel model_combo_distrito) throws IException {
        this.model_combo_distrito = model_combo_distrito;
         cm_Distrito.setModel(model_combo_distrito);
         model_combo_distrito.updateCombo();
    }
     
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        cm_Distrito = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_Cod = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Distrito:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Codido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(6, 6, 6))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txt_Cod, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addGap(607, 607, 607))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cm_Distrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Apellido)
                            .addComponent(txt_Correo))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Telefono)))
                .addGap(10, 10, 10))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(txt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cm_Distrito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<AdapterDistritoView> cm_Distrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
