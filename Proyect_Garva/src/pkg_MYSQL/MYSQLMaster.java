
package pkg_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pkg_MYSQL.Interfaces.IBoleta;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IDetalle_Pedido;
import pkg_MYSQL.Interfaces.IDetalle_Usuario;
import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IEmpleado;
import pkg_MYSQL.Interfaces.IMaster;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_MYSQL.Interfaces.IPedido;
import pkg_MYSQL.Interfaces.IRol;
import pkg_utilidades.Utilidades;
import pkg_MYSQL.Interfaces.IAdelanto;
import pkg_MYSQL.Interfaces.IConsumo;


public class MYSQLMaster implements IMaster {
private Connection connection=null;

private IDistrito distritoI=null;
private  ICliente clienteI=null;
private IRol rolI=null;
private IEmpleado empleadoI=null;
private  IAdelanto adelantoI=null;
private  IMenu menuI=null;
private  IPedido pedidoI=null;
private  IBoleta boletaI=null;
private  IConsumo consumoI=null;
private  IDetalle_Usuario detalleUsuarioI=null;
private  IDetalle_Pedido detallePedidoI=null;

    public MYSQLMaster(String host,String username,String password,String database) {
    try {
        connection = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, username,password);
    } catch (SQLException ex) {
            Utilidades.Mensaje("Connection","Fallo la conexion", 0);
    }
    }
    
    @Override
    public ICliente getICliente() {
    if(clienteI == null)
    {
        clienteI =new MYSQLCliente(connection);
    }
    return clienteI;
    }

   

    
    @Override
    public IEmpleado getIEmpleado() {
             if(empleadoI == null)
    {
        empleadoI =new MYSQLEmpleado(connection);
    }
    return empleadoI;
    }

    @Override
    public IMenu getIMenu() {
         if(menuI == null)
    {
         menuI =new MYSQLMenu(connection);
    }
        return menuI;
    }

    @Override
    public IPedido getIPedido() {
        if(pedidoI == null){
            pedidoI = new MYSQLPedido(connection);
        }
        return pedidoI;
    }

    @Override
    public IBoleta getIBoleta() {
      if(boletaI == null)
    {
      //  boletaI = new MYSQLBoleta(connection);
    }
    return boletaI;
    }


    @Override
    public IDetalle_Pedido getIDetalle_pedido() {
        if(detallePedidoI == null)
    {
    detallePedidoI =new MYSQLDetallePedido(connection);
    }
    return detallePedidoI;
    }

    @Override
    public IDetalle_Usuario getIDetalle_usuario() {
     if(detalleUsuarioI == null)
    {
      detalleUsuarioI =new MYSQLDetalle_Usuario(connection);
    }
    return detalleUsuarioI;
    }

    @Override
    public IDistrito getIDistrito() {
        if(distritoI == null)
    {
        distritoI =new MYSQLDistrito(connection);
    }
    return distritoI;
    }

    @Override
    public IRol getIRol() {
        if(rolI == null)
    {
        rolI =new MYSQLRol(connection);
    }
    return rolI;
    }

    @Override
    public IAdelanto getIAdelanto() {
       if(adelantoI == null)
    {
        adelantoI =new MYSQLAdelanto(connection);
    }
    return adelantoI;   
    }

    @Override
    public IConsumo getIConsumo() {
        if(consumoI == null)
    {
      //  consumoI =new MYSQLConsumo(connection);
    }
    return consumoI;  
    }
    
    
}
