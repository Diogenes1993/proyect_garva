package pkg_MYSQL.Interfaces;

import java.util.Date;
import java.util.List;
import pkg_Modelo.Entidades.Detalle_Usuario;

public interface IDetalle_Usuario extends IBaseCRUD<Detalle_Usuario,Detalle_Usuario.IdDetalleUsuario> {
List<Detalle_Usuario> ObtenerPorEmpleado(Detalle_Usuario.IdDetalleUsuario user) throws IException;
List<Detalle_Usuario> ObtenerPorFecha(Date fecha) throws IException;
        
}
