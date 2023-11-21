
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Distrito;
import pkg_utilidades.Utilidades;

public class MYSQLDistrito implements IDistrito{
    
    private final Connection connection;
    
    private final String GETALL="{CALL SP_LISTAR_DISTRITO()}";
    
    public MYSQLDistrito(Connection connection) {
        this.connection = connection;
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
              //  Utilidades.cerrarConnec(connection,"GETALL UPDATE");
        }
        return distrito_list;
    }
    
    
    private Distrito Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("pk_id_distrito");
          String nombre = resultado_data.getString("nombre_distrito");
          
          
          Distrito distrito=new Distrito(id,nombre);
                    
          return distrito;
    }

}
