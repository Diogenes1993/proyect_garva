package pkg_Formulario.Menu;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pkg_Formulario.Menu.subMenu.Cliente.frmCliente_;
import pkg_Formulario.Menu.subMenu.Empleado.FrmEmpleado;
import pkg_Formulario.Menu.subMenu.Empleado.Rol.FrmRol_Pa;
import pkg_Formulario.Menu.subMenu.Menu.FrmMenu_Pa;
import pkg_Formulario.Menu.subMenu.Pedido.frmDetallePedido;
import pkg_Formulario.frm_Login;
import pkg_Hilos.HReloj;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_utilidades.Calculos;
import pkg_utilidades.Utilidades;

public class frm_Menu extends javax.swing.JFrame {

    public void setHora(String hora)
    {
        lbl_hora.setText(hora);
    }
    
    private String id;
    private String usuario;
    private String apellido;
    
    public void setDatos(String id,String usuario,String correo,String nombre,String apellido,String rol,String ruta) throws IException
    {
      this.id=id;
      lbl_nom_Usuario.setText(usuario);
      this.usuario=nombre;
      this.apellido=apellido;
      lbl_Correo.setText(correo);
      lbl_Cargo.setText(rol);
      lbl_Nombre.setText(nombre);
      lbl_Apellido.setText(apellido);
      lbl_nom_Usuario.setIcon(new ImageIcon(ruta));
      if(rol.equals("Administrador")){
          btn_Empleado.setVisible(true);
          btn_Cargo.setVisible(true);
      }

    }
        
        
    private void mostrarHora(){
        HReloj reloj=new HReloj (lbl_hora);
        reloj.start();
      
    }
    
    private void MostrarFecha(){
    Date fecha=new Date();
    DateFormat date= DateFormat.getDateInstance(DateFormat.FULL);
    lbl_fecha.setText(date.format(fecha));
        System.out.println(fecha);
}

