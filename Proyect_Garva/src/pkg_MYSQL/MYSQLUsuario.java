package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IUsuario;
import pkg_Modelo.Entidades.Usuario;
import pkg_utilidades.Utilidades;

public class MYSQLUsuario implements IUsuario{
    private final String INSERT="INSERT INTO USUARIO(NOMBRE_USUARIO,CONTRASENIA,CORREO) VALUES(?,?,?)";
    private final String UPDATE="UPDATE USUARIO SET NOMBRE_USUARIO=?,CONTRASENIA=?,ESTADO=?,CORREO=?  WHERE PK_ID_USUARIO=?";
    private final String REMOVEONEUPDATE="UPDATE USUARIO SET ESTADO=?  WHERE PK_ID_USUARIO=?";
    private final String GETALL ="SELECT PK_ID_USUARIO,NOMBRE_USUARIO,CONTRASENIA,ESTADO,CORREO FROM USUARIO";
    private final String GETONE= GETALL + " WHERE NOMBRE_USUARIO=?";
    private final String GETALLACTIVE=GETALL + " WHERE ESTADO=TRUE" ;
    private final String GETALLINACTIVE=GETALL + " WHERE ESTADO=FALSE" ;
    
private  final  Connection connection;
    public MYSQLUsuario(Connection connection) {
        this.connection=connection;
    }

    
    @Override
    public void Insertar(Usuario usuario) throws IException{
       PreparedStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
         
         preparacion_insert.setString(1,usuario.getUsuario() );
         preparacion_insert.setString(2, usuario.getContrasenia());
         preparacion_insert.setString(3,usuario.getCorreo());
         
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Usuario no se inserto ", new SQLException(), "MENSAJE", 1);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
            if(result_clave.next())
                {
                    usuario.setId(result_clave.getLong(1));
                }
            else
            {
                 Utilidades.manejarError("No se puede asignar Id a este Usuario", new SQLException(), "MENSAJE", 1);
                 
            }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL INSERT USUARIO", new SQLException(), "ERROR", 1);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "INSERT USUARIO");
        Utilidades.cerrarPrepare(preparacion_insert, "INSERT USUARIO");
    }    
    }

    @Override
    public void Actualizar(Usuario usuario) throws IException{
      PreparedStatement preparacion_update=null;
    
    try
    {
         preparacion_update=connection.prepareStatement(UPDATE);
         
         preparacion_update.setString(1,usuario.getUsuario());
         preparacion_update.setString(2,usuario.getContrasenia() );
         preparacion_update.setBoolean(3,usuario.isEstado() );
         preparacion_update.setString(4,usuario.getCorreo() );
         preparacion_update.setLong(5,usuario.getId());
         
                     if(preparacion_update.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Usuario no se actualizo",new SQLException(),"MENSAJE",1);
                }
           
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATE USUARIO ",ex,"ERROR",0);
        
    }finally
    {
         Utilidades.cerrarPrepare(preparacion_update, "UPDATE USUARIO");
    }
    }

    @Override
    public void Eliminar(Usuario usuario) throws IException{
         PreparedStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareStatement(REMOVEONEUPDATE);
         
         preparacion_delete.setBoolean(1,usuario.isEstado());
         preparacion_delete.setLong(2,usuario.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el Usuario no se Elimino",new SQLException(),"MENSAJE",1);
                }
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL DELETE USUARIO ",ex,"ERROR",0);

        
    }finally
    {
        Utilidades.cerrarPrepare(preparacion_delete, "DELETE USUARIO");
    }
    }

       private Usuario Data(ResultSet resultado_data) throws SQLException
    {
 
          String nombre = resultado_data.getString("NOMBRE_USUARIO");
          String contrasenia = resultado_data.getString("CONTRASENIA");
          boolean estado = resultado_data.getBoolean("ESTADO");
          String correo = resultado_data.getString("CORREO");
          
          Usuario usuario=new Usuario(nombre,contrasenia,estado,correo);
          usuario.setId(resultado_data.getLong("PK_ID_USUARIO"));
          return usuario;
    }   
    
    @Override
    public List<Usuario> ObtenerTodos() throws IException{
          PreparedStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Usuario> usuario_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareStatement(GETALL);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             usuario_list.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("No hay GETALL Usuarios ",ex,"ERROR",0);
            }
        finally
        {
            Utilidades.cerrarResul(resultado_data, "GETALL USUARIO");
        Utilidades.cerrarPrepare(preparacion_select, "GETALL USUARIO");
        }
        return usuario_list;
    }

    @Override
    public Usuario ObtenerOne(String nombre_user) throws IException{
     PreparedStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Usuario usuario_buscado = null;
        try
        {
            preparacion_where=connection.prepareStatement(GETONE);
            preparacion_where.setString(1, nombre_user);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               usuario_buscado=Data(resultado_data);
            }
            
        } 
         catch (SQLException ex) 
            {
                       Utilidades.manejarError("Error en SQL GETONE USUARIO ",ex,"ERROR",0);

            }
        finally
        {
        Utilidades.cerrarResul(resultado_data, "GETONE USUARIO");
        Utilidades.cerrarPrepare(preparacion_where, "GETONE USUARIO");
        }
        return usuario_buscado;
    }

    @Override
    public List<Usuario> getUsuariosActivos(boolean activo) throws IException{
      PreparedStatement preparacion_select_active = null;
        ResultSet resultado_data = null;
        
        List<Usuario> usuario_list_activos= new ArrayList<>();
        try
        {
            preparacion_select_active=connection.prepareStatement(GETALLACTIVE);
           
            resultado_data=preparacion_select_active.executeQuery();
            
            while(resultado_data.next())
            {
             usuario_list_activos.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
           Utilidades.manejarError("Error en SQL GETALLACTIVE USUARIO ",ex,"ERROR",0);

            }
        finally
        {
           Utilidades.cerrarResul(resultado_data, "GETONE USUARIO");
        Utilidades.cerrarPrepare(preparacion_select_active, "GETONE USUARIO");
        }
        return usuario_list_activos;
    }

    @Override
    public List<Usuario> getUsuariosInactivos(boolean activo) throws IException{
        PreparedStatement preparacion_select_inactive = null;
        ResultSet resultado_data = null;
        
        List<Usuario> usuario_list_inactivos= new ArrayList<>();
        try
        {
            preparacion_select_inactive=connection.prepareStatement(GETALLINACTIVE);
           
            resultado_data=preparacion_select_inactive.executeQuery();
            
            while(resultado_data.next())
            {
             usuario_list_inactivos.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
            Utilidades.manejarError("Error en SQL GETALLINACTIVE USUARIO ",ex,"ERROR",0);

            }
        finally
        {
         Utilidades.cerrarResul(resultado_data, "GETALLINACTIVE USUARIO");
        Utilidades.cerrarPrepare(preparacion_select_inactive, "GETALLINACTIVE USUARIO");
        }
        return usuario_list_inactivos;
    }
    
    
    
    
}
