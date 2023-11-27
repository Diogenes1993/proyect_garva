
package pkg_MYSQL.Interfaces;

import pkg_Modelo.Entidades.Rol;

public interface IRol extends IBaseCRUD<Rol,String> {
     String newCodigo() throws IException;
}
