
package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Cliente;

public interface ICliente extends IBaseCRUD<Cliente,String>{
    String NewCodigo() throws IException;
    List<Cliente> BuscarIds(String id) throws IException;
    List<Cliente> BuscarNomApe(String nombre) throws IException;
    List<Cliente> BuscarDistrito(String distrito) throws IException;
}
