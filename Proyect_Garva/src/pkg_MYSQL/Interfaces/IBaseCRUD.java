
package pkg_MYSQL.Interfaces;

import java.util.List;

public interface IBaseCRUD<T,K> {
    
    void Insertar(T t) throws IException;
    void Actualizar(T t) throws IException;
    void Eliminar(T t) throws IException;
   List<T> ObtenerTodos() throws IException;
   T ObtenerOne(K k) throws IException;
}
