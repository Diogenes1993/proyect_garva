
package pkg_MYSQL.Interfaces;

import pkg_Modelo.Entidades.Distrito;

public interface IDistrito extends IBaseCRUD<Distrito,String>{
    String newCodigo() throws IException;
}
