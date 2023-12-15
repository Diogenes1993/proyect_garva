
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pkg_MYSQL.Interfaces.IDetalle_Usuario;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Detalle_Usuario;
import pkg_Modelo.Entidades.Empleado;
import pkg_utilidades.Calculos;
import pkg_utilidades.Utilidades;



public class MYSQLDetalle_Usuario implements IDetalle_Usuario{

    private Connection connection=null;

    private final String CREATE="{CALL SP_INSERTAR_DETALLE_USUARIO(?)}";
    private final String READ="{CALL SP_LISTAR_DETALLE_USUARIO()}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_DETALLE_USUARIO(?,?,?)}";
    private final String DELETE="{CALL SP_ELIMINAR_DETALLE_USUARIO(?,?)}";
    private final String READONE="{CALL SP_BUSCAR_DETALLE_USUARIO(?)}";
    
    public MYSQLDetalle_Usuario(Connection connection) 
    {
        this.connection=connection;
    }
        
  
    @Override
    public void Insertar(Detalle_Usuario detalle_usuario) throws IException{
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(CREATE);
         
         preparacion_insert.setString(1,detalle_usuario.getId_detalle_usuario().getId_empleado().getId() );
                  
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Detalle_Usuario no se inserto",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL INSERT DETALLE_USUARIO",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "INSERT DETALLE_USUARIO");
         Utilidades.cerrarCall(preparacion_insert, "INSERT DETALLE_USUARIO");
    }
    }

    @Override
    public void Actualizar(Detalle_Usuario detalle_usuario) throws IException{
         CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,detalle_usuario.getId_detalle_usuario().getId_empleado().getId());
         preparacion_insert.setDate(2 ,Calculos.convertFecha(detalle_usuario.getId_detalle_usuario().getFecha_entrada()));
         preparacion_insert.setDate(3,Calculos.convertFecha(detalle_usuario.getFecha_salida()));
                  
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Detalle_Usuario no se actualizo",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATE DETALLE_USUARIO",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "UPDATE DETALLE_USUARIO");
         Utilidades.cerrarCall(preparacion_insert, "UPDATE DETALLE_USUARIO");
    }
    }

    @Override
    public void Eliminar(Detalle_Usuario detalle_usuario) throws IException{
       CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(DELETE);
         
         preparacion_insert.setString(1,detalle_usuario.getId_detalle_usuario().getId_empleado().getId());
         preparacion_insert.setDate(2, Calculos.convertFecha(detalle_usuario.getId_detalle_usuario().getFecha_entrada()));
                           
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Detalle_Usuario no se elimino",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL DELETE DETALLE_USUARIO",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "DELETE DETALLE_USUARIO");
         Utilidades.cerrarCall(preparacion_insert, "DELETE DETALLE_USUARIO");
    }
    }

    @Override
    public List<Detalle_Usuario> ObtenerTodos() throws IException{
       CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Detalle_Usuario> usuario_Detalle_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(READ);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               usuario_Detalle_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET READ DETALLE_USUARIO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "READ DETALLE_USUARIO");
            Utilidades.cerrarCall(preparacion_where, "READ DETALLE_USUARIO");
        
        }
        return usuario_Detalle_data;
    }

    @Override
    public Detalle_Usuario ObtenerOne(Detalle_Usuario.IdDetalleUsuario detalle_id) throws IException{
      CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Detalle_Usuario empleado_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(READONE);
            preparacion_where.setString(1, detalle_id.getId_empleado().getId());
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               empleado_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE EMPLEADO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE EMPLEADO");
            Utilidades.cerrarCall(preparacion_where, "GETONE EMPLEADO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return empleado_buscado;
    }
    
      private Detalle_Usuario Data(ResultSet resultado_data) throws SQLException {
          String empleado=resultado_data.getString("empleado");
          String usuario = resultado_data.getString("Usuario");

          java.sql.Date Entrada = resultado_data.getDate("Entrada");
          java.util.Date Salida = resultado_data.getDate("Salida");
          
          
          Empleado empleados=new Empleado();
          empleados.setNombre(empleado);
          empleados.setUsuario(usuario);
          
         
          Detalle_Usuario detalle_usuario=new Detalle_Usuario();
          detalle_usuario.getId_detalle_usuario().setId_empleado(empleados);
          detalle_usuario.getId_detalle_usuario().setFecha_entrada(Entrada);
          detalle_usuario.setFecha_salida(Entrada);
          
          return detalle_usuario;
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorEmpleado(Detalle_Usuario.IdDetalleUsuario user) throws IException {
         CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
      List<Detalle_Usuario> data_Detalle =new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(READONE);
            preparacion_where.setString(1, user.getId_empleado().getId());
            resultado_data=preparacion_where.executeQuery();
            
             while(resultado_data.next())
            {
               data_Detalle.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET READONE DETALLE_USUARIO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "READONE DETALLE_USUARIO");
            Utilidades.cerrarCall(preparacion_where, "READONE DETALLE_USUARIO");
        
        }
        return data_Detalle;
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorFecha(Date fecha) throws IException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   

 
}


