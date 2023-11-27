
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Empleado;
import pkg_Modelo.Entidades.Rol;
import pkg_utilidades.Calculos;
import pkg_utilidades.Utilidades;

public class MYSQLEmpleado implements IEmpleado{
private Connection connection=null;

private final String INSERT="{CALL SP_INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?)}";
private final String UPDATE="{CALL SP_ACTUALIZAR_EMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?)}";
private final String DELETEES="{CALL SP_ELIMINAR_ES_EMPLEADO(?)}";
private final String DELETEONE="{CALL SP_ELIMINAR_EMPLEADO(?)}";

private final String GETALL="{CALL SP_LISTAR_EMPLEADO_T()}";
private final String GETUSER="{CALL SP_OBTENER_USER_EMPLEADO(?)}";
private final String GETONE="{CALL SP_BUSCAR_ID_EMPLEADO(?)}";

private final String GETALLACTIVE="{CALL SP_OBTENER_EMPLEADO_ACTIVO()}";
private final String GETALLINACTIVE="{CALL SP_OBTENER_EMPLEADO_INACTIVO()}";

private final String GETIDS="{CALL SP_BUSCAR_IDS_EMPLEADO(?)} ";
private final String GETNOMAPE="{CALL SP_BUSCAR_NOMBRE_APELLIDO_EMPLEADO(?)}";
private final String GETDISTRITO="{CALL SP_BUSCAR_DISTRITO_EMPLEADO(?)}";

private final String NEWCOD="{ CALL SP_BUSCAR_NUEVO_CODIGO_E()}";

    public MYSQLEmpleado(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void Insertar(Empleado empleado) throws IException{
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,empleado.getId());
         preparacion_insert.setString(2,empleado.getNombre());
         preparacion_insert.setString(3,empleado.getApellido());
         preparacion_insert.setString(4,empleado.getDistrito());
         preparacion_insert.setString(5,empleado.getDireccion());
         preparacion_insert.setString(6,empleado.getTelefono());
         preparacion_insert.setString(7,empleado.getEmail());
         preparacion_insert.setDate(8,Calculos.convertFecha(empleado.getFecha_contrato()));
         preparacion_insert.setString(9,empleado.getUsuario());
         preparacion_insert.setString(10,empleado.getContra());
         preparacion_insert.setString(11,empleado.getEstado());
         preparacion_insert.setString(12,empleado.getRol().getId());
         
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  Empleado no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT EMPLEADO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "INSERT EMPLEADO");
        Utilidades.cerrarCall(preparacion_insert, "INSERT EMPLEADO");
    }  
    }

    
    @Override
    public void Actualizar(Empleado empleado) throws IException{
     CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,empleado.getId());
         preparacion_insert.setString(2,empleado.getNombre());
         preparacion_insert.setString(3,empleado.getApellido());
         preparacion_insert.setString(4,empleado.getDistrito());
         preparacion_insert.setString(5,empleado.getDireccion());
         preparacion_insert.setString(6,empleado.getTelefono());
         preparacion_insert.setString(7,empleado.getEmail());
         preparacion_insert.setDate(8,Calculos.convertFecha(empleado.getFecha_contrato()));
         preparacion_insert.setString(9,empleado.getUsuario());
         preparacion_insert.setString(10,empleado.getContra());
         preparacion_insert.setString(11,empleado.getEstado());
         preparacion_insert.setString(12,empleado.getRol().getId());
         
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  Empleado no se actualizo",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("UPDATE EMPLEADO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "UPDATE EMPLEADO");
        Utilidades.cerrarCall(preparacion_insert, "UPDATE EMPLEADO");
    }  
    }

    @Override
    public void Eliminar(Empleado empleado) throws IException{
           CallableStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareCall(DELETEONE);
         
         preparacion_delete.setString(1,empleado.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el Empleado no se Elimino", new SQLException(),"MENSAJE",0);
                }
            
    }catch (SQLException ex) 
    {
     Utilidades.manejarError("Error en SQL DELETE Empleado", ex,"ERROR",0);
     
    }finally
    {
        Utilidades.cerrarCall(preparacion_delete, "DELETE Empleado");
      //  Utilidades.cerrarConnec(connection,"CLIENTE DELETE");
    }
    }

     private Empleado Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("id");
          String nombre = resultado_data.getString("nombre");
          String apellido = resultado_data.getString("apellidos");
          String distrito = resultado_data.getString("distrito");
          String direccion = resultado_data.getString("direccion");
          String telefono = resultado_data.getString("telefono");
          String correo = resultado_data.getString("email");
          java.util.Date ingreso = resultado_data.getDate("Ingreso");
          String usuario = resultado_data.getString("usuario");
          String contra = resultado_data.getString("contra");
          String estado= resultado_data.getString("estado");
          Rol rol=new Rol();
          rol.setRol(resultado_data.getString("rol"));
          rol.setRuta(resultado_data.getString("ruta"));
         
          Empleado empleado=new Empleado(id,nombre,apellido,distrito,direccion,telefono,correo,ingreso,usuario,contra,estado,rol);
                    
          return empleado;
    }
    @Override
    public List<Empleado> ObtenerTodos() throws IException{
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETALL);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_data.add(Data(resultado_data));
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
        return empleado_data;
    }

    @Override
    public Empleado ObtenerOne(String id) throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Empleado empleado_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
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

    @Override
    public List<Empleado> getUsuariosActivos(boolean activo) throws IException {
          CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_activo = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETALLACTIVE);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_activo.add(Data(resultado_data));
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
        return empleado_activo;
    }

    @Override
    public List<Empleado> getUsuariosInactivos(boolean activo) throws IException {
          CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_activo = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETALLINACTIVE);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_activo.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETALLINACTIVE EMPLEADO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETALLINACTIVE EMPLEADO");
            Utilidades.cerrarCall(preparacion_where, "GETALLINACTIVE EMPLEADO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return empleado_activo;
    }

    @Override
    public Empleado getDataUsuario(String data) throws IException {
     CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Empleado empleado_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETUSER);
            preparacion_where.setString(1, data);
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

  
    @Override
    public String NewCodigo() throws IException {
      String cod = "EM0001";
	CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("0000");
				cod = "EM" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE ", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "NEWCODE EMPLEADO");
                 Utilidades.cerrarCall(prepare_new_code, "NEWCODE EMPLEADO");
              //      Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
		}
		return cod;
    }

    @Override
    public List<Empleado> BuscarIds(String id) throws IException {
          CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_activo = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETIDS);
            preparacion_where.setString(1,id);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_activo.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETIDS EMPLEADO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETIDS EMPLEADO");
            Utilidades.cerrarCall(preparacion_where, "GETIDS EMPLEADO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return empleado_activo;
    }

    @Override
    public List<Empleado> BuscarNomApe(String nombre) throws IException {
      CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_activo = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETNOMAPE);
            preparacion_where.setString(1,nombre);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_activo.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETNOMAPE EMPLEADO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETNOMAPE EMPLEADO");
            Utilidades.cerrarCall(preparacion_where, "GETNOMAPE EMPLEADO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return empleado_activo;
    }

    @Override
    public List<Empleado> BuscarDistrito(String distrito) throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Empleado> empleado_activo = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETDISTRITO);
            preparacion_where.setString(1,distrito);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               empleado_activo.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETDISTRITO EMPLEADO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETDISTRITO EMPLEADO");
            Utilidades.cerrarCall(preparacion_where, "GETDISTRITO EMPLEADO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return empleado_activo;
    }
    
    
}
