
package pkg_MYSQL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;



public class V_Alumno_Users {
    
    public DefaultTableModel mostrarAlumnosConNombresColumna(List<Map<String, Object>> users) {
        // Verificar si hay registros
        DefaultTableModel modelo;
        if (users.isEmpty()) {
            System.out.println("No se encontraron registros.");
           
        }
        // Obtener los nombres de las columnas del primer registro
        String[] columnas = users.get(0).keySet().toArray(new String[0]);
       modelo=new DefaultTableModel(null,columnas);
       
        // Imprimir los registros con nombres de columna
        for (Map<String, Object> usuario : users) {
            Object[] fila = new Object[columnas.length];
            for (int i = 0; i < columnas.length; i++) {
                fila[i] = usuario.get(columnas[i]);
            }
            modelo.addRow(fila);
        }
        return modelo;
    }

   

 
}


