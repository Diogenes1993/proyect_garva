package pkg_Formulario;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import javax.swing.UIManager;

public final class frm_Login extends javax.swing.JFrame {
ImagenFrm fondo=new ImagenFrm();
    public frm_Login() {
      FlatGitHubIJTheme.setup();
      initComponents();
      UIManager.put("Button.arc", 12);
      UIManager.put( "Component.focusWidth" , 0 );
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonsito = new javax.swing.JButton();
        txp_contrasenia = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 237, 222));

        panelRound1.setBackground(new java.awt.Color(128, 116, 107));
        panelRound1.setRound_top_left(400);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario");
        panelRound1.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 102, 27));

        lbl_contra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_contra.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contra.setText("Contraseña");
        panelRound1.add(lbl_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 132, 27));

        lbl_recu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_recu.setForeground(new java.awt.Color(255, 153, 0));
        lbl_recu.setText("¿Olvidaste tu Contraseña?");
        panelRound1.add(lbl_recu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 416, -1, 36));

        txt_Usuario.setBorder(null);
        panelRound1.add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 150, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 376, 150, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 150, 10));
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/seguridad-web.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, -1));

        botonsito.setBackground(new java.awt.Color(102, 102, 255));
        botonsito.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        botonsito.setForeground(new java.awt.Color(0, 0, 255));
        botonsito.setText("Iniciar Sesión");
        panelRound1.add(botonsito, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 482, 189, -1));
        panelRound1.add(txp_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 347, 150, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/GarvaMarron (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonsito;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_contra;
    private javax.swing.JLabel lbl_recu;
    private javax.swing.JLabel lbl_usuario;
    private pkg_Formulario.utilidades.PanelRound panelRound1;
    private javax.swing.JPasswordField txp_contrasenia;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables
}
