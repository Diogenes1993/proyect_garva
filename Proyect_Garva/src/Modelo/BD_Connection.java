package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pkg_utilidades.Utilidades;


public class BD_Connection {
    private Connection connection;
    
    private static String driver="com.mysql.jdbc.Driver";
    private static String user="Garva";
    private static String password="123456A_dmin";
    private static String bd="GARVA_ALIMENTOS";
    private static String url="jdbc:mysql://192.168.0.109:3306/".concat(bd);
    
    static
            {
                try
                     {
                         Class.forName(driver);
                     }
                catch(ClassNotFoundException ex)
                     {
                         Utilidades.Mensaje(ex.toString(),"Driver", 0);
                     }
            }
    
    public Connection getConnection()
    {
        try
            {
                connection=DriverManager.getConnection(url,user,password);
            }
        catch(SQLException ex)
            {
                Utilidades.Mensaje(ex.toString(),"Connection", 0);
            }
        
        return connection;
    }
    
}
