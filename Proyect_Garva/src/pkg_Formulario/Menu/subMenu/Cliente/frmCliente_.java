
package pkg_Formulario.Menu.subMenu.Cliente;

import pkg_MYSQL.Interfaces.IMaster;

public class frmCliente_ extends javax.swing.JPanel {

   private final IMaster masterI;
private ClienteTableModel model_table;

    public frmCliente_(IMaster masterI) {
        initComponents();
        this.masterI=masterI;
        this.model_table = new ClienteTableModel(masterI.getICliente());
        model_table.getUpdate();
        tbl_Cliente.setModel(model_table);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_Registro = new javax.swing.JPanel();
        detalleClientePanel1 = new pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel();
        panel_Muestra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cliente = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(840, 242));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panel_RegistroLayout = new javax.swing.GroupLayout(panel_Registro);
        panel_Registro.setLayout(panel_RegistroLayout);
        panel_RegistroLayout.setHorizontalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(detalleClientePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(101, 101, 101))
        );
        panel_RegistroLayout.setVerticalGroup(
            panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistroLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(detalleClientePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );

        jTabbedPane1.addTab("Registro", panel_Registro);

        tbl_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Cliente);

        javax.swing.GroupLayout panel_MuestraLayout = new javax.swing.GroupLayout(panel_Muestra);
        panel_Muestra.setLayout(panel_MuestraLayout);
        panel_MuestraLayout.setHorizontalGroup(
            panel_MuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MuestraLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        panel_MuestraLayout.setVerticalGroup(
            panel_MuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MuestraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cliente", panel_Muestra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pkg_Formulario.Menu.subMenu.Cliente.DetalleClientePanel detalleClientePanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_Muestra;
    private javax.swing.JPanel panel_Registro;
    private javax.swing.JTable tbl_Cliente;
    // End of variables declaration//GEN-END:variables
}
