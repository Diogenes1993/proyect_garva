package pkg_Formulario.Menu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg_Formulario.Menu.subMenu.Admin.frmAdmin;
import pkg_Formulario.Menu.subMenu.Cliente.frmCliente_;
import pkg_Formulario.Menu.subMenu.Pedido.frmPedido;
import pkg_Formulario.Menu.subMenu.Principal.frmPrincipal_;
import pkg_Hilos.HReloj;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;

public class frm_Menu extends javax.swing.JFrame {

    public void setHora(String hora)
    {
        lbl_hora.setText(hora);
    };
    public void setNombreUsuario(String NombreUsuario)
    {
      lbl_nom_Usuario.setText(NombreUsuario);
    }
    
    public void setCorreoUsuario(String CorreoUsuario)
    {
      lbl_Correo.setText(CorreoUsuario);
    }
    
    
    private void mostrarHora(){
        HReloj reloj=new HReloj (lbl_hora);
        reloj.start();
       
    }
    
    private void MostrarFecha(){
    Date fecha=new Date();
    DateFormat date= DateFormat.getDateInstance(DateFormat.FULL);
    lbl_fecha.setText("Fecha: "+date.format(fecha));
}

    
    public frm_Menu(IMaster master) throws IException {
        FlatGitHubDarkIJTheme.setup();
        initComponents();
        this.master=master;
        setLocationRelativeTo(null);
        InitContent();
        mostrarHora();
        MostrarFecha();
        // this.setExtendedState(frm_Menu.MAXIMIZED_BOTH);
        
        
    }
private IMaster master;
    private void InitContent() throws IException
    {
        initSelection(new frmPrincipal_(master));
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Background = new javax.swing.JPanel();
        panel_Menu = new javax.swing.JPanel();
        btn_Principal = new javax.swing.JButton();
        btn_Cliente = new javax.swing.JButton();
        btn_Pedido = new javax.swing.JButton();
        btn_Admin = new javax.swing.JButton();
        btn_Admin1 = new javax.swing.JButton();
        btn_Admin2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_Titulo = new javax.swing.JPanel();
        lbl_nom_Usuario = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_Correo = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        panel_Container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1575, 822));

        panel_Background.setBackground(new java.awt.Color(255, 255, 255));
        panel_Background.setMinimumSize(new java.awt.Dimension(1075, 622));
        panel_Background.setPreferredSize(new java.awt.Dimension(1075, 622));

        panel_Menu.setBackground(new java.awt.Color(204, 204, 255));

        btn_Principal.setBackground(new java.awt.Color(142, 253, 213));
        btn_Principal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Principal.setForeground(new java.awt.Color(0, 102, 102));
        btn_Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/hogar.png"))); // NOI18N
        btn_Principal.setText("Inicio");
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

        btn_Pedido.setBackground(new java.awt.Color(142, 253, 213));
        btn_Pedido.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Pedido.setForeground(new java.awt.Color(0, 102, 102));
        btn_Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/entrega-de-pedidos.png"))); // NOI18N
        btn_Pedido.setText("Pedidos");
        btn_Pedido.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Pedido.setBorderPainted(false);
        btn_Pedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Pedido.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Pedido.setIconTextGap(20);
        btn_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PedidoActionPerformed(evt);
            }
        });

        btn_Admin.setBackground(new java.awt.Color(142, 253, 213));
        btn_Admin.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Admin.setForeground(new java.awt.Color(0, 102, 102));
        btn_Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/admin.png"))); // NOI18N
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

        btn_Admin1.setBackground(new java.awt.Color(142, 253, 213));
        btn_Admin1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Admin1.setForeground(new java.awt.Color(0, 102, 102));
        btn_Admin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/reporte.png"))); // NOI18N
        btn_Admin1.setText("Reportes");
        btn_Admin1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Admin1.setBorderPainted(false);
        btn_Admin1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Admin1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Admin1.setIconTextGap(20);
        btn_Admin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Admin1ActionPerformed(evt);
            }
        });

        btn_Admin2.setBackground(new java.awt.Color(142, 253, 213));
        btn_Admin2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_Admin2.setForeground(new java.awt.Color(0, 102, 102));
        btn_Admin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Cerrar_Sesion.png"))); // NOI18N
        btn_Admin2.setText("Cerrar Session");
        btn_Admin2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Admin2.setBorderPainted(false);
        btn_Admin2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Admin2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Admin2.setIconTextGap(20);
        btn_Admin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Admin2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GARVA SERVICIOS ALIMENTICIOS");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cargo");

        lbl_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/atension.png"))); // NOI18N
        lbl_Image.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.black, null, null));

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        javax.swing.GroupLayout panel_MenuLayout = new javax.swing.GroupLayout(panel_Menu);
        panel_Menu.setLayout(panel_MenuLayout);
        panel_MenuLayout.setHorizontalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(btn_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Admin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Admin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_MenuLayout.setVerticalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btn_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btn_Admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                .addComponent(btn_Admin2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_Titulo.setBackground(new java.awt.Color(204, 255, 204));

        lbl_nom_Usuario.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_nom_Usuario.setForeground(new java.awt.Color(0, 0, 153));
        lbl_nom_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_nom_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/admin.png"))); // NOI18N
        lbl_nom_Usuario.setText("Usuario");
        lbl_nom_Usuario.setAlignmentX(0.5F);
        lbl_nom_Usuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(204, 255, 204)));
        lbl_nom_Usuario.setIconTextGap(20);

        lbl_hora.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_hora.setForeground(new java.awt.Color(0, 0, 153));
        lbl_hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_hora.setText("Hora:");
        lbl_hora.setAlignmentY(0.4F);

        lbl_Correo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_Correo.setForeground(new java.awt.Color(0, 0, 153));
        lbl_Correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_Correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/email.png"))); // NOI18N
        lbl_Correo.setText("Correo");
        lbl_Correo.setIconTextGap(20);

        lbl_fecha.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(0, 0, 153));
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_fecha.setText("Fecha:");

        javax.swing.GroupLayout panel_TituloLayout = new javax.swing.GroupLayout(panel_Titulo);
        panel_Titulo.setLayout(panel_TituloLayout);
        panel_TituloLayout.setHorizontalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TituloLayout.createSequentialGroup()
                .addComponent(lbl_nom_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_TituloLayout.setVerticalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_nom_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(lbl_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_Container.setBackground(new java.awt.Color(153, 255, 255));
        panel_Container.setPreferredSize(new java.awt.Dimension(840, 242));
        panel_Container.setLayout(new javax.swing.BoxLayout(panel_Container, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout panel_BackgroundLayout = new javax.swing.GroupLayout(panel_Background);
        panel_Background.setLayout(panel_BackgroundLayout);
        panel_BackgroundLayout.setHorizontalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
        );
        panel_BackgroundLayout.setVerticalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
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
        
        try {
            InitContent();
        } catch (IException ex) {
            Logger.getLogger(frm_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_PrincipalActionPerformed

    private void btn_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteActionPerformed
        try {
            initSelection(new frmCliente_(master));
        } catch (IException ex) {
            Logger.getLogger(frm_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ClienteActionPerformed

    private void btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdminActionPerformed
    initSelection(new frmAdmin(master));
    }//GEN-LAST:event_btn_AdminActionPerformed

    private void btn_Admin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Admin1ActionPerformed

    }//GEN-LAST:event_btn_Admin1ActionPerformed

    private void btn_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PedidoActionPerformed
            initSelection(new frmPedido());
    }//GEN-LAST:event_btn_PedidoActionPerformed

    private void btn_Admin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Admin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Admin2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Admin;
    private javax.swing.JButton btn_Admin1;
    private javax.swing.JButton btn_Admin2;
    private javax.swing.JButton btn_Cliente;
    private javax.swing.JButton btn_Pedido;
    private javax.swing.JButton btn_Principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_Correo;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nom_Usuario;
    private javax.swing.JPanel panel_Background;
    private javax.swing.JPanel panel_Container;
    private javax.swing.JPanel panel_Menu;
    private javax.swing.JPanel panel_Titulo;
    // End of variables declaration//GEN-END:variables
}
