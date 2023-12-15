package pkg_Formulario.Menu.subMenu.Empleado;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Empleado;

public class EmpleadoTableModel extends AbstractTableModel{

   private IEmpleado iempleado;
    private List<Empleado> datos_empleado = new ArrayList<>();
    //private Cliente one_data;
    public EmpleadoTableModel(IEmpleado iempleado) {
        this.iempleado=iempleado;
    }
    
    public void getObtenerTodos() throws IException{
        datos_empleado = iempleado.ObtenerTodos();
    }
    
    public void getObtenerIDS(String id)  throws IException{
        datos_empleado =  iempleado.BuscarIds(id);
    }
    
    public void getObtenerNombreApellido(String nomape) throws IException{
        datos_empleado = iempleado.BuscarNomApe(nomape);
    }
    
    public void getObtenerDistrito(String distrito) throws IException{
        datos_empleado = iempleado.BuscarDistrito(distrito);
    }
      
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "CODIGO";
            case 1: return "NOMBRE";
            case 2: return "APELLIDOS";
            case 3: return "TELEFONO";
            case 4: return "DISTRITO";
            case 5: return "CARGO";
            case 6: return "ESTADO";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos_empleado.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado_value=datos_empleado.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return empleado_value.getId();
            case 1:return empleado_value.getNombre();
            case 2:return empleado_value.getApellido();
            case 3:return empleado_value.getTelefono();
            case 4:return empleado_value.getDistrito();
            case 5:return empleado_value.getRol().getRol();
            case 6:return empleado_value.getEstado();
            default: return "";
        }
    }
    
}
