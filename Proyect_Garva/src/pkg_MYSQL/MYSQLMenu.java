package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_Modelo.Entidades.Menu;
import pkg_utilidades.Utilidades;


public class MYSQLMenu implements IMenu{

    private Connection connection;
    
    private final String INSERT="{CALL SP_INSERTAR_MENU(?,?,?,?,?,?)}";
    private final String UPDATE="{CALL SP_ACTUALIZAR_MENU(?,?,?,?,?,?)}";
    private final String DELETE="{CALL SP_INSERTAR_MENU(?,?,?,?,?,?)}";
    private final String GETALL="{CALL SP_LISTAR_MENU()}";
    private final String GETONE="{CALL SP_BUSCAR_ONE_MENU(?)}";
    
    private final String GETIDS="{CALL SP_BUSCAR_IDS_MENU(?)}";
    private final String GETNOMBRE="{CALL SP_BUSCAR_NOMBRE_MENU(?)}";    
    private final String GETMAYORES="{CALL SP_BUSCAR_STOCK_MAYORES_MENU(?)}";    
    private final String GETMENORES="{CALL SP_BUSCAR_STOCK_MENORES_MENU(?)}";   
    private final String NEWCOD="{CALL SP_BUSCAR_NUEVO_CODIGO_ME()}";   
    
    private final String UPDATEMASSTOCK="{CALL SP_AUMENTAR_CANTIDAD_MENU(?,?)}";
    private final String UPDATEMENOSSTOCK="{CALL SP_RESTAR_CANTIDAD_MENU(?,?)}";
     

