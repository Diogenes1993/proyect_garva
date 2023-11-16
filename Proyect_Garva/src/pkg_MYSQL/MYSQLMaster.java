
package pkg_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pkg_MYSQL.Interfaces.IBoleta;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IDetalle_Boleta_Menu;
import pkg_MYSQL.Interfaces.IDetalle_Pedido;
import pkg_MYSQL.Interfaces.IDetalle_Usuario;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_MYSQL.Interfaces.IPago_Guardado;
import pkg_MYSQL.Interfaces.IPedido;
import pkg_MYSQL.Interfaces.ITotal_Pedido;
import pkg_MYSQL.Interfaces.IUsuario;
import pkg_utilidades.Utilidades;


public class MYSQLMaster implements IMaster {
private Connection connection=null;
private  ICliente clienteI=null;
private  IPago_Guardado pago_guardadoI=null;
private IUsuario usuarioI=null;

    public MYSQLMaster(String host,String username,String password,String database) {
    try {
        connection = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, username,password);
    } catch (SQLException ex) {
            Utilidades.Mensaje("Connection","Fallo la conexion", 0);
    }
    }
    //MYSQLMaster master =new MYSQLMaster("localhost","root","123456admin","GARVA");

    @Override
    public ICliente getICliente() {
    if(clienteI == null)
    {
        clienteI =new MYSQLCliente(connection);
    }
    return clienteI;
    }

    @Override
    public IPago_Guardado getIPago_guardado() {
    if(pago_guardadoI == null)
    {
        pago_guardadoI =new MYSQLPago_Guardado(connection);
    }
    return pago_guardadoI;
    }

    @Override
    public IEmpleado getIEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IMenu getIMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPedido getIPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IBoleta getIBoleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITotal_Pedido getITotal_pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDetalle_Boleta_Menu getIDetalle_boleta_menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUsuario getIUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDetalle_Pedido getIDetalle_pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDetalle_Usuario getIDetalle_usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
