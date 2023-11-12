
package pkg_Formulario;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Color;


public class frm_Login extends javax.swing.JFrame {

    public frm_Login() {
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new pkg_Formulario.utilidades.PanelRound();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contra = new javax.swing.JLabel();
        lbl_recu = new javax.swing.JLabel();
        buttonRound1 = new pkg_Formulario.utilidades.ButtonRound();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 237, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(128, 116, 107));
        panelRound1.setRound_top_left(400);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario");
        panelRound1.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 102, 27));

        lbl_contra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_contra.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contra.setText("Contraseña");
        panelRound1.add(lbl_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 132, 27));

        lbl_recu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_recu.setForeground(new java.awt.Color(255, 153, 0));
        lbl_recu.setText("¿Olvidaste tu Contraseña?");
        panelRound1.add(lbl_recu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 187, 36));

        buttonRound1.setBackground(new java.awt.Color(204, 204, 204));
        buttonRound1.setForeground(new java.awt.Color(51, 51, 255));
        buttonRound1.setBorder_color(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor_click(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor_hover(new java.awt.Color(204, 204, 204));
        buttonRound1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        buttonRound1.setLabel("Iniciar Sesión");
        buttonRound1.setRadius(15);
        panelRound1.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 190, 30));

        jTextField1.setBorder(null);
        panelRound1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, 30));

        jTextField2.setBorder(null);
        panelRound1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 150, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 150, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 150, 10));
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/seguridad-web.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 200));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 340, 530));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/GarvaMarron (3).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 340, 300));

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
           FlatMaterialLighterIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pkg_Formulario.utilidades.ButtonRound buttonRound1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_contra;
    private javax.swing.JLabel lbl_recu;
    private javax.swing.JLabel lbl_usuario;
    private pkg_Formulario.utilidades.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