    private Calculos calculo=new Calculos();
    public frm_Menu(IMaster master) throws IException {
        
        initComponents();
        this.master=master;
        setSize(1123,760);
        setLocationRelativeTo(null);
        mostrarHora();
        MostrarFecha();
        
        InitContent();
        btn_Empleado.setVisible(false);
        btn_Cargo.setVisible(false);
        setIconImage(new ImageIcon(getClass().getResource("/pkg_utilidades/images/Login/chef_1.png")).getImage());
        this.setExtendedState(frm_Menu.MAXIMIZED_BOTH);
        
        
    }
private IMaster master;
    public void InitContent() throws IException
    {
        frmDetallePedido frmDetalle=new frmDetallePedido(master); 
       
        frmDetalle.setCodEmpleado(id);
        frmDetalle.setNombreEmpleado(usuario +" "+apellido);
         initSelection(frmDetalle);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Background = new javax.swing.JPanel();
        panel_Menu = new javax.swing.JPanel();
        btn_Principal = new javax.swing.JButton();
        btn_Cliente = new javax.swing.JButton();
        btn_Cargo = new javax.swing.JButton();
        btn_Empleado = new javax.swing.JButton();
        btn_Admin1 = new javax.swing.JButton();
        btn_CerrarSession = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_Cargo = new javax.swing.JLabel();
        lbl_Image = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Apellido = new javax.swing.JLabel();
        btn_Menu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel_Titulo = new javax.swing.JPanel();
        lbl_nom_Usuario = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_Correo = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        panel_Container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1185, 650));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1900, 650));

        panel_Background.setBackground(new java.awt.Color(255, 255, 255));
        panel_Background.setMinimumSize(new java.awt.Dimension(1185, 650));
        panel_Background.setPreferredSize(new java.awt.Dimension(1185, 650));

        panel_Menu.setBackground(new java.awt.Color(153, 255, 255));

        btn_Principal.setBackground(new java.awt.Color(204, 204, 204));
        btn_Principal.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
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

        btn_Cliente.setBackground(new java.awt.Color(204, 204, 204));
        btn_Cliente.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
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

        btn_Cargo.setBackground(new java.awt.Color(204, 204, 204));
        btn_Cargo.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btn_Cargo.setForeground(new java.awt.Color(0, 102, 102));
        btn_Cargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/coordinar.png"))); // NOI18N
        btn_Cargo.setText("Cargo");
        btn_Cargo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Cargo.setBorderPainted(false);
        btn_Cargo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Cargo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Cargo.setIconTextGap(20);
        btn_Cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CargoActionPerformed(evt);
            }
        });

        btn_Empleado.setBackground(new java.awt.Color(204, 204, 204));
        btn_Empleado.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btn_Empleado.setForeground(new java.awt.Color(0, 102, 102));
        btn_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/admin.png"))); // NOI18N
        btn_Empleado.setText("Empleado");
        btn_Empleado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Empleado.setBorderPainted(false);
        btn_Empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Empleado.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Empleado.setIconTextGap(20);
        btn_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EmpleadoActionPerformed(evt);
            }
        });

        btn_Admin1.setBackground(new java.awt.Color(204, 204, 204));
        btn_Admin1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btn_Admin1.setForeground(new java.awt.Color(0, 102, 102));
        btn_Admin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/reporte.png"))); // NOI18N
        btn_Admin1.setText("Boletas");
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

        btn_CerrarSession.setBackground(new java.awt.Color(204, 204, 204));
        btn_CerrarSession.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btn_CerrarSession.setForeground(new java.awt.Color(0, 102, 102));
        btn_CerrarSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/Cerrar_Sesion.png"))); // NOI18N
        btn_CerrarSession.setText("Cerrar Session");
        btn_CerrarSession.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_CerrarSession.setBorderPainted(false);
        btn_CerrarSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_CerrarSession.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_CerrarSession.setIconTextGap(20);
        btn_CerrarSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarSessionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GARVA SERVICIOS ALIMENTICIOS");

        lbl_Cargo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lbl_Cargo.setForeground(new java.awt.Color(51, 255, 0));
        lbl_Cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Cargo.setText("Cargo");

        lbl_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/GARVA_FONDO.png"))); // NOI18N
        lbl_Image.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lbl_Nombre.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_Nombre.setForeground(new java.awt.Color(0, 51, 204));
        lbl_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Nombre.setText("Nombre");

        lbl_Apellido.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_Apellido.setForeground(new java.awt.Color(0, 0, 204));
        lbl_Apellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Apellido.setText("Apellidos");

        btn_Menu.setBackground(new java.awt.Color(204, 204, 204));
        btn_Menu.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btn_Menu.setForeground(new java.awt.Color(0, 102, 102));
        btn_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/chef.png"))); // NOI18N
        btn_Menu.setText("Menu");
        btn_Menu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Menu.setBorderPainted(false);
        btn_Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Menu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Menu.setIconTextGap(20);
        btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/mantenimiento.png"))); // NOI18N
        jLabel1.setText("MANTENIMIENTO");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(153, 255, 255)));
        jLabel1.setIconTextGap(20);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_MenuLayout = new javax.swing.GroupLayout(panel_Menu);
        panel_Menu.setLayout(panel_MenuLayout);
        panel_MenuLayout.setHorizontalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
            .addComponent(lbl_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lbl_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_CerrarSession, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_MenuLayout.setVerticalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbl_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbl_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_Admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btn_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_MenuLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btn_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(btn_CerrarSession))
        );

        panel_Titulo.setBackground(new java.awt.Color(0, 0, 0));

        lbl_nom_Usuario.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_nom_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nom_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_nom_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/admin.png"))); // NOI18N
        lbl_nom_Usuario.setText("Usuario");
        lbl_nom_Usuario.setAlignmentX(0.5F);
        lbl_nom_Usuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(0, 0, 0)));
        lbl_nom_Usuario.setIconTextGap(20);

        lbl_hora.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_hora.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_hora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/reloj.png"))); // NOI18N
        lbl_hora.setAlignmentY(0.4F);
        lbl_hora.setIconTextGap(5);

        lbl_Correo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_Correo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_Correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/email.png"))); // NOI18N
        lbl_Correo.setText("Correo");
        lbl_Correo.setIconTextGap(20);

        lbl_fecha.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg_utilidades/images/icons/calendar.png"))); // NOI18N
        lbl_fecha.setIconTextGap(10);

        javax.swing.GroupLayout panel_TituloLayout = new javax.swing.GroupLayout(panel_Titulo);
        panel_Titulo.setLayout(panel_TituloLayout);
        panel_TituloLayout.setHorizontalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TituloLayout.createSequentialGroup()
                .addComponent(lbl_nom_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbl_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_TituloLayout.setVerticalGroup(
            panel_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_nom_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(lbl_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_Container.setBackground(new java.awt.Color(255, 255, 255));
        panel_Container.setPreferredSize(new java.awt.Dimension(815, 734));
        panel_Container.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout panel_BackgroundLayout = new javax.swing.GroupLayout(panel_Background);
        panel_Background.setLayout(panel_BackgroundLayout);
        panel_BackgroundLayout.setHorizontalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)))
        );
        panel_BackgroundLayout.setVerticalGroup(
            panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BackgroundLayout.createSequentialGroup()
                .addComponent(panel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addComponent(panel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initSelection(JPanel panel)
    {
        panel.setSize(951, 592);
        panel.setLocation(0,0);
        
        panel_Container.removeAll();
      
        panel_Container.add(panel);
        panel_Container.revalidate();
        panel_Container.repaint();
        
    }
    private void btn_PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrincipalActionPerformed
        
        try {
            InitContent();
        } catch (IException ex) {
            Utilidades.Mensaje("ERROR","Abrir Empleado",0);
        }
        
    }//GEN-LAST:event_btn_PrincipalActionPerformed

    private void btn_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteActionPerformed
        try {
            initSelection(new frmCliente_(master));
        } catch (IException ex) {
         Utilidades.Mensaje("ERROR","Abrir Empleado",0);
        }
    }//GEN-LAST:event_btn_ClienteActionPerformed

    private void btn_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EmpleadoActionPerformed
        try {
            initSelection(new FrmEmpleado(master));
        } catch (IException ex) {
           Utilidades.Mensaje("ERROR","Abrir Empleado",0);
        }
    }//GEN-LAST:event_btn_EmpleadoActionPerformed

    private void btn_Admin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Admin1ActionPerformed

    }//GEN-LAST:event_btn_Admin1ActionPerformed

    private void btn_CargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CargoActionPerformed
        try {
            initSelection(new FrmRol_Pa(master));
        } catch (IException ex) {
           Utilidades.Mensaje("ERROR","Abrir Rol",0);
        }
    }//GEN-LAST:event_btn_CargoActionPerformed

    private void btn_CerrarSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarSessionActionPerformed
        
       int res= calculo.getMensage("src/pkg_utilidades/images/pregunta.png","Mensaje", "¿Desea Cerrar su Session?");
       if(res==0){
        frm_Login login=new frm_Login(master);
        login.setVisible(true);
        
        dispose();
       }
        
    }//GEN-LAST:event_btn_CerrarSessionActionPerformed

    private void btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuActionPerformed
             try {
            initSelection(new FrmMenu_Pa(master));
        } catch (IException ex) {
           Utilidades.Mensaje("ERROR","Abrir Menu",0);
        }
    }//GEN-LAST:event_btn_MenuActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Admin1;
    private javax.swing.JButton btn_Cargo;
    private javax.swing.JButton btn_CerrarSession;
    private javax.swing.JButton btn_Cliente;
    private javax.swing.JButton btn_Empleado;
    private javax.swing.JButton btn_Menu;
    private javax.swing.JButton btn_Principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Apellido;
    private javax.swing.JLabel lbl_Cargo;
    private javax.swing.JLabel lbl_Correo;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nom_Usuario;
    private javax.swing.JPanel panel_Background;
    private javax.swing.JPanel panel_Container;
    private javax.swing.JPanel panel_Menu;
    private javax.swing.JPanel panel_Titulo;
    // End of variables declaration//GEN-END:variables
}
