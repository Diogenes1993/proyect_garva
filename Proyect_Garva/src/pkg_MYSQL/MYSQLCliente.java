package pkg_MYSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pkg_MYSQL.Interfaces.ICliente;
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
    public void Insertar(Cliente cliente) {
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
                    Utilidades.Mensaje("ERROR","Espera el Cliente no se inserto",0);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
            if(result_clave.next())
                {
                    cliente.setId(result_clave.getLong(1));
                }
            else
            {
                 Utilidades.Mensaje("ERROR","No se puede asignar Id a este CLIENTE",0);
                 
            }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL INSERT CLIENTE".concat(ex.toString()),0);
        
    }finally
    {
         if(result_clave != null)
        {
            try
            {
                result_clave.close();
            }
            catch(SQLException ex)
            {
                 Utilidades.Mensaje("ERROR","Error en Result INSERT CLIENTE ".concat(ex.toString()),0);
            }
        }
        if(preparacion_insert != null)
        {
            try
            {
                preparacion_insert.close();
            }
            catch(SQLException ex)
            {
                Utilidades.Mensaje("ERROR","Error en Prepared INSERT CLIENTE ".concat(ex.toString()),0);
            }
        }
    }
    }

    @Override
    public void Actualizar(Cliente cliente) {
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
                    Utilidades.Mensaje("ERROR","Espera el CLIENTE no se actualizo",0);
                }
           
     
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL UPDATE CLIENTE".concat(ex.toString()),0);
        
    }finally
    {
        if(preparacion_insert != null)
        {
            try
            {
                preparacion_insert.close();
            }
            catch(SQLException ex)
            {
                Utilidades.Mensaje("ERROR","Error en Prepared UPDATE CLIENTE ".concat(ex.toString()),0);
            }
        }
    }
    }

    @Override
    public void Eliminar(Cliente cliente) {
          PreparedStatement preparacion_delete=null;
        try
    {
         preparacion_delete=connection.prepareStatement(DELETEONE);
         
         preparacion_delete.setLong(1,cliente.getId() );
         
            if(preparacion_delete.executeUpdate()==0)
                {
             Utilidades.Mensaje("ERROR","Espera el Cliente no se Elimino",0);
                }
            
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL DELETE CLIENTE".concat(ex.toString()),0);

        
    }finally
    {
        if(preparacion_delete != null)
        {
            try
            {
                preparacion_delete.close();
            }
            catch(SQLException ex)
            {
              Utilidades.Mensaje("ERROR","Error en Prepared DELETE CLIENTE ".concat(ex.toString()),0);
            }
        }
    }
    }
    
       private Cliente Data(ResultSet resultado_data) 
    {
      try {
          String nombre = resultado_data.getString("NOMBRE_CLIENTE");
          String apellido = resultado_data.getString("APELLIDO_CLIENTE");
          String direccion = resultado_data.getString("DIRECCION_CLIENTE");
          String telefono = resultado_data.getString("TELEFONO_CLIENTE");
          String correo = resultado_data.getString("CORREO_CLIENTE");
          
          Cliente cliente=new Cliente(nombre,apellido,direccion,telefono,correo);
          cliente.setId(resultado_data.getLong("PK_ID_CLIENTE"));
          
          return cliente;
      } catch (SQLException ex) {
          Utilidades.Mensaje("ERROR","CLIENTE no llenados".concat(ex.toString()),0);
      }
      return null;
    }

    @Override
    public List<Cliente> ObtenerTodos() {
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
                 Utilidades.Mensaje("ERROR","No hay Registro: ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                          Utilidades.Mensaje("ERROR","Error cerrar ResultSet SELECT CLIENTE ".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_select != null)
            {
                try
                    {
                        preparacion_select.close();
                    }
                catch(SQLException ex)
                    {
                         Utilidades.Mensaje("ERROR","Error cerrar Prepared SELECT CLIENTE ".concat(ex.toString()),0);
                    }
            }
        }
        return cliente_list;
    }

    @Override
    public Cliente ObtenerOne(Long id) {
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
                Utilidades.Mensaje("MENSAJE","No existe el CLIENTE  buscado: ",1);
            }
            
        } 
         catch (SQLException ex) 
            {
                Utilidades.Mensaje("ERROR","CLIENTE RESULTSET: ".concat(ex.toString()),0);
            }
        finally
        {
            if(resultado_data != null)
            {
                try
                    {
                        resultado_data.close();
                    }
                catch(SQLException ex)
                    {
                        Utilidades.Mensaje("ERROR","Cerrar ResultSet WHERE CLIENTE".concat(ex.toString()),0);
                    }
            }
            
            if(preparacion_where != null)
            {
                try
                    {
                        preparacion_where.close();
                    }
                catch(SQLException ex)
                    {
                        Utilidades.Mensaje("ERROR","Cerrar Prepared WHERE CLIENTE".concat(ex.toString()),0);
                    }
            }
        }
        return cliente_buscado;
    }
    
}
