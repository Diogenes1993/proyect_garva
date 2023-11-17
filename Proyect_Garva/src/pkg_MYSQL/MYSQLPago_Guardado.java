package pkg_MYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IPago_Guardado;
import pkg_Modelo.Entidades.Pago_Guardado;
import pkg_utilidades.Utilidades;

public class MYSQLPago_Guardado implements IPago_Guardado {

    private static final String INSERT ="INSERT INTO PAGO_GUARDADO(MONTO,FK_ID_CLIENTE) VALUES(?,?)";
    private static final String UPDATE ="UPDATE PAGO_GUARDADO SET MONTO=?,FECHA=?,FK_ID_CLIENTE=? WHERE PK_ID_PAGO=?";
    private static final String DELETE ="DELETE FROM PAGO_GUARDADO WHERE PK_ID_PAGO=?";
    private static final String GETALL ="SELECT PK_ID_PAGO,NOMBRE_CLIENTE,MONTO,FECHA FROM PAGO_GUARDADO,CLIENTE WHERE PK_ID_CLIENTE=FK_ID_CLIENTE ";
    private static final String GETONE =" AND PK_ID_PAGO=? ORDER BY PK_ID_PAGO";
    private Connection connection;
    public MYSQLPago_Guardado(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insertar(Pago_Guardado pago_guardado) throws IException{
        
           PreparedStatement preparacion_insert=null;
    ResultSet result_clave=null;
    
    try
    {
         preparacion_insert=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
         
         preparacion_insert.setDouble(1,pago_guardado.getMonto() );
         preparacion_insert.setLong(2,pago_guardado.getId_cliente());
        
            if(preparacion_insert.executeUpdate()==0)
                {
                    Utilidades.manejarError("Espera el PAGO_GUARDADO no se inserto", new SQLException(),"MENSAJE",1);
                }
            result_clave=preparacion_insert.getGeneratedKeys();
            if(result_clave.next())
                {
                    pago_guardado.setId(result_clave.getLong(1));
                }
            else
            {
                 Utilidades.manejarError("No se puede asignar Id a este PAGO_GUARDADO", new SQLException(),"MENSAJE",1);
            }
     
    }catch (SQLException ex) 
    {
        Utilidades.manejarError("Error en SQL INSERT PAGO_GUARDADO", ex,"ERROR",0);
                
    }finally
    {
                  Utilidades.cerrarResul(result_clave,"PAGO_GUARDADO INSERT");
                  Utilidades.cerrarPrepare(preparacion_insert,"PAGO_GUARDADO INSERT");
    }
    }

    @Override
    public void Actualizar(Pago_Guardado a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Pago_Guardado a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pago_Guardado> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pago_Guardado ObtenerOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
