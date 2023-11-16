
package pkg_MYSQL.Interfaces;

import java.util.List;

public interface IBaseCRUD<T,K> {
    
    void Insertar(T a) throws IException;
    void Actualizar(T a) throws IException;
    void Eliminar(T a) throws IException;
   List<T> ObtenerTodos() throws IException;
   T ObtenerOne(K id) throws IException;
}
