package pkg_Formulario.Menu.subMenu.Empleado;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import pkg_Formulario.Menu.subMenu.ClassUtil.AdapterDistritoView;
import pkg_Formulario.Menu.subMenu.ClassUtil.AdapterRolView;
import pkg_Formulario.Menu.subMenu.ClassUtil.DistritoComboModel;
import pkg_Formulario.Menu.subMenu.ClassUtil.RolComboModel;
import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Distrito;
import pkg_Modelo.Entidades.Empleado;
import pkg_Modelo.Entidades.Rol;


public class EmpleadoDataPanel extends javax.swing.JPanel {

    
    private Empleado empleado;
    private boolean editable;
    private DistritoComboModel combo_distrito;
    private RolComboModel combo_rol;

    public DistritoComboModel getCombo_distrito() {
        return combo_distrito;
    }

    public void setCombo_distrito(DistritoComboModel combo_distrito) throws IException {
        this.combo_distrito = combo_distrito;
        cm_Distrito.setModel(combo_distrito);
        combo_distrito.updateCombo();
    }
    
       public RolComboModel getCombo_rol() {
        return combo_rol;
    }

    public void setCombo_rol(RolComboModel combo_rol) throws IException {
        this.combo_rol = combo_rol;
        cm_Cargo.setModel(combo_rol);
        combo_rol.updateCombo();
    }
    

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        txt_Cod.setEnabled(false);
        txt_Nombre.setEnabled(editable);
        txt_Apellido.setEnabled(editable);
        txt_Telefono.setEnabled(editable);
        cm_Distrito.setEnabled(editable);
        txt_Direccion.setEnabled(editable);
        dtp_fecha_Ingreso.setEnabled(editable);
        txt_Email.setEnabled(editable);
        txt_Usuario.setEnabled(editable);
        txt_Contra.setEnabled(editable);
        txt_isEstado.setEnabled(false);
        cm_Cargo.setEnabled(editable);
         if(editable)txt_Nombre.requestFocus();
    }
 
    public void DataLoad()
 {
     if(empleado!=null)
     {
        txt_Cod.setText(empleado.getId());
        txt_Nombre.setText(empleado.getNombre());
        txt_Apellido.setText(empleado.getApellido());
        
        
        List<AdapterDistritoView> distritos = combo_distrito.getDistritos();
        AdapterDistritoView distritoSeleccionado = getAdapterDistrito(empleado.getDistrito(), distritos);
 
        
         
        txt_Direccion.setText(empleado.getDireccion());
        txt_Telefono.setText(empleado.getTelefono());
        txt_Email.setText(empleado.getEmail());
        dtp_fecha_Ingreso.setDate(LocalDate.parse(empleado.getFecha_contrato().toString()));
        txt_Usuario.setText(empleado.getUsuario());
        txt_Contra.setText(empleado.getContra());
        ch_estado.setSelected("ACTIVO".equals(empleado.getEstado()));
        txt_isEstado.setText(empleado.getEstado());
        
                 List<AdapterRolView> roles = combo_rol.getRoles();
                AdapterRolView rolSeleccionado = getAdapterRol(empleado.getRol().getRol(), roles);

            if (rolSeleccionado != null || distritoSeleccionado != null) {
                cm_Cargo.setSelectedItem(rolSeleccionado);
                cm_Distrito.setSelectedItem(distritoSeleccionado);
                }
     }else
     {
        txt_Cod.setText("---------------");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Direccion.setText("");
        txt_Telefono.setText("");
        txt_Email.setText("");
        cm_Cargo.setSelectedIndex(0);
        cm_Distrito.setSelectedIndex(0);
        dtp_fecha_Ingreso.setDate(LocalDate.now());
        txt_Usuario.setText("-----------");        
        txt_Contra.setText("-----------");        
        ch_estado.setSelected(true);
        txt_isEstado.setText("ACTIVO");
     }
 }
    
       private AdapterDistritoView getAdapterDistrito(String distritoId, List<AdapterDistritoView> distritos) {
    for (AdapterDistritoView distritoView : distritos) {
        if (distritoView.getDistrito().getNombre().equals(distritoId)) {
            return distritoView;
        }
    }
    return null;
}
    
       private AdapterRolView getAdapterRol(String rol_nombre, List<AdapterRolView> roles) {
    for (AdapterRolView rolView : roles) {
        if (rolView.getRol().getRol().equals(rol_nombre)) {
            return rolView;
        }
    }
    return null;
}
       
       
    public String getCod() {
        return txt_Cod.getText();
    }

    public void setCod(String newcod) {
        this.txt_Cod.setText(newcod);
    }
    
       public void DataSave()
   {
       if(empleado==null)
       {
           empleado=new Empleado();
       }
        empleado.setId(txt_Cod.getText().trim());
        empleado.setNombre(txt_Nombre.getText().trim());
        empleado.setApellido(txt_Apellido.getText().trim());
        
        
        AdapterDistritoView distrito_selecionado=(AdapterDistritoView) cm_Distrito.getSelectedItem();
        
        Distrito distrito_select=distrito_selecionado.getDistrito();
        
        empleado.setDistrito(distrito_select.getId());
        
        empleado.setDireccion(txt_Direccion.getText());
        empleado.setTelefono(txt_Telefono.getText());
        empleado.setEmail(txt_Email.getText());
        empleado.setFecha_contrato(Date.valueOf(dtp_fecha_Ingreso.getDate()));
        empleado.setUsuario(txt_Usuario.getText());
        empleado.setContra(txt_Contra.getText());
        empleado.setEstado(ch_estado.isSelected()?"0":"1");
        
        AdapterRolView rol_seleccionado=(AdapterRolView)cm_Cargo.getSelectedItem();
        Rol rol_select=rol_seleccionado.getRol();
        empleado.setRol(rol_select);
   }
  
    
    
    
    public EmpleadoDataPanel() {
        initComponents();
        combo_distrito=new DistritoComboModel(null);
        combo_rol=new RolComboModel(null);
        }
    public EmpleadoDataPanel(IDistrito Idistrito) {
        initComponents();
        combo_distrito=new DistritoComboModel(Idistrito);
        cm_Cargo.setModel(combo_rol);
        }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_Cod = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_Usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Contra = new javax.swing.JTextField();
        dtp_fecha_Ingreso = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cm_Distrito = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cm_Cargo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ch_estado = new javax.swing.JCheckBox();
        txt_isEstado = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(487, 139));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Fecha Ingreso:");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Codigo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Usuario:");

        jLabel7.setText("Contaseñia:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Contra, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel8.setText("Télefono:");

        jLabel9.setText("Distrito:");

        jLabel10.setText("Email:");

        jLabel11.setText("Cargo:");

        jLabel12.setText("Estado:");

        ch_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_estadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cm_Distrito, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtp_fecha_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cm_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ch_estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_isEstado))
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cm_Distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cm_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11))
                            .addComponent(txt_isEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ch_estado)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtp_fecha_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ch_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_estadoActionPerformed
        if(ch_estado.isSelected())txt_isEstado.setText("ACTIVO");
        else txt_isEstado.setText("INACTIVO");
    }//GEN-LAST:event_ch_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch_estado;
    private javax.swing.JComboBox<AdapterRolView> cm_Cargo;
    private javax.swing.JComboBox<AdapterDistritoView> cm_Distrito;
    private com.github.lgooddatepicker.components.DatePicker dtp_fecha_Ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Cod;
    private javax.swing.JTextField txt_Contra;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_Usuario;
    private javax.swing.JTextField txt_isEstado;
    // End of variables declaration//GEN-END:variables
}
