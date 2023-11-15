
package pkg_Formulario.Menu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import pkg_Formulario.Menu.subMenu.Cliente.frmCliente;
import pkg_Formulario.Menu.subMenu.Principal.frmPrincipal;
import pkg_MYSQL.MYSQLMaster;

public class frm_Menu extends javax.swing.JFrame {

    public frm_Menu() {
        initComponents();
        this.setExtendedState(frm_Menu.MAXIMIZED_BOTH);
         
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Background = new javax.swing.JPanel();
        panel_Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Principal = new javax.swing.JButton();
        btn_Cliente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel_Titulo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panel_Background.setBackground(new java.awt.Color(255, 255, 255));

        panel_Menu.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/Logo_01.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);

        btn_Principal.setBackground(new java.awt.Color(142, 253, 213));
        btn_Principal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Principal.setForeground(new java.awt.Color(0, 102, 102));
        btn_Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/hogar.png"))); // NOI18N
        btn_Principal.setText("Principal");
        btn_Principal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Principal.setBorderPainted(false);
        btn_Principal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Principal.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Principal.setIconTextGap(20);
        btn_Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrincipalActionPerformed(evt);
            }
        });

        btn_Cliente.setBackground(new java.awt.Color(142, 253, 213));
        btn_Cliente.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Cliente.setForeground(new java.awt.Color(0, 102, 102));
        btn_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/cliente.png"))); // NOI18N
        btn_Cliente.setText("Cliente");
        btn_Cliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Cliente.setBorderPainted(false);
        btn_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Cliente.setIconTextGap(20);
        btn_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClienteActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(142, 253, 213));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/entrega-de-pedidos.png"))); // NOI18N
        jButton3.setText("Pedidos");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton3.setIconTextGap(20);

        javax.swing.GroupLayout panel_MenuLayout = new javax.swing.GroupLayout(panel_Menu);
        panel_Menu.setLayout(panel_MenuLayout);
        panel_MenuLayout.setHorizontalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_MenuLayout.setVerticalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(365, 365, 365))
        );

        panel_Titulo.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout panel_TituloLayout = new javax.swing.GroupLayout(panel_Titulo);
        panel_Titulo.setLayout(panel_TituloLayout);
        panel_TituloLayout.setHorizontalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_TituloLayout.setVerticalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        Desktop.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        javax.swing.GroupLayout panel_BackgroundLayout = new javax.swing.GroupLayout(panel_Background);
        panel_Background.setLayout(panel_BackgroundLayout);
        panel_BackgroundLayout.setHorizontalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_BackgroundLayout.setVerticalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrincipalActionPerformed
        frmPrincipal principal=new frmPrincipal();
        principal.setVisible(true);
        Desktop.add(principal);
        
    }//GEN-LAST:event_btn_PrincipalActionPerformed

    private void btn_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteActionPerformed
     MYSQLMaster master =new MYSQLMaster("localhost","root","123456admin","GARVA");
     frmCliente clientefrm=new frmCliente(master);
     clientefrm.setVisible(true);
     Desktop.add(clientefrm);
    }//GEN-LAST:event_btn_ClienteActionPerformed

    public static void main(String args[]) {
        
        
        FlatGitHubDarkIJTheme.setup();    // no lo boressssssssssssssssssssssssssssssssssssssss

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JButton btn_Cliente;
    private javax.swing.JButton btn_Principal;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_Background;
    private javax.swing.JPanel panel_Menu;
    private javax.swing.JPanel panel_Titulo;
    // End of variables declaration//GEN-END:variables
}
