package pkg_MYSQL.Interfaces;

import java.util.List;
import pkg_Modelo.Entidades.Usuario;

public interface IUsuario extends IBaseCRUD<Usuario,String>{
    List<Usuario> getUsuariosActivos(boolean activo) throws IException;
    List<Usuario> getUsuariosInactivos(boolean activo) throws IException; 
    Usuario getDataUsuario(String data)throws IException;
    
}
