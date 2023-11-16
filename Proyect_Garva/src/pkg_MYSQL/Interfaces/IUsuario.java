package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Usuario;

public interface IUsuario extends IBaseCRUD<Usuario,Long>{
    List<Usuario> getUsuariosActivos(boolean activo) throws IException;
    List<Usuario> getUsuariosInactivos(boolean activo) throws IException; 
    
    
}
