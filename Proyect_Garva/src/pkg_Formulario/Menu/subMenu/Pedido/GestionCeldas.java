package pkg_Formulario.Menu.subMenu.Pedido;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer{
    private JLabel label= new JLabel();
    
    private ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/pkg_utilidades/images/Salir.png"));
    
    private String tipo;
    public GestionCeldas(String tipo){
        this.tipo=tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
if(tipo.equals("icono")){
    if(String.valueOf(value).equals("ELIMINAR")){
    label.setIcon(iconoEliminar);
    }
}
label.setHorizontalAlignment(JLabel.LEFT);
label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
return label;
    }
    }
    
    

