
package pkg_Formulario.Menu.subMenu.Empleado.Rol;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IRol;
import pkg_Modelo.Entidades.Rol;


public class RolTableModel extends AbstractTableModel{

   private IRol rolI;
    private List<Rol> datos_rol = new ArrayList<>();
    //private Cliente one_data;
    public RolTableModel(IRol rolI) {
        this.rolI=rolI;
    }
    
    public void getObtenerTodos() throws IException{
        datos_rol = rolI.ObtenerTodos();
    }
    
         
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "CARGO";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos_rol.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rol rol_value=datos_rol.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return rol_value.getId();
            case 1:return rol_value.getRol();
            default: return "";
        }
    }
    
}
