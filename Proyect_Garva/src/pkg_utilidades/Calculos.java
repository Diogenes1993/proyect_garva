
package pkg_utilidades;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Calculos {
    
   public static java.sql.Date convertFecha(java.util.Date date)
   {
       java.sql.Date format= new java.sql.Date(date.getTime());
       return format;
   }
  
    
  public String copiarImagen(File archivoOrigen,String ruta) {
        String final_ruta;
        try {
            // Directorio de destino (puedes cambiar la ruta según tus necesidades)
            Path destino = Paths.get(ruta, archivoOrigen.getName());
            // Copiar el archivo
            Files.copy(archivoOrigen.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Imagen copiada exitosamente a " + destino.toString());
            final_ruta=destino.toString();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al copiar la imagen.");
            final_ruta=null;
        }
        return final_ruta;
}
  
  
   public void SetImageLabel(JLabel labelName,String root){
    ImageIcon image = new ImageIcon(root);
    Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(), Image.SCALE_DEFAULT));
    labelName.setIcon(icon);
    }
}
