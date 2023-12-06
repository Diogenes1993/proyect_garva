package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IPedido;
import pkg_Modelo.Entidades.Pedido;
import pkg_utilidades.Utilidades;

public class MYSQLPedido implements IPedido{
    private Connection connection;
    
    private final String INSERT="{CALL SP_INSERTAR_PEDIDO(?,?)}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_PEDIDO(?,?)}";
    private final String DELETE="{CALL SP_ELIMINAR_PEDIDO(?)}";
    private final String GETALL="{CALL SP_LISTAR_PEDIDO()}";
    private final String GETONE="{CALL SP_BUSCARONE_PEDIDO(?)}";
    private final String NEWCOD="{CALL SP_NUEVO_CODIGO_PE()}";

    public MYSQLPedido(Connection connection) {
        this.connection = connection;
    }
            
    
    @Override
    public void Insertar(Pedido pedido) throws IException {
    CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,pedido.getId());
         preparacion_insert.setString(2,pedido.getEstado());
         
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  PEDIDO no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT PEDIDO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "INSERT PEDIDO");
    } 
    }

    @Override
    public void Actualizar(Pedido pedido) throws IException {
    CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,pedido.getId());
         preparacion_insert.setString(2,pedido.getEstado());
         
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  PEDIDO no se actualizo",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("UPDATE PEDIDO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "UPDATE PEDIDO");
    } 
    }

    @Override
    public void Eliminar(Pedido pedido) throws IException {
       CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(DELETE);
         
         preparacion_insert.setString(1,pedido.getId());
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  PEDIDO no se elimino",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("DELETE PEDIDO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "DELETE PEDIDO");
    } 
    }

    @Override
    public List<Pedido> ObtenerTodos() throws IException {
         CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Pedido> pedido_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareCall(GETALL);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             pedido_list.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETALL PEDIDO", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETALL PEDIDO");
                Utilidades.cerrarCall(preparacion_select, "GETALL PEDIDO");
        }
        return pedido_list;
    }

    @Override
    public Pedido ObtenerOne(String id) throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Pedido pedido_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               pedido_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE PEDIDO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE PEDIDO");
            Utilidades.cerrarCall(preparacion_where, "GETONE PEDIDO");
        }
        return pedido_buscado;
    }

    @Override
    public String NewCod() throws IException {
        String cod = "PE000001";
	CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("000000");
				cod = "PE" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE ", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "NEWCODE PEDIDO");
                 Utilidades.cerrarCall(prepare_new_code, "NEWCODE PEDIDO");
		}
		return cod;
    }
    
    
          
    private Pedido Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("id");
          java.util.Date fecha = resultado_data.getDate("fecha");
          String estado = resultado_data.getString("estado");
          
          
          Pedido pedido=new Pedido(id,fecha,estado);
                    
          return pedido;
    }
}
