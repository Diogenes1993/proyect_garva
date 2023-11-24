package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Empleado;

public interface IEmpleado extends IBaseCRUD<Empleado,Long>{
      List<Empleado> getUsuariosActivos(boolean activo) throws IException;
    List<Empleado> getUsuariosInactivos(boolean activo) throws IException; 
    Empleado getDataUsuario(String data)throws IException;
}
