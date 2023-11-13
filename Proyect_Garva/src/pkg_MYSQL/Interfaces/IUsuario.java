package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Usuario;

public interface IUsuario extends IBaseCRUD<Usuario,Long>{
    List<Usuario> getUsuariosActivos(boolean activo);
    List<Usuario> getUsuariosInactivos(boolean activo);
    
    
}
