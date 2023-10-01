
package Controlador;

import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import Modelo.BD_Aplicacion_Users;
import Vista.V_Alumno_Users;


public class Control_Applica {

    public Control_Applica(BD_Aplicacion_Users modelo, V_Alumno_Users vista) {
          this.modelo = modelo;
        this.vista = vista;
    }
    
    private BD_Aplicacion_Users modelo;
    private V_Alumno_Users vista;

    public void mostrarAlumnosEnConsola(JTable table) {
        List<Map<String, Object>> alumnos = modelo.Mostrar();
        table.setModel(vista.mostrarAlumnosConNombresColumna(alumnos));
    }
}