    public MYSQLMenu(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void Insertar(Menu menu) throws IException {
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,menu.getId());
         preparacion_insert.setString(2,menu.getNombre());
         preparacion_insert.setString(3,menu.getDetalle());
         preparacion_insert.setInt(4,menu.getStock());
         preparacion_insert.setDouble(5,menu.getPrecio());
         preparacion_insert.setString(6,menu.getRuta());
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Menu no se inserto",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL INSERT MENU",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "INSERT MENU");
         Utilidades.cerrarCall(preparacion_insert, "INSERT MENU");
    }
    }

    @Override
    public void Actualizar(Menu menu) throws IException {
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(UPDATE);
         
         preparacion_insert.setString(1,menu.getId());
         preparacion_insert.setString(2,menu.getNombre());
         preparacion_insert.setString(3,menu.getDetalle());
         preparacion_insert.setInt(4,menu.getStock());
         preparacion_insert.setDouble(5,menu.getPrecio());
         preparacion_insert.setString(6,menu.getRuta());
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Menu no se Actualizo",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATE MENU",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "UPDATE MENU");
         Utilidades.cerrarCall(preparacion_insert, "UPDATE MENU");
    }
    }

    @Override
    public void Eliminar(Menu menu) throws IException {
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(DELETE);
         
         preparacion_insert.setString(1,menu.getId());

            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Menu no se Elimino",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATE MENU",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "UPDATE MENU");
         Utilidades.cerrarCall(preparacion_insert, "UPDATE MENU");
    }
    }

    @Override
    public List<Menu> ObtenerTodos() throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Menu> menu_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETALL);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               menu_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETALL MENU ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETALL MENU");
            Utilidades.cerrarCall(preparacion_where, "GETALL MENU");
        
        }
        return menu_data;
    }

    @Override
    public Menu ObtenerOne(String id) throws IException {
       CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
       Menu menu_buscado = null;
        try
        {
            preparacion_where=connection.prepareCall(GETONE);
            preparacion_where.setString(1, id);
            resultado_data=preparacion_where.executeQuery();
            
            if(resultado_data.next())
            {
               menu_buscado=Data(resultado_data);
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETONE MENU", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETONE MENU");
            Utilidades.cerrarCall(preparacion_where, "GETONE MENU");
        //    Utilidades.cerrarConnec(connection,"GETONE CLIENTE");
        }
        return menu_buscado;
    }

    @Override
    public List<Menu> getObtenerIds(String valor) throws IException {
       CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Menu> menu_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETIDS);
            preparacion_where.setString(1, valor);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               menu_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETIDS MENU ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETIDS MENU");
            Utilidades.cerrarCall(preparacion_where, "GETIDS MENU");
        
        }
        return menu_data;
    }

    @Override
    public List<Menu> getObtenerNombres(String valor) throws IException {
        CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Menu> menu_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETNOMBRE);
            preparacion_where.setString(1, valor);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               menu_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETNOMBRE MENU ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETNOMBRE MENU");
            Utilidades.cerrarCall(preparacion_where, "GETNOMBRE MENU");
        
        }
        return menu_data;
    }

    @Override
    public List<Menu> getObtenerMayoresStock(int valor) throws IException {
          CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Menu> menu_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETMAYORES);
            preparacion_where.setInt(1, valor);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               menu_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETMAYORES MENU ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETMAYORES MENU");
            Utilidades.cerrarCall(preparacion_where, "GETMAYORES MENU");
        
        }
        return menu_data;
    }

    @Override
    public List<Menu> getObtenerMenoresStock(int valor) throws IException {
           CallableStatement preparacion_where = null;
        ResultSet resultado_data = null;
        
        List<Menu> menu_data = new ArrayList<>();
        try
        {
            preparacion_where=connection.prepareCall(GETMENORES);
            preparacion_where.setInt(1, valor);
            resultado_data=preparacion_where.executeQuery();
            
            while(resultado_data.next())
            {
               menu_data.add(Data(resultado_data));
            }
            
        }catch (SQLException ex) 
            {
                Utilidades.manejarError("RESULTSET GETMENORES MENU ", ex,"MENSAJE",1);
            }
        finally
        {
           
            Utilidades.cerrarResul(resultado_data, "GETMENORES MENU");
            Utilidades.cerrarCall(preparacion_where, "GETMENORES MENU");
        
        }
        return menu_data;
    }
        
    private Menu Data(ResultSet resultado_data) throws SQLException {
          String id=resultado_data.getString("id");
          String nombre = resultado_data.getString("nombre");
          String detalle = resultado_data.getString("detalle");
          java.util.Date fecha = resultado_data.getDate("fecha");
          int stock = resultado_data.getInt("stock");
          double precio = resultado_data.getDouble("precio");
          String ruta= resultado_data.getString("ruta");
              
          Menu menu=new Menu(id,nombre,detalle,fecha,stock,precio,ruta);
                    
          return menu;
    }

    @Override
    public void SumarStock(Menu menu) throws IException {
    CallableStatement preparacion_updateplus=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_updateplus=connection.prepareCall(UPDATEMASSTOCK);
         
         preparacion_updateplus.setInt(1,menu.getStock());
         preparacion_updateplus.setString(2,menu.getId());
        
         
            if(preparacion_updateplus.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Stock del Menu no se Actualizo",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATEMASSTOCK MENU",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "UPDATEMASSTOCK MENU");
         Utilidades.cerrarCall(preparacion_updateplus, "UPDATEMASSTOCK MENU");
    }
    }

    @Override
    public void RestarStock(Menu menu) throws IException {
        CallableStatement preparacion_updateplus=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_updateplus=connection.prepareCall(UPDATEMENOSSTOCK);
         
         preparacion_updateplus.setInt(1,menu.getStock());
         preparacion_updateplus.setString(2,menu.getId());
        
         
            if(preparacion_updateplus.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Stock del Menu no se Actualizo",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL UPDATEMENOSSTOCK MENU",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "UPDATEMENOSSTOCK MENU");
         Utilidades.cerrarCall(preparacion_updateplus, "UPDATEMENOSSTOCK MENU");
    }
    }

    @Override
    public String NewCod() throws IException {
         String cod = "ME000001";
        CallableStatement prepare_new_code=null;
        ResultSet result_data=null;
		try{
			prepare_new_code = connection.prepareCall(NEWCOD);
			result_data = prepare_new_code.executeQuery();
			
			if(result_data.next()){
                                                                              
				DecimalFormat formato_decimal = new DecimalFormat("000000");
                                                                              System.out.println(formato_decimal);
                                                                              if(result_data.getString(1)!=null){
				cod = "ME" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1); }
			}
			
		}catch (SQLException e) {
			Utilidades.manejarError("RESULTSET NEWCODE MENU", e,"MENSAJE",1);
		}finally {
		    Utilidades.cerrarResul(result_data, "NEWCODE MENU");
                 Utilidades.cerrarCall(prepare_new_code, "NEWCODE MENU");
              }
		return cod;
    }
    
}
