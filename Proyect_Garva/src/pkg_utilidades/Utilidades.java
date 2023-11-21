
package pkg_utilidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pkg_MYSQL.Interfaces.IException;


public class Utilidades {
    
   public static void Mensaje(String titulo,String mensaje,int icono)
    {
        JOptionPane.showMessageDialog(null,mensaje,titulo,icono);
                
    }
    
     public static void manejarError(String mensaje, SQLException ex,String titulo,int icon) throws IException {
        Mensaje(titulo, mensaje.concat(ex.toString()), icon);
        throw new IException(mensaje, ex);
    }

    public static void cerrarResul(ResultSet rs,String Message) throws IException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                manejarError("ERROR cerrar ResultSet ".concat(Message), ex,"ERROR",0);
            }
        }
     
        }
    
    public static void cerrarCall(CallableStatement ps,String Message) throws IException{
            if (ps != null) {
            try {
                ps.close();
                } catch (SQLException ex) {
                manejarError("Error cerrar PreparedStatement ".concat(Message), ex,"ERROR",0);
                }
                 }
        }
    
      public static void cerrarConnec(Connection cn,String Message) throws IException{
            if (cn != null) {
            try {
                cn.close();
                } catch (SQLException ex) {
                manejarError("Error cerrar Connection ".concat(Message), ex,"ERROR",0);
                }
                 }
        }

}
