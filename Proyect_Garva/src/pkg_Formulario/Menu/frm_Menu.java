package pkg_Formulario.Menu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import pkg_Formulario.Menu.subMenu.Admin.frmAdmin;
import pkg_Formulario.Menu.subMenu.Cliente.frmCliente_;
import pkg_Formulario.Menu.subMenu.Principal.frmPrincipal_;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_MYSQL.MYSQLMaster;

public class frm_Menu extends javax.swing.JFrame {

    public frm_Menu(MYSQLMaster master) throws IException {
        FlatGitHubDarkIJTheme.setup();
        initComponents();
        this.master=master;
        InitContent();
        
        // this.setExtendedState(frm_Menu.MAXIMIZED_BOTH);
        
        
    }
private IMaster master;
    private void InitContent() throws IException
    {
        
        initSelection(new frmCliente_(master));
        
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
        btn_Admin = new javax.swing.JButton();
        panel_Titulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_TipoUsuario = new javax.swing.JLabel();
        lbl_NomUsuario = new javax.swing.JLabel();
        panel_Container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1075, 622));
        setPreferredSize(new java.awt.Dimension(1075, 622));

        panel_Background.setBackground(new java.awt.Color(255, 255, 255));
        panel_Background.setMinimumSize(new java.awt.Dimension(1075, 622));
        panel_Background.setPreferredSize(new java.awt.Dimension(1075, 622));

        panel_Menu.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/Logo_01.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);

        btn_Principal.setBackground(new java.awt.Color(142, 253, 213));
        btn_Principal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Principal.setForeground(new java.awt.Color(0, 102, 102));
        btn_Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/hogar.png"))); // NOI18N
        btn_Principal.setText("Venta");
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

        btn_Admin.setBackground(new java.awt.Color(142, 253, 213));
        btn_Admin.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Admin.setForeground(new java.awt.Color(0, 102, 102));
        btn_Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/entrega-de-pedidos.png"))); // NOI18N
        btn_Admin.setText("Admin");
        btn_Admin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Admin.setBorderPainted(false);
        btn_Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Admin.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Admin.setIconTextGap(20);
        btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_MenuLayout = new javax.swing.GroupLayout(panel_Menu);
        panel_Menu.setLayout(panel_MenuLayout);
        panel_MenuLayout.setHorizontalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        panel_Titulo.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GARVA SERVICIOS ALIMENTICIOS");

        lbl_TipoUsuario.setText("jLabel3");

        lbl_NomUsuario.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_NomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_TipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_NomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbl_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panel_TituloLayout = new javax.swing.GroupLayout(panel_Titulo);
        panel_Titulo.setLayout(panel_TituloLayout);
        panel_TituloLayout.setHorizontalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TituloLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_TituloLayout.setVerticalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panel_Container.setBackground(new java.awt.Color(153, 255, 255));
        panel_Container.setPreferredSize(new java.awt.Dimension(840, 242));
        panel_Container.setLayout(new javax.swing.BoxLayout(panel_Container, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout panel_BackgroundLayout = new javax.swing.GroupLayout(panel_Background);
        panel_Background.setLayout(panel_BackgroundLayout);
        panel_BackgroundLayout.setHorizontalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addComponent(panel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_BackgroundLayout.setVerticalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initSelection(JPanel panel)
    {
        panel.setSize(840,240);
        panel.setLocation(0,0);
        
        panel_Container.removeAll();
        panel_Container.add(panel,BorderLayout.CENTER);
        panel_Container.repaint();
        panel_Container.revalidate();
    }
    private void btn_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrincipalActionPerformed
        initSelection(new frmPrincipal_(master));
        
    }//GEN-LAST:event_btn_PrincipalActionPerformed

    private void btn_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteActionPerformed
        try {
            InitContent();
        } catch (IException ex) {
            Logger.getLogger(frm_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ClienteActionPerformed

    private void btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdminActionPerformed
    initSelection(new frmAdmin(master));
    }//GEN-LAST:event_btn_AdminActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Admin;
    private javax.swing.JButton btn_Cliente;
    private javax.swing.JButton btn_Principal;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_NomUsuario;
    private javax.swing.JLabel lbl_TipoUsuario;
    private javax.swing.JPanel panel_Background;
    private javax.swing.JPanel panel_Container;
    private javax.swing.JPanel panel_Menu;
    private javax.swing.JPanel panel_Titulo;
    // End of variables declaration//GEN-END:variables
}
