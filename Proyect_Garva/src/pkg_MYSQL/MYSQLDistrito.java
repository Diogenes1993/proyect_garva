
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Distrito;
import pkg_utilidades.Calculos;
import pkg_utilidades.Utilidades;

public class MYSQLDistrito implements IDistrito{
    
    private final Connection connection;
    
    private final String INSERT="{CALL SP_INSERTAR_DISTRITO(?,?)}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_DISTRITO(?,?)}";
    private final String NEWCOD="{CALL SP_NEW_DISTRITO()}";
    private final String GETALL="{CALL SP_LISTAR_DISTRITO()}";
    private final String GETONE="{CALL SP_BUSCAR_DISTRITO(?)}";
    private final String DELETEONE="{CALL SP_ELIMINAR_DISTRITO(?)}";
    
    public MYSQLDistrito(Connection connection) {
        this.connection = connection;
    }
   

    @Override
    public void Insertar(Distrito distrito) throws IException {
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,distrito.getId());
         preparacion_insert.setString(2,distrito.getNombre());
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  distrito no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT DISTRITO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "INSERT DISTRITO");
        Utilidades.cerrarCall(preparacion_insert, "INSERT DISTRITO");
    }  
    }

    @Override
    public void Actualizar(Distrito distrito) throws IException {
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,distrito.getId());
         preparacion_insert.setString(2,distrito.getNombre());
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  distrito no se actualizo",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("UPDATE DISTRITO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "UPDATE DISTRITO");
        Utilidades.cerrarCall(preparacion_insert, "UPDATE DISTRITO");
    }  
    }

    @Override
    public void Eliminar(Distrito distrito) throws IException {
        CallableStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareCall(DELETEONE);
         
         preparacion_delete.setString(1,distrito.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el Distrito  no se Elimino", new SQLException(),"MENSAJE",0);
                }
            
    }catch (SQLException ex) 
    {
     Utilidades.manejarError(" DELETE DISTRITO", ex,"ERROR",0);
     
    }finally
    {
        Utilidades.cerrarCall(preparacion_delete, "DELETE DISTRITO");
      //  Utilidades.cerrarConnec(connection,"CLIENTE DELETE");
    }
    }

    @Override
    public Distrito ObtenerOne(String id) throws IException {
      CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Distrito distrito_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               distrito_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE DISTRITO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE DISTRITO");
            Utilidades.cerrarCall(preparacion_where, "GETONE DISTRITO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return distrito_buscado;
    }
    
     
    @Override
    public List<Distrito> ObtenerTodos() throws IException{
         CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Distrito> distrito_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareCall(GETALL);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             distrito_list.add(Data(resultado_data));  
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
        }
        return distrito_list;
    }
    
    
    private Distrito Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("pk_id_distrito");
          String nombre = resultado_data.getString("nombre_distrito");
          
          
          Distrito distrito=new Distrito(id,nombre);
                    
          return distrito;
    }
    
    @Override
       public String newCodigo() throws IException {
         String cod = "DI000001";
         CallableStatement prepare_new_code=null;
         ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("000000");
				cod = "DI" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
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

}
