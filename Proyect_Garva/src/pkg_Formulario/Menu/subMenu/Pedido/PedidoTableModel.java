package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pkg_MYSQL.Interfaces.IDetalle_Pedido;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_Modelo.Entidades.Detalle_Pedido;
import pkg_Modelo.Entidades.Menu;

public class PedidoTableModel extends AbstractTableModel  {
    private IDetalle_Pedido detallepedidoI;
    private List<Detalle_Pedido> detalle_pedido = new ArrayList<>();
    
    public PedidoTableModel(IDetalle_Pedido detallepedidoI) {
        this.detallepedidoI=detallepedidoI;
    }
    
    public void getObtenerTodos() throws IException{
        detalle_pedido = detallepedidoI.ObtenerTodos();
    }
       
    public void getObtenerTable(String idpedido) throws IException{
        detalle_pedido = detallepedidoI.ObtenerTable(idpedido);
    }
         
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CANTIDAD";
            case 1: return "CODIGO";
            case 2: return "MENU";
            case 3: return "PRECIO";
            case 4: return "IMPORTE";
            case 5: return  " ";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return detalle_pedido.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    } 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Detalle_Pedido detallepedido_value=detalle_pedido.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return detallepedido_value.getCantidad();
            case 1:return detallepedido_value.getId_menu().getId();
            case 2:return detallepedido_value.getId_menu().getNombre();
            case 3:return "s/ "+detallepedido_value.getId_menu().getPrecio();
            case 4:return "s/ "+detallepedido_value.getId_pedido().getId();
            case 5:return "ELIMINAR";
            default: return "";
        }
}
}
