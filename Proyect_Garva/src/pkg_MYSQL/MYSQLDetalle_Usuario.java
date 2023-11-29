
package pkg_MYSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import pkg_MYSQL.Interfaces.IDetalle_Usuario;
import pkg_MYSQL.Interfaces.IException;
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
    public List<Detalle_Usuario> ObtenerPorEmpleado(long empleado) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorUsuario(long usuario) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerPorFecha(Date fecha) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insertar(Detalle_Usuario detalle_usuario) throws IException{
    CallableStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareCall(INSERT);
         
         preparacion_insert.setLong(1,detalle_usuario.getId().getId_empleado() );
         preparacion_insert.setLong(2,detalle_usuario.getId().getId_usuario() );
         preparacion_insert.setDate(3, java.sql.Date.valueOf(detalle_usuario.getId().getFecha_entrada()));
         
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el Detalle_Usuario no se inserto",new SQLException(),"MENSAJE",1);
                }
                 
    }catch (SQLException ex) 
    {
        
        Utilidades.manejarError("Error en SQL INSERT DETALLE_USUARIO",ex,"ERROR",0);
        
    }finally
    {
         
         Utilidades.cerrarResul(result_clave, "INSERT DETALLE_USUARIO");
         Utilidades.cerrarCall(preparacion_insert, "INSERT DETALLE_USUARIO");
    }
    }

    @Override
    public void Actualizar(Detalle_Usuario a) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Detalle_Usuario a) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detalle_Usuario> ObtenerTodos() throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detalle_Usuario ObtenerOne(Detalle_Usuario.Id_Detalle_Usuario id) throws IException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   

 
}


