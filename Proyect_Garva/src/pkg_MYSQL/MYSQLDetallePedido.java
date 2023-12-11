
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IDetalle_Pedido;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Detalle_Pedido;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Pedido;
import pkg_utilidades.Utilidades;


public class MYSQLDetallePedido implements IDetalle_Pedido{

    private Connection connection;
    
    private final String INSERT="{CALL SP_INSERTAR_DETALLE_P(?,?,?)}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_DETALLE_P(?,?,?)}";
    private final String DELETE="{CALL SP_ELIMINAR_DETALLE_P(?,?,?)}";
    private final String GETTABLE="{CALL SP_LISTAR_DETALLE_PEDIDO_GENERAR(?)}";
    private final String GETONE="{CALL SP_LISTARONE_DETALLE_P(?,?)}";
    
    private String GETSUMVENTA="{CALL SP_LISTAR_DETALLE_PEDIDO_SUMA(?)}";
    private final String GETALL="";

    public MYSQLDetallePedido(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void Insertar(Detalle_Pedido detalle_pedido) throws IException {
      CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,detalle_pedido.getId_pedido().getId());
         preparacion_insert.setString(2,detalle_pedido.getId_menu().getId());
         preparacion_insert.setInt(3,detalle_pedido.getCantidad());
         
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  DETALLEPEDIDO no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("INSERT DETALLEPEDIDO",ex,"ERROR",0);
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "INSERT DETALLEPEDIDO");
        
    }     
    }

    @Override
    public void Actualizar(Detalle_Pedido detalle_pedido) throws IException {
         CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
       
         preparacion_insert.setString(1,detalle_pedido.getId_pedido().getId());
         preparacion_insert.setString(2,detalle_pedido.getId_menu().getId());
         preparacion_insert.setInt(3,detalle_pedido.getCantidad());
  
         
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  DETALLEPEDIDO no se actualizo",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("UPDATE DETALLEPEDIDO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "UPDATE DETALLEPEDIDO");
    }     
    }

    @Override
    public void Eliminar(Detalle_Pedido detalle_pedido) throws IException {
         CallableStatement preparacion_insert=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(DELETE);
         
         preparacion_insert.setString(1,detalle_pedido.getId_pedido().getId());
         preparacion_insert.setString(2,detalle_pedido.getId_menu().getId());
         preparacion_insert.setInt(3,detalle_pedido.getCantidad());
       
               
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("El  DETALLEPEDIDO no se elimino",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT DETALLEPEDIDO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarCall(preparacion_insert, "INSERT DETALLEPEDIDO");
    }     
    }

    @Override
    public List<Detalle_Pedido> ObtenerTodos() throws IException {
      return null;
    }

    @Override
    public Detalle_Pedido ObtenerOne(String pedido__) throws IException {
        CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        Detalle_Pedido pedido_buscado= null;
        try
        {
            String[] ped=pedido__.split(",");
            preparacion_select=connection.prepareCall(GETONE);
            
           preparacion_select.setString(1,ped[0]);
           preparacion_select.setString(2,ped[1]);
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             pedido_buscado=DataReal(resultado_data);  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETONE DETALLEPEDIDO", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETONE DETALLEPEDIDO");
                Utilidades.cerrarCall(preparacion_select, "GETONE DETALLEPEDIDO");
        }
        return pedido_buscado;
    }

    @Override
    public List<Detalle_Pedido> ObtenerTable(String pedido) throws IException {
        CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        List<Detalle_Pedido> pedido_list= new ArrayList<>();
        try
        {
            preparacion_select=connection.prepareCall(GETTABLE);
           preparacion_select.setString(1,pedido);
            resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             pedido_list.add(DataTable(resultado_data));  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETALL DETALLEPEDIDO", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETALL DETALLEPEDIDO");
                Utilidades.cerrarCall(preparacion_select, "GETALL DETALLEPEDIDO");
        }
        return pedido_list;
    }
    
     private Detalle_Pedido DataTable(ResultSet resultado_data) throws SQLException {
         int cantidad=resultado_data.getInt("cantidad");
          String id_menu = resultado_data.getString("id_menu");
          String menu = resultado_data.getString("menu");
          double precio = resultado_data.getDouble("precio");
          String importe = resultado_data.getString("importe");
          
          Menu menu_ = new Menu();
          Pedido pedido_=new Pedido();
          menu_.setId(id_menu);
          menu_.setNombre(menu);
          menu_.setPrecio(precio);
          pedido_.setId(importe);
          
          Detalle_Pedido pedido=new Detalle_Pedido(pedido_,menu_,cantidad);
                    
          return pedido;
    }
     
     
     private Detalle_Pedido DataReal(ResultSet resultado_data) throws SQLException {
         int cantidad=resultado_data.getInt("cantidad");
          String id_menu = resultado_data.getString("menu");
          
          String pedido_id = resultado_data.getString("id");
          
          Menu menu_ = new Menu();
          Pedido pedido_=new Pedido();
          menu_.setId(id_menu);
          pedido_.setId(pedido_id);
          
          Detalle_Pedido pedido=new Detalle_Pedido(pedido_,menu_,cantidad);
                    
          return pedido;
    }
     
    @Override
     public String ObtenerTotal(String pedido) throws IException{
          CallableStatement preparacion_select = null;
        ResultSet resultado_data = null;
        
        String suma= null;
        try
        {
          preparacion_select=connection.prepareCall(GETSUMVENTA);
            
           preparacion_select.setString(1,pedido);
           resultado_data=preparacion_select.executeQuery();
            
            while(resultado_data.next())
            {
             suma=Data(resultado_data);  
            }
            
        } 
         catch (SQLException ex) 
            {
                 Utilidades.manejarError("GETSUMVENTA DETALLEPEDIDO", ex,"ERROR",0);
            }
        finally
        {
                Utilidades.cerrarResul(resultado_data, "GETSUMVENTA DETALLEPEDIDO");
                Utilidades.cerrarCall(preparacion_select, "GETSUMVENTA DETALLEPEDIDO");
        }
        return   suma;
             
     }
      private String  Data(ResultSet resultado_data) throws SQLException {
         String Suma =resultado_data.getString("suma")==null?"S/.00.00":"S/. "+resultado_data.getString("suma");
          return Suma;
    }
    
}
