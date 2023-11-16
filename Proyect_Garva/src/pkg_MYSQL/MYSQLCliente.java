package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Cliente;
import pkg_utilidades.Utilidades;

public class MYSQLCliente implements ICliente {
  private final String INSERT="INSERT INTO CLIENTE(NOMBRE_CLIENTE,APELLIDO_CLIENTE,DIRECCION_CLIENTE,TELEFONO_CLIENTE,CORREO_CLIENTE) VALUES(?,?,?,?,?)";
  private final String UPDATE="UPDATE CLIENTE SET NOMBRE_CLIENTE=?,APELLIDO_CLIENTE=?,DIRECCION_CLIENTE=?,TELEFONO_CLIENTE=?,CORREO_CLIENTE=?  WHERE PK_ID_CLIENTE= ?";
  private final String DELETEONE="DELETE FROM CLIENTE WHERE PK_ID_CLIENTE= ?";
  private final String GETALL ="SELECT PK_ID_CLIENTE,NOMBRE_CLIENTE,APELLIDO_CLIENTE,DIRECCION_CLIENTE,TELEFONO_CLIENTE,CORREO_CLIENTE FROM CLIENTE";
  private final String GETONE=GETALL+" WHERE PK_ID_CLIENTE= ?";
    
     private final Connection connection;
    
    public MYSQLCliente(Connection connection)
    {
        this.connection=connection;
    }
    
    @Override
    public void Insertar(Cliente cliente) throws IException  {
        PreparedStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
         
         preparacion_insert.setString(1,cliente.getNombre() );
         preparacion_insert.setString(2,cliente.getApellido() );
         preparacion_insert.setString(3,cliente.getDireccion() );
         preparacion_insert.setString(4,cliente.getTelefono() );
         preparacion_insert.setString(5,cliente.getCorreo() );
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Cliente no se inserto", new SQLException(),"MENSAJE",1);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
            if(result_clave.next())
                {
                    cliente.setId(result_clave.getLong(1));
                }
            else
            {
                 Utilidades.manejarError("No se puede asignar Id a este CLIENTE", new SQLException(),"MENSAJE",1);
            }
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL INSERT CLIENTE", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarResul(result_clave,"CLIENTE INSERT");
                  Utilidades.cerrarPrepare(preparacion_insert,"CLIENTE INSERT");
    }
    }

    @Override
    public void Actualizar(Cliente cliente) throws IException{
          PreparedStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(UPDATE);
         
         preparacion_insert.setString(1,cliente.getNombre() );
         preparacion_insert.setString(2,cliente.getApellido() );
         preparacion_insert.setString(3,cliente.getDireccion() );
         preparacion_insert.setString(4,cliente.getTelefono() );
         preparacion_insert.setString(5,cliente.getCorreo() );
         preparacion_insert.setLong(6,cliente.getId() );
         
            if(preparacion_insert.executeUpdate()==0)
                {
                     Utilidades.manejarError("Espera el Cliente no se actualizo", new SQLException(),"MENSAJE",1);
                }
           
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL UPDATE CLIENTE", ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarPrepare(preparacion_insert,"CLIENTE UPDATE");
    }
    }

    
    @Override
    public void Eliminar(Cliente cliente) throws IException{
          PreparedStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareStatement(DELETEONE);
         
         preparacion_delete.setLong(1,cliente.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.manejarError("Espera el Cliente no se Elimino", new SQLException(),"MENSAJE",0);
                }
            
    }catch (SQLException ex) 
    {
     Utilidades.manejarError("Error en SQL DELETE CLIENTE", ex,"ERROR",0);
     
    }finally
    {
        Utilidades.cerrarPrepare(preparacion_delete, "DELETE CLIENTE");
    }
    }
    
       private Cliente Data(ResultSet resultado_data) throws SQLException
    {
          String nombre = resultado_data.getString("NOMBRE_CLIENTE");
          String apellido = resultado_data.getString("APELLIDO_CLIENTE");
          String direccion = resultado_data.getString("DIRECCION_CLIENTE");
          String telefono = resultado_data.getString("TELEFONO_CLIENTE");
          String correo = resultado_data.getString("CORREO_CLIENTE");
          
          Cliente cliente=new Cliente(nombre,apellido,direccion,telefono,correo);
          cliente.setId(resultado_data.getLong("PK_ID_CLIENTE"));
          
          return cliente;
    }

       
    @Override
    public List<Cliente> ObtenerTodos() throws IException{
        PreparedStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Cliente> cliente_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareStatement(GETALL);
           
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
                Utilidades.cerrarPrepare(preparacion_select, "GETALL CLIENTE");
        }
        return cliente_list;
    }

    
    @Override
    public Cliente ObtenerOne(Long id) throws IException{
         PreparedStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        Cliente cliente_buscado = null;
        try
        {
            preparacion_where=connection.prepareStatement(GETONE);
            preparacion_where.setLong(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               cliente_buscado=Data(resultado_data);
            }else
            {
                Utilidades.manejarError("No existe el CLIENTE  buscado: ", new SQLException(),"MENSAJE",1);
            }
            
        } 
         catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE CLIENTE");
            Utilidades.cerrarPrepare(preparacion_where, "GETONE CLIENTE");
           
        }
        return cliente_buscado;
    }
    
}
