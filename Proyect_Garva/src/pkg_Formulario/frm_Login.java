
package pkg_Formulario;


public class frm_Login extends javax.swing.JFrame {

    public frm_Login() {
        initComponents();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new pkg_Formulario_utilidades.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRound1 = new pkg_Formulario_utilidades.ButtonRound();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 237, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(128, 116, 107));
        panelRound1.setRound_top_left(400);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 102, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 132, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("¿Olvidaste tu Contraseña?");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 187, 36));

        buttonRound1.setBackground(new java.awt.Color(204, 204, 204));
        buttonRound1.setForeground(new java.awt.Color(51, 51, 255));
        buttonRound1.setBorder_color(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor_click(new java.awt.Color(204, 204, 204));
        buttonRound1.setColor_hover(new java.awt.Color(204, 204, 204));
        buttonRound1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        buttonRound1.setLabel("Iniciar Sesión");
        buttonRound1.setRadius(15);
        panelRound1.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 190, 30));

        jTextField1.setBorder(null);
        panelRound1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 150, 150, 30));

        jTextField2.setBorder(null);
        panelRound1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 150, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 300, 150, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 180, 150, 10));
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 40, 40));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 340, 530));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/GarvaMarron (3).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 340, 300));

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
    private pkg_Formulario_utilidades.ButtonRound buttonRound1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private pkg_Formulario_utilidades.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
