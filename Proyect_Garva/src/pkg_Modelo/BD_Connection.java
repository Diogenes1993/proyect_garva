package pkg_Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pkg_utilidades.Utilidades;


public class BD_Connection {
    private Connection connection;
    
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String user="Frank";
    private static String password="admin123456";
    private static String bd="GARVA";
    private static String url="jdbc:mysql://localhost:3306/".concat(bd);
    
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
