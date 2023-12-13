
package pkg_utilidades;

import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



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
   
   public void exportarExcel(JTable t,String NombreHoja) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet(NombreHoja);
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
   
   public void exportarTxt(JTable tabla) throws IOException{
   JFileChooser ventana=new JFileChooser();
   ventana.setDialogTitle("Guardar Archivo");
    int select=ventana.showSaveDialog(null);
    if(select== JFileChooser.APPROVE_OPTION){
        String ruta = ventana.getSelectedFile().toString().concat(".txt");
        try{
         File save=new File(ruta);
         FileWriter fw=new FileWriter(save);
         BufferedWriter bufer=new BufferedWriter(fw);
         for(int i=0;i< tabla.getRowCount();i++){
             for(int j =0 ; j<tabla.getColumnCount();j++){
                 bufer.write(tabla.getValueAt(i, j).toString()+",");
             }
             bufer.newLine();
         }
         Utilidades.Mensaje( "MENSAJE","GUARDANDO ...................", 1);
         bufer.close();
         fw.close();
         Utilidades.Mensaje("MENSAJE", "GUARDADO ", 1);
        }catch(IOException io){
        Utilidades.Mensaje("ERROR", "ERROR AL GUARDAR", 0);
        }
    }
   } 
}