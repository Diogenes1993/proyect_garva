package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Adelanto;


public interface IAdelanto extends IBaseCRUD<Adelanto,String>{
    String NewCodigo() throws IException ;
    List<Adelanto> getBuscarXEmpleado(String id_empleado)throws IException;
    List<Adelanto> getBuscarXCliente(String id_cliente)throws IException;
    List<Adelanto> getBuscarXFecha(java.util.Date principio,java.util.Date fin)throws IException;
    
}
