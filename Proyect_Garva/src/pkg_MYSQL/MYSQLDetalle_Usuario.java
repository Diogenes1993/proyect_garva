
package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import pkg_MYSQL.Interfaces.IDetalle_Usuario;
import pkg_Modelo.Entidades.Detalle_Usuario;
import pkg_utilidades.Utilidades;



public class MYSQLDetalle_Usuario implements IDetalle_Usuario{

    private Connection connection=null;

    private final String INSERT="INSERT INTO DETALLE_USUARIO(FK_ID_EMPLEADO,FK_ID_USUARIO,FECHA_ENTRADA) VALUES (?,?,?)";
    public MYSQLDetalle_Usuario(Connection connection) 
    {
        this.connection=connection;
    }
        
    @Override
    public List<Detalle_Usuario> ObtenerPorEmpleado(long empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorUsuario(long usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insertar(Detalle_Usuario detalle_usuario) {
      PreparedStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
         
         preparacion_insert.setLong(1,detalle_usuario.getId().getId_empleado() );
         preparacion_insert.setLong(2,detalle_usuario.getId().getId_usuario() );
         preparacion_insert.setDate(3, java.sql.Date.valueOf(detalle_usuario.getId().getFecha_entrada()));
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.Mensaje("ERROR","Espera el Detalle_Usuario no se inserto",0);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
     
    }catch (SQLException ex) 
    {
        
        Utilidades.Mensaje("ERROR","Error en SQL INSERT DETALLE_USUARIO".concat(ex.toString()),0);
        
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
                 Utilidades.Mensaje("ERROR","Error en Result INSERT DETALLE_USUARIO ".concat(ex.toString()),0);
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
                Utilidades.Mensaje("ERROR","Error en Prepared INSERT DETALLE_USUARIO ".concat(ex.toString()),0);
            }
        }
    }  
    }

    @Override
    public void Actualizar(Detalle_Usuario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Detalle_Usuario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detalle_Usuario ObtenerOne(Detalle_Usuario.Id_Detalle_Usuario id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   

 
}


