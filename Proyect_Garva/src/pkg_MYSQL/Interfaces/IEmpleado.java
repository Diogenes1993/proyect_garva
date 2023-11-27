package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Empleado;

public interface IEmpleado extends IBaseCRUD<Empleado,String>{
      List<Empleado> getUsuariosActivos(boolean activo) throws IException;
    List<Empleado> getUsuariosInactivos(boolean activo) throws IException; 
    Empleado getDataUsuario(String data)throws IException;
    String NewCodigo() throws IException;
    List<Empleado> BuscarIds(String id) throws IException;
    List<Empleado> BuscarNomApe(String nombre) throws IException;
    List<Empleado> BuscarDistrito(String distrito) throws IException;
}
