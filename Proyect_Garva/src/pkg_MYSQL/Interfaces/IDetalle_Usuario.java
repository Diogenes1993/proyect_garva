package pkg_MYSQL.Interfaces;

import java.util.Date;
import java.util.List;
import pkg_Modelo.Entidades.Detalle_Usuario;

public interface IDetalle_Usuario extends IBaseCRUD<Detalle_Usuario,Detalle_Usuario.Id_Detalle_Usuario> {
List<Detalle_Usuario> ObtenerPorEmpleado(long empleado);
List<Detalle_Usuario> ObtenerPorUsuario(long usuario);
List<Detalle_Usuario> ObtenerPorFecha(Date fecha);
        
}
