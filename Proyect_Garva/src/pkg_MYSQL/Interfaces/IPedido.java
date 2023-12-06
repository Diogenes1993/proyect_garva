
package pkg_MYSQL.Interfaces;

import pkg_Modelo.Entidades.Pedido;

public interface  IPedido extends IBaseCRUD<Pedido,String>{
    String NewCod() throws IException;
}
