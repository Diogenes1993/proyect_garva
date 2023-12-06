
package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Menu;

public interface IMenu extends IBaseCRUD<Menu,String>{
    
    List<Menu> getObtenerIds(String valor) throws IException;
    List<Menu> getObtenerNombres(String valor) throws IException;
    List<Menu> getObtenerMayoresStock(int valor ) throws IException;
    List<Menu> getObtenerMenoresStock(int valor ) throws IException;
    void SumarStock(Menu menu) throws IException;
    void RestarStock(Menu menu) throws IException;
    String NewCod()throws IException;
}
