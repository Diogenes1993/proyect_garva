
package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IUsuario;
import pkg_Modelo.Entidades.Usuario;
import pkg_utilidades.Utilidades;

public class MYSQLUsuario implements IUsuario{
    private final String INSERT="INSERT INTO USUARIO(NOMBRE_USUARIO,CONTRASENIA,CORREO) VALUES(?,?,?)";
    private final String UPDATE="UPDATE USUARIO SET NOMBRE_USUARIO=?,CONTRASENIA=?,ESTADO=?,CORREO=?  WHERE PK_ID_USUARIO=?";
    private final String REMOVEONEUPDATE="UPDATE USUARIO SET ESTADO=?  WHERE PK_ID_USUARIO=?";
    private final String GETALL ="SELECT PK_ID_USUARIO,NOMBRE_USUARIO,CONTRASENIA,ESTADO,CORREO FROM USUARIO";
    private final String GETONE= GETALL + " WHERE PK_ID_USUARIO=?";
    private final String GETALLACTIVE=GETALL + " WHERE ESTADO=TRUE" ;
    private final String GETALLINACTIVE=GETALL + " WHERE ESTADO=FALSE" ;
    
private  final  Connection connection;
    public MYSQLUsuario(Connection connection) {
        this.connection=connection;
    }

    
    @Override
    public void Insertar(Usuario usuario) {
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
                    Utilidades.Mensaje("ERROR","Espera el Usuario no se inserto ",0);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
            if(result_clave.next())
                {
                    usuario.setId(result_clave.getLong(1));
                }
            else
            {
                 Utilidades.Mensaje("ERROR","No se puede asignar Id a este Usuario",0);
                 
            }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL INSERT USUARIO".concat(ex.toString()),0);
        
    }finally
    {
         if(result_clave != null)
        {
            try
            {
                result_clave.close();
            }
            catch(SQLException ex)
            {
                 Utilidades.Mensaje("ERROR","Error en Result INSERT USUARIO".concat(ex.toString()),0);
            }
        }
        if(preparacion_insert != null)
        {
            try
            {
                preparacion_insert.close();
            }
            catch(SQLException ex)
            {
                Utilidades.Mensaje("ERROR","Error en Prepared INSERT USUARIO".concat(ex.toString()),0);
            }
        }
    }    
    }

    @Override
    public void Actualizar(Usuario usuario) {
      PreparedStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(UPDATE);
         
         preparacion_insert.setString(1,usuario.getUsuario());
         preparacion_insert.setString(2,usuario.getContrasenia() );
         preparacion_insert.setBoolean(3,usuario.isEstado() );
         preparacion_insert.setString(4,usuario.getCorreo() );
         preparacion_insert.setLong(5,usuario.getId());
         
                     if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.Mensaje("ERROR","Espera el Usuario no se actualizo",0);
                }
           
     
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL UPDATE USUARIO ".concat(ex.toString()),0);
        
    }finally
    {
        if(preparacion_insert != null)
        {
            try
            {
                preparacion_insert.close();
            }
            catch(SQLException ex)
            {
                Utilidades.Mensaje("ERROR","Error en Prepared UPDATE USUARIO ".concat(ex.toString()),0);
            }
        }
    }
    }

    @Override
    public void Eliminar(Usuario usuario) {
         PreparedStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareStatement(REMOVEONEUPDATE);
         
         preparacion_delete.setBoolean(1,usuario.isEstado());
         preparacion_delete.setLong(2,usuario.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.Mensaje("ERROR","Espera el Usuario no se Elimino",0);
                }
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL DELETE USUARIO ".concat(ex.toString()),0);

        
    }finally
    {
        if(preparacion_delete != null)
        {
            try
            {
                preparacion_delete.close();
            }
            catch(SQLException ex)
            {
              Utilidades.Mensaje("ERROR","Error en Prepared DELETE ".concat(ex.toString()),0);
            }
        }
    }
    }

       private Usuario Data(ResultSet resultado_data) 
    {
      try {
          String nombre = resultado_data.getString("NOMBRE_USUARIO");
          String contrasenia = resultado_data.getString("CONTRASENIA");
          boolean estado = resultado_data.getBoolean("ESTADO");
          String correo = resultado_data.getString("CORREO");
          
          Usuario usuario=new Usuario(nombre,contrasenia,estado,correo);
          usuario.setId(resultado_data.getLong("PK_ID_USUARIO"));
          return usuario;
      } catch (SQLException ex) {
          
          Utilidades.Mensaje("ERROR","Usuarios  no llenados".concat(ex.toString()),0);
      }
      return null;
    }   
    
    @Override
    public List<Usuario> ObtenerTodos() {
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
                 Utilidades.Mensaje("ERROR","No hay RESULTSET Usuarios ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                          Utilidades.Mensaje("ERROR","Error cerrar ResultSet SELECT ".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_select != null)
            {
                try
                    {
                        preparacion_select.close();
                    }
                catch(SQLException ex)
                    {
                         Utilidades.Mensaje("ERROR","Error cerrar Prepared SELECT ".concat(ex.toString()),0);
                    }
            }
        }
        return usuario_list;
    }

    @Override
    public Usuario ObtenerOne(Long id) {
     PreparedStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Usuario usuario_buscado = null;
        try
        {
            preparacion_where=connection.prepareStatement(GETONE);
            preparacion_where.setLong(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               usuario_buscado=Data(resultado_data);
            }else
            {
                Utilidades.Mensaje("MENSAJE","No existe el  Usuario  ",1);
            }
            
        } 
         catch (SQLException ex) 
            {
                Utilidades.Mensaje("ERROR","ResultSet Usuario: ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                        Utilidades.Mensaje("ERROR","Cerrar ResultSet WHERE Usuario".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_where != null)
            {
                try
                    {
                        preparacion_where.close();
                    }
                catch(SQLException ex)
                    {
                        Utilidades.Mensaje("ERROR","Cerrar Prepared WHERE Usuario".concat(ex.toString()),0);
                    }
            }
        }
        return usuario_buscado;
    }

    @Override
    public List<Usuario> getUsuariosActivos(boolean activo) {
      PreparedStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Usuario> usuario_list_activos= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareStatement(GETALLACTIVE);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             usuario_list_activos.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.Mensaje("ERROR","No hay RESULTSET Activos Usuarios ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                          Utilidades.Mensaje("ERROR","Error cerrar ResultSet SELECT ".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_select != null)
            {
                try
                    {
                        preparacion_select.close();
                    }
                catch(SQLException ex)
                    {
                         Utilidades.Mensaje("ERROR","Error cerrar Prepared SELECT ".concat(ex.toString()),0);
                    }
            }
        }
        return usuario_list_activos;
    }

    @Override
    public List<Usuario> getUsuariosInactivos(boolean activo) {
        PreparedStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Usuario> usuario_list_inactivos= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareStatement(GETALLINACTIVE);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             usuario_list_inactivos.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.Mensaje("ERROR","No hay RESULTSET Activos Usuarios ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                          Utilidades.Mensaje("ERROR","Error cerrar ResultSet SELECT ".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_select != null)
            {
                try
                    {
                        preparacion_select.close();
                    }
                catch(SQLException ex)
                    {
                         Utilidades.Mensaje("ERROR","Error cerrar Prepared SELECT ".concat(ex.toString()),0);
                    }
            }
        }
        return usuario_list_inactivos;
    }
    
    
    
    
}
