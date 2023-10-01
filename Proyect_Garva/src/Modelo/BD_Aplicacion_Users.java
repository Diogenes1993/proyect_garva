
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pkg_Entidades.Aplicacion_Users;
import pkg_utilidades.Utilidades;


public class BD_Aplicacion_Users implements I_CRUD<Aplicacion_Users> {
private Connection conexion=new BD_Connection().getConnection();

    @Override
    public boolean Agregar(Aplicacion_Users a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Actualizar(Aplicacion_Users a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(Aplicacion_Users a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map<String, Object>> Mostrar() {
    List<Map<String, Object>> usuarios=new ArrayList<>();
      try
      {
          Statement con=conexion.createStatement();
          String consulta="SELECT * FROM Aplicacion_Users";
          ResultSet res=con.executeQuery(consulta);
          ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
          while (res.next()) {
               Map<String, Object> aplicacion = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = res.getObject(i);
                    aplicacion.put(columnName, value);
                }
              Map<String, Object> aplicacionReordenada = new LinkedHashMap<>();
        aplicacionReordenada.put("id", aplicacion.get("id"));
        aplicacionReordenada.put("Usuario", aplicacion.get("usuario_nombre"));
        aplicacionReordenada.put("contraseña", aplicacion.get("contrasenia_usuario"));
        aplicacionReordenada.put("activo", aplicacion.get("activo"));
                usuarios.add(aplicacionReordenada);
            }
          
      }catch(SQLException ex)
      {
          Utilidades.Mensaje("Mostrar", ex.toString(), 0);
      }
      return usuarios;
    }

   
        
    }


   



      
    
    
    

