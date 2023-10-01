
package pkg_utilidades;

import javax.swing.JOptionPane;


public class Utilidades {
    
    public static void Mensaje(String titulo,String mensaje,int icono)
    {
        JOptionPane.showMessageDialog(null,mensaje,titulo,icono);
                
    }
}
