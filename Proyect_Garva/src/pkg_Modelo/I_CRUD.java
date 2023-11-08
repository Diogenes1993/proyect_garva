
package pkg_Modelo;


import java.util.List;
import java.util.Map;


public interface I_CRUD<T> {
    boolean Agregar(T a);
    boolean Actualizar(T a);
    boolean Eliminar(T a);
  List<Map<String, Object>>Mostrar();
}
