
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Empleado;
import pkg_utilidades.Utilidades;

public class MYSQLEmpleado implements IEmpleado{
private Connection connection=null;

private String INSERT="{CALL SP_INSERTAR_EMPLEADO}";
    public MYSQLEmpleado(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void Insertar(Empleado empleado) throws IException{
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setString(1,empleado.getNombre());
         preparacion_insert.setString(2,empleado.getApellido());
         preparacion_insert.setString(3,empleado.getDistrito());
         preparacion_insert.setString(4,empleado.getTelefono());
         preparacion_insert.setString(4,empleado.getEmail());
         preparacion_insert.setDate(4,);
         preparacion_insert.setString(5,empleado.getRol());
         //preparacion_insert.setDate(6, java.sql.Date.valueOf(empleado.getFecha_contrato()));
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Detalle_Usuario no se inserto",new SQLException(),"MENSAJE",1);
                }
     
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("INSERT EMPLEADO",ex,"ERROR",0);
        
    }finally
    {
        Utilidades.cerrarResul(result_clave, "INSERT EMPLEADO");
        Utilidades.cerrarCall(preparacion_insert, "INSERT EMPLEADO");
    }  
    }

    
    @Override
    public void Actualizar(Empleado empleado) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Empleado empleado) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> ObtenerTodos() throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado ObtenerOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> getUsuariosActivos(boolean activo) throws IException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empleado> getUsuariosInactivos(boolean activo) throws IException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado getDataUsuario(String data) throws IException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
