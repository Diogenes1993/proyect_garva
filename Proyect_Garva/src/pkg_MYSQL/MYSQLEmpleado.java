
package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_Modelo.Entidades.Empleado;
import pkg_utilidades.Utilidades;

public class MYSQLEmpleado implements IEmpleado{
private Connection connection=null;

private String INSERT="INSERT INTO EMPLEADO(NOMBRE_EMPLEADO,APELLIDO_EMPLEADO,DIRECCION_EMPLEADO,TELEFONO_EMPLEADO,ROL_EMPLEADO,FECHA_CONTRATACION_EMPLEADO) VALUES (?,?,?,?,?,?)";
    public MYSQLEmpleado(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void Insertar(Empleado empleado) {
     PreparedStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
         
         preparacion_insert.setString(1,empleado.getNombre() );
         preparacion_insert.setString(2,empleado.getApellido() );
         preparacion_insert.setString(3,empleado.getDireccion() );
         preparacion_insert.setString(4,empleado.getTelefono() );
         preparacion_insert.setString(5,empleado.getRol().name());
         preparacion_insert.setDate(6, java.sql.Date.valueOf(empleado.getFecha_contrato()));
         
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
    public void Actualizar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado ObtenerOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
