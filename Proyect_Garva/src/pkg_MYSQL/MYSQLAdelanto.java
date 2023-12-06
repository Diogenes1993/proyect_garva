package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Adelanto;
import pkg_utilidades.Utilidades;
import pkg_MYSQL.Interfaces.IAdelanto;
import pkg_utilidades.Calculos;

public class MYSQLAdelanto implements IAdelanto {

    private static final String INSERT ="{CALL SP_INSERTAR_ADELANTO(?,?,?,?)}";
    private static final String UPDATE ="{CALL SP_ACTUALIZAR_ADELANTO(?,?,?,?)}";
    private static final String DELETE ="{CALL SP_ELIMINAR_ADELANTO(?)}";
    private static final String GETALL ="{CALL SP_LISTAR_ADELANTO()}";
    private static final String NEWCOD ="{CALL SP_BUSCAR_NUEVO_CODIGO_A()}";
    
    private static final String GETONE ="{CALL SP_BUSCAR_ADELANTO_ID(?)}";
    private static final String GETONES ="{CALL SP_BUSCAR_ADELANTO_IDS(?)}";
    private static final String GETCLIENTES ="{CALL SP_BUSCAR_ADELANTO_XC(?)}";
    private static final String GETEMPLEADOS ="{CALL SP_BUSCAR_ADELANTO_XE(?)}";
    private static final String GETFECHA ="{CALL SP_BUSCAR_ADELANTO_FECHA(?,?)}";
    
    
    private Connection connection;
    public MYSQLAdelanto(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insertar(Adelanto adelanto) throws IException{
    CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,adelanto.getId());
         preparacion_insert.setDouble(2,adelanto.getMonto() );
         preparacion_insert.setString(3,adelanto.getId_cliente());
         preparacion_insert.setString(4,adelanto.getId_empleado());
        
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el ADELANTO no se inserto", new SQLException(),"MENSAJE",1);
                }
          
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL INSERT ADELANTO", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarCall(preparacion_insert,"ADELANTO INSERT");
    }
    }

    @Override
    public void Actualizar(Adelanto adelanto) throws IException {
      CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,adelanto.getId());
         preparacion_insert.setDouble(2,adelanto.getMonto() );
         preparacion_insert.setString(3,adelanto.getId_cliente());
         preparacion_insert.setString(3,adelanto.getId_empleado());
        
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el ADELANTO no se actualizo", new SQLException(),"MENSAJE",1);
                }
          
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL UPDATE ADELANTO", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarCall(preparacion_insert,"ADELANTO UPDATE");
    }
    }

    @Override
    public void Eliminar(Adelanto adelanto) throws IException {
         CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(DELETE);
         
         preparacion_insert.setString(1,adelanto.getId());
        
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el ADELANTO no se elimino", new SQLException(),"MENSAJE",1);
                }
          
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL DELETE ADELANTO", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarCall(preparacion_insert,"ADELANTO DELETE");
    }
    }

    @Override
    public List<Adelanto> ObtenerTodos() throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Adelanto> adelanto_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETALL);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               adelanto_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE ADELANTO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE ADELANTO");
            Utilidades.cerrarCall(preparacion_where, "GETONE ADELANTO");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return adelanto_data;
    }

    @Override
    public Adelanto ObtenerOne(String id) throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Adelanto adelanto_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               adelanto_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE ADELANTO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE ADELANTO");
            Utilidades.cerrarCall(preparacion_where, "GETONE ADELANTO");
        }
        return adelanto_buscado;
    }
    
    @Override
    public String NewCodigo() throws IException {
      String cod = "AD000001";
	CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("000000");
				cod = "AD" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE ", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "NEWCODE ADELANTO");
                 Utilidades.cerrarCall(prepare_new_code, "NEWCODE ADELANTO");
              }
		return cod;
    }
    
          
    private Adelanto Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("pk_id_adelanto");
          double monto = resultado_data.getDouble("monto_adelanto");
          java.util.Date fecha = resultado_data.getDate("fecha_adelanto");
          String cliente =resultado_data.getString("cliente");
          String empleado =resultado_data.getString("atencion");
          
          
          Adelanto distrito=new Adelanto(id,monto,fecha,cliente,empleado);
                    
          return distrito;
    }

    @Override
    public List<Adelanto>getBuscarXEmpleado(String id_empleado)throws IException {
         CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Adelanto> adelanto_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETEMPLEADOS);
            preparacion_where.setString(1,id_empleado);

            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               adelanto_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETEMPLEADOS ADELANTO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETEMPLEADOS ADELANTO");
            Utilidades.cerrarCall(preparacion_where, "GETEMPLEADOS ADELANTO");
        }
        return adelanto_data;
    }

    @Override
    public List<Adelanto> getBuscarXCliente(String id_cliente) throws IException{
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Adelanto> adelanto_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETCLIENTES);
            preparacion_where.setString(1,id_cliente);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               adelanto_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETCLIENTES ADELANTO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETCLIENTES ADELANTO");
            Utilidades.cerrarCall(preparacion_where, "GETCLIENTES ADELANTO");
        
        }
        return adelanto_data;
    }
    
    @Override
    public List<Adelanto> getBuscarXFecha(java.util.Date principio,java.util.Date fin)throws IException{
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Adelanto> adelanto_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETFECHA);
            preparacion_where.setDate(1,Calculos.convertFecha(principio));
            preparacion_where.setDate(2,Calculos.convertFecha(fin));
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               adelanto_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETFECHA ADELANTO ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETFECHA ADELANTO");
            Utilidades.cerrarCall(preparacion_where, "GETFECHA ADELANTO");
        
        }
        return adelanto_data;
    }
}
