package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Detalle_Pedido;


public interface IDetalle_Pedido extends IBaseCRUD<Detalle_Pedido,String>{
    List<Detalle_Pedido> ObtenerTable(String pedido) throws IException;
    String ObtenerTotal(String pedido) throws IException;
}
