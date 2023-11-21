package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Cliente;
import pkg_utilidades.Utilidades;

public class MYSQLCliente implements ICliente {
  
     
  private final String INSERT="{CALL SP_INSERTAR_CLIENTE(?,?,?,?,?,?)}";
  private final String UPDATE="{CALL SP_ACTUALIZAR_CLIENTE(?,?,?,?,?,?)}";
  private final String DELETEONE="{CALL SP_ELIMINAR_CLIENTE(?)}";
  private final String GETALL ="{CALL SP_LISTAR_CLIENTE()}";
  
  private final String NEWCODE ="{CALL SP_NUEVO_CODIGO_C()}";
  private final String GETONE="{CALL SP_BUSCAR_ID_CLIENTE(?)}";
  private final String GETIDS="{CALL SP_BUSCAR_IDS_CLIENTE(?)}";
  private final String GETNOMAPE="{CALL SP_BUSCAR_NOMBRE_APELLIDO_CLIENTE(?)}";
  private final String GETDIS="{CALL SP_BUSCAR_DISTRITO_CLIENTE(?)}";
    
     private final Connection connection;
    
    public MYSQLCliente(Connection connection)
    {
        this.connection=connection;
    }
    
    @Override
    public void Insertar(Cliente cliente) throws IException  {
        CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,cliente.getId());
         preparacion_insert.setString(2,cliente.getNombre() );
         preparacion_insert.setString(3,cliente.getApellido() );
         preparacion_insert.setString(4,cliente.getDistrito() );
         preparacion_insert.setString(5,cliente.getTelefono() );
         preparacion_insert.setString(6,cliente.getCorreo() );
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Cliente no se inserto", new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL INSERT CLIENTE", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarCall(preparacion_insert,"CLIENTE INSERT");
               //   Utilidades.cerrarConnec(connection,"CLIENTE INSERT");
    }
    }
    

    @Override
    public void Actualizar(Cliente cliente) throws IException{
          CallableStatement preparacion_update=null;
    
    try
    {
         preparacion_update=connection.prepareCall(UPDATE);
         
         preparacion_update.setString(1,cliente.getId() );
         preparacion_update.setString(2,cliente.getNombre() );
         preparacion_update.setString(3,cliente.getApellido() );
         preparacion_update.setString(4,cliente.getDistrito());
         preparacion_update.setString(5,cliente.getTelefono() );
         preparacion_update.setString(6,cliente.getCorreo() );
                  
            if(preparacion_update.executeUpdate()==0)
                {
                     Utilidades.manejarError("Espera el Cliente no se actualizo", new SQLException(),"MENSAJE",1);
                }
           
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL UPDATE CLIENTE", ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_update,"CLIENTE UPDATE");
       // Utilidades.cerrarConnec(connection,"CLIENTE UPDATE");
    }
    }

    @Override
    public void Eliminar(Cliente cliente) throws IException{
         CallableStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareCall(DELETEONE);
         
         preparacion_delete.setString(1,cliente.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el Cliente no se Elimino", new SQLException(),"MENSAJE",0);
                }
            
    }catch (SQLException ex) 
    {
     Utilidades.manejarError("Error en SQL DELETE CLIENTE", ex,"ERROR",0);
     
    }finally
    {
        Utilidades.cerrarCall(preparacion_delete, "DELETE CLIENTE");
      //  Utilidades.cerrarConnec(connection,"CLIENTE DELETE");
    }
    }

    private Cliente Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("pk_id_cliente");
          String nombre = resultado_data.getString("nombre_cliente");
          String apellido = resultado_data.getString("apellido_cliente");
          String distrito = resultado_data.getString("nombre_distrito");
          String telefono = resultado_data.getString("telefono_cliente");
          String correo = resultado_data.getString("email_cliente");
          
          Cliente cliente=new Cliente(id,nombre,apellido,distrito,telefono,correo);
                    
          return cliente;
    }

       
    @Override
    public List<Cliente> ObtenerTodos() throws IException{
        CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Cliente> cliente_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareCall(GETALL);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             cliente_list.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETALL CLIENTE", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETALL CLIENTE");
                Utilidades.cerrarCall(preparacion_select, "GETALL CLIENTE");
             //   Utilidades.cerrarConnec(connection,"GETALL UPDATE");
        }
        return cliente_list;
    }
   
   
  @Override
  public Cliente ObtenerOne(String id) throws IException{
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Cliente cliente_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               cliente_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE CLIENTE");
            Utilidades.cerrarCall(preparacion_where, "GETONE CLIENTE");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return cliente_buscado;
    }

    @Override
    public String NewCodigo() throws IException{
        String codCliente = "CL000001";
	CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCODE);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("000000");
				codCliente = "CL" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE ", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "GETONE CLIENTE");
                 Utilidades.cerrarCall(prepare_new_code, "GETONE CLIENTE");
              //      Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
		}
		return codCliente;
    }
    
    @Override
    public List<Cliente> BuscarIds(String id) throws IException{
        CallableStatement preparacion_select_id = null;
        ResultSet resultado_data = null;
        
        List<Cliente> cliente_list_ids= new ArrayList<>();
        try
        {
            preparacion_select_id=connection.prepareCall(GETIDS);
            preparacion_select_id.setString(1, id);
            resultado_data=preparacion_select_id.executeQuery();
            
            while(resultado_data.next())
            {
             cliente_list_ids.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETIDS CLIENTE", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETIDS CLIENTE");
                Utilidades.cerrarCall(preparacion_select_id, "GETIDS CLIENTE");
    //            Utilidades.cerrarConnec(connection,"GETIDS UPDATE");
        }
        return cliente_list_ids;
    }
    
    @Override
    public List<Cliente> BuscarNomApe(String nombre) throws IException{
    CallableStatement preparacion_select_nomape = null;
        ResultSet resultado_data = null;
        
        List<Cliente> cliente_list_ids= new ArrayList<>();
        try
        {
            preparacion_select_nomape=connection.prepareCall(GETNOMAPE);
           preparacion_select_nomape.setString(1,nombre);
            resultado_data=preparacion_select_nomape.executeQuery();
            
            while(resultado_data.next())
            {
             cliente_list_ids.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETNOMAPE CLIENTE", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETNOMAPE CLIENTE");
                Utilidades.cerrarCall(preparacion_select_nomape, "GETNOMAPE CLIENTE");
          //      Utilidades.cerrarConnec(connection,"GETNOMAPE UPDATE");
        }
        return cliente_list_ids;
        
    }
    
    @Override
    public List<Cliente> BuscarDistrito(String distrito) throws IException{
    CallableStatement preparacion_select_distrito = null;
        ResultSet resultado_data = null;
        
        List<Cliente> cliente_list_distri= new ArrayList<>();
        try
        {
            preparacion_select_distrito=connection.prepareCall(GETDIS);
            preparacion_select_distrito.setString(1,distrito);
            resultado_data=preparacion_select_distrito.executeQuery();
            
            while(resultado_data.next())
            {
             cliente_list_distri.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETDISTRITO CLIENTE", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETDISTRITO CLIENTE");
                Utilidades.cerrarCall(preparacion_select_distrito, "GETDISTRITO CLIENTE");
      //          Utilidades.cerrarConnec(connection,"GETDISTRITO UPDATE");
        }
        return cliente_list_distri;
      }

}
