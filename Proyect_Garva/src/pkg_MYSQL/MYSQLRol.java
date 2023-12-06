package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IRol;
import pkg_Modelo.Entidades.Rol;
import pkg_utilidades.Utilidades;


public class MYSQLRol implements IRol {
    
    private final Connection connection;
    
     private final String INSERT="{CALL SP_INSERTAR_ROL(?,?,?)}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_ROL(?,?,?)}";
    private final String NEWCOD="{CALL SP_NEW_ROL()}";
    private final String GETALL="{CALL SP_LISTAR_ROL()}";
    private final String GETONE="{CALL SP_BUSCAR_ROL(?)}";
    private final String DELETEONE="{CALL SP_ELIMINAR_DISTRITO(?)}";
    
    
    public MYSQLRol(Connection connection) {
        this.connection=connection;
    }
   
    @Override
    public void Insertar(Rol rol) throws IException {
    CallableStatement preparacion_insert=null;
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,rol.getId());
         preparacion_insert.setString(2,rol.getRol());
         preparacion_insert.setString(3,rol.getRuta());
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  rol no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT ROL",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "INSERT ROL");
    }  
    
    }

    @Override
    public void Actualizar(Rol rol) throws IException {
    CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,rol.getId());
         preparacion_insert.setString(2,rol.getRol());
         preparacion_insert.setString(3,rol.getRuta());
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  rol no se actualizo",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("UPDATE ROL",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "UPDATE ROL");
    }  
    }

    @Override
    public void Eliminar(Rol rol) throws IException {
          CallableStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareCall(DELETEONE);
         
         preparacion_delete.setString(1,rol.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el rol  no se Elimino", new SQLException(),"MENSAJE",0);
                }
            
    }catch (SQLException ex) 
    {
     Utilidades.manejarError(" DELETE ROL", ex,"ERROR",0);
     
    }finally
    {
        Utilidades.cerrarCall(preparacion_delete, "DELETE ROL");
    }
    }

    @Override
    public List<Rol> ObtenerTodos() throws IException {
        CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Rol> rol_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareCall(GETALL);
           
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             rol_list.add(Data(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETALL ROL", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETALL ROL");
                Utilidades.cerrarCall(preparacion_select, "GETALL ROL");
        }
        return rol_list;
    }

    @Override
    public Rol ObtenerOne(String id) throws IException {
     CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Rol rol_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               rol_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE ROL ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE ROL");
            Utilidades.cerrarCall(preparacion_where, "GETONE ROL");
        }
        return rol_buscado;
    }
    
    @Override
    public String newCodigo() throws IException {
        String cod = "R001";
	CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
				DecimalFormat formato_decimal = new DecimalFormat("000");
				cod = "R" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); 
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE ", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "NEWCODE ROL");
                 Utilidades.cerrarCall(prepare_new_code, "NEWCODE ROL");
		}
		return cod;
    }
    
      
    private Rol Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("pk_id_rol");
          String nombre = resultado_data.getString("nombre_rol");
          String ruta = resultado_data.getString("ruta_image");
          
          
          Rol rol=new Rol(id,nombre,ruta);
                    
          return rol;
    }
}
