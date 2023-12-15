 package pkg_Formulario;

import javax.swing.UIManager;
import pkg_Formulario.Menu.frm_Menu;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_Modelo.Entidades.Detalle_Usuario;
import pkg_Modelo.Entidades.Empleado;
import pkg_utilidades.Utilidades;

public  class frm_Login extends javax.swing.JFrame {
ImagenFrm fondo=new ImagenFrm();

    private IMaster masterI ;


    public frm_Login(IMaster masterI) {
        initComponents();
        setLocationRelativeTo(null);
        this.masterI=masterI;
        UIManager.put("Button.arc", 12);
        UIManager.put( "Component.focusWidth" , 0 );
        
    }
     
    private boolean aceptado;
     
    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new pkg_Formulario.utilidades.PanelRound();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contra = new javax.swing.JLabel();
        lbl_recu = new javax.swing.JLabel();
        txt_Usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_Salir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Iniciar_Session = new javax.swing.JButton();
        txp_contrasenia = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 237, 222));

        panelRound1.setBackground(new java.awt.Color(128, 116, 107));
        panelRound1.setRound_top_left(400);

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario");

        lbl_contra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_contra.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contra.setText("Contraseña");

        lbl_recu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_recu.setForeground(new java.awt.Color(255, 153, 0));
        lbl_recu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_recu.setText("¿Olvidaste tu Contraseña?");
        lbl_recu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_recuMouseClicked(evt);
            }
        });

        txt_Usuario.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        lbl_Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/Salir.png"))); // NOI18N
        lbl_Salir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_Salir.setIconTextGap(-10);
        lbl_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_SalirMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/seguridad-web.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        btn_Iniciar_Session.setBackground(new java.awt.Color(102, 102, 255));
        btn_Iniciar_Session.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btn_Iniciar_Session.setForeground(new java.awt.Color(0, 0, 255));
        btn_Iniciar_Session.setText("Iniciar Sesión");
        btn_Iniciar_Session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Iniciar_SessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(31, 31, 31))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(189, 189, 189))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lbl_recu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btn_Iniciar_Session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Usuario)
                    .addComponent(txp_contrasenia)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(lbl_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbl_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txp_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(lbl_recu)
                .addGap(18, 18, 18)
                .addComponent(btn_Iniciar_Session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/GarvaMarron (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(176, 176, 176)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void ValidarUser(String nomusuario,String pass)throws IException
    {
        if(!nomusuario.equals("")||!pass.equals(""))
        {
       Empleado empleado= masterI.getIEmpleado().getDataUsuario(nomusuario);
      
       
        frm_Menu menu=new frm_Menu(masterI);
        if(empleado!=null && empleado.getContra().equals(pass))
        {
            aceptado=true;
           menu.setVisible(true);
           menu.setDatos(empleado.getId(),empleado.getUsuario(),empleado.getEmail(),empleado.getNombre(),empleado.getApellido(),empleado.getRol().getRol(),empleado.getRol().getRuta());
        
           menu.InitContent();
                dispose();
             
        }
        else
        {
            aceptado=false;
            Utilidades.Mensaje("MENSAJE", "CONTRASEÑA O USUARIO INCORRECTO", 1);
        }
        }else
        {
          Utilidades.Mensaje("MENSAJE", "RELLENE CAMPOS", 1);
        }
    }
     
       
    private void btn_Iniciar_SessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Iniciar_SessionActionPerformed
    String nombreUsuario = txt_Usuario.getText();
    String contrasenia = new String(txp_contrasenia.getPassword());

    try {
        ValidarUser(nombreUsuario, contrasenia);
    } catch (IException ex) {
    }
    }//GEN-LAST:event_btn_Iniciar_SessionActionPerformed

    private void lbl_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SalirMouseClicked
     System.exit(0);
    }//GEN-LAST:event_lbl_SalirMouseClicked

    private void lbl_recuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_recuMouseClicked
      frmRenuevo_ nuevo_Contra=new frmRenuevo_(masterI);
      nuevo_Contra.setVisible(true);
      nuevo_Contra.setLocationRelativeTo(null);
      dispose();
    }//GEN-LAST:event_lbl_recuMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Iniciar_Session;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Salir;
    private javax.swing.JLabel lbl_contra;
    private javax.swing.JLabel lbl_recu;
    private javax.swing.JLabel lbl_usuario;
    private pkg_Formulario.utilidades.PanelRound panelRound1;
    private javax.swing.JPasswordField txp_contrasenia;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables
}
