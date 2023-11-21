
package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Distrito;

public interface IDistrito {
    List<Distrito> ObtenerTodos() throws IException;
}
