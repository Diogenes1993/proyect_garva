
package pkg_Formulario.Menu.subMenu.Menu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_Modelo.Entidades.Menu;


public class MenuTableModel extends AbstractTableModel{

   private IMenu menuI;
    private List<Menu> datos_menu = new ArrayList<>();
    
    public MenuTableModel(IMenu menuI) {
        this.menuI=menuI;
    }
    
    public void getObtenerTodos() throws IException{
        datos_menu = menuI.ObtenerTodos();
    }
    
         
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "NOMBRE";
            case 2: return "STOCK";
            case 3: return "PRECIO";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos_menu.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Menu menu_value=datos_menu.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return menu_value.getId();
            case 1:return menu_value.getNombre();
            case 2:return menu_value.getStock();
            case 3:return menu_value.getPrecio();
            default: return "";
        }
    }
    
}
