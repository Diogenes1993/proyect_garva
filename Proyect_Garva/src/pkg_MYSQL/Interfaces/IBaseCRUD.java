
package pkg_MYSQL.Interfaces;

import java.util.List;

public interface IBaseCRUD<T,K> {
    
    void Insertar(T a);
    void Actualizar(T a);
    void Eliminar(T a);
   List<T> ObtenerTodos();
   T ObtenerOne(K id);
}
