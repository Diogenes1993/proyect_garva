package pkg_Formulario.Menu.subMenu.Cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Cliente;

public class ClienteTableModel  extends AbstractTableModel{

    private ICliente icliente;
    private List<Cliente> datos_cliente = new ArrayList<>();
    //private Cliente one_data;
    public ClienteTableModel(ICliente icliente) {
        this.icliente=icliente;
    }
    
    
    public void getObtenerTodos() throws IException{
        datos_cliente = icliente.ObtenerTodos();
    }
    
    public void getObtenerOne(String id)  throws IException{
        datos_cliente =  (List<Cliente>) icliente.ObtenerOne(id);
    }
    
    public void getObtenerNombreApellido(String nomape) throws IException{
        datos_cliente = icliente.BuscarNomApe(nomape);
    }
    
    public void getObtenerDistrito(String distrito) throws IException{
        datos_cliente = icliente.BuscarDistrito(distrito);
    }
    
    
    
    @Override
    public String getColumnName(int colum)
    {
        switch (colum)
        {
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "APELLIDO";
            case 3: return "DISTRITO";
            case 4: return "TELEFONO";
            case 5: return "CORREO";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos_cliente.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente_value=datos_cliente.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return cliente_value.getId();
            case 1:return cliente_value.getNombre();
            case 2:return cliente_value.getApellido();
            case 3:return cliente_value.getDistrito();
            case 4:return cliente_value.getTelefono();
            case 5:return cliente_value.getCorreo();
            default: return "";
        }
    }
    
    
}
