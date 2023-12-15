
package pkg_utilidades;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;

import java.awt.Desktop;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(), java.awt.Image.SCALE_DEFAULT));
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
   
  /* public void PDF() throws DocumentException
   {
       // step 1: creation of a document-object        
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("Ejemplo_pdf_java.pdf"));

            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            //--------------------- pagina 1 --------------------------
            g.setColor(Color.red);
            g.drawRect(1, 1, 593, 7|90);    
            
            g.setColor(new Color(154, 171, 237));
            g.fillOval(290, 90, 280, 100);
                        
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Ejemplo crear PDF desde Java", 40, 150);
            
            g.setColor(Color.WHITE);
            g.drawString("PDF desde Java", 290, 150);
            
            ImageIcon img1 = new ImageIcon(getClass().getResource("imagenes/play_list_youtube-GUI_Java.jpg"));
            g.drawImage(img1.getImage(), 200, 250, 200, 200, null);
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Escanea el código QR para visitar la lista de reproducción de YouTube", 60, 460);
            g.drawString("del curso de GUI en Java", 210, 480);
            
            document.newPage();
            //--------------------- pagina 2 --------------------------
            
            g.setColor(Color.GREEN);
            g.drawLine(1, 1, 200, 200);

            g.setColor(Color.BLUE);
            g.drawRect(200, 200, 300, 300);
            
            ImageIcon img2 = new ImageIcon(getClass().getResource("imagenes/java-duke-guitar.png"));
            g.drawImage(img2.getImage(), 230, 220, 250, 250, null);
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "Se creo el archivo 'Ejemplo_pdf_java.pdf' en la carpeta del proyecto");
    }
   */
   
      public void exportarPDF(JTable tbla,String hoja) throws DocumentException, FileNotFoundException
   {
    String ruta="";    
   
        JFileChooser ventana=new JFileChooser();
        ventana.setDialogTitle("Guardar Archivo");
        
        
        int select=ventana.showSaveDialog(null);
        
    if(select== JFileChooser.APPROVE_OPTION){
       ruta = ventana.getSelectedFile().toString().concat(".pdf");
            Document doc=new Document();
            
          PdfWriter.getInstance(doc,new FileOutputStream(ruta));
            
            doc.open();
          Paragraph parrafo = new Paragraph();
        
    
            parrafo.add(new Paragraph("GARVA SERVICIOS ALIMENTICIOS LISTA DE "+hoja));
            parrafo.add(Chunk.NEWLINE);
            parrafo.add(Chunk.NEWLINE);
    
            doc.add(parrafo);

            
            PdfPTable tabla=new PdfPTable(tbla.getColumnCount());
            
            tabla.setWidthPercentage(110);
            
             PdfPCell headerCell = new PdfPCell();
             
             
            headerCell.setBackgroundColor(Color.BLUE);
            
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Font headerFont =new Font(Font.HELVETICA,12,Font.BOLD,Color.WHITE);
            
            
            for(int i=0;i<tbla.getColumnCount();i++){
                 headerCell.setPhrase(new Phrase(tbla.getColumnName(i),headerFont));
                tabla.addCell(headerCell);
            }
            
            PdfPCell dataCell = new PdfPCell();
            dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            for (int j=0;j<tbla.getRowCount();j++){
                 for(int i=0;i<tbla.getColumnCount();i++){
                     dataCell.setPhrase(new Phrase(tbla.getValueAt(j,i).toString()));
                tabla.addCell(dataCell);
            }
            }
            
            doc.add(tabla);
            doc.close();
    }
   }
      
       public void BoletaPdf() throws DocumentException, FileNotFoundException, BadElementException, IOException
   {
    String ruta="";    
   
        JFileChooser ventana=new JFileChooser();
        ventana.setDialogTitle("Guardar Archivo");
        
        
        int select=ventana.showSaveDialog(null);
        
    if(select== JFileChooser.APPROVE_OPTION){
       ruta = ventana.getSelectedFile().toString().concat(".pdf");
       Document doc=new Document();
            
          PdfWriter.getInstance(doc,new FileOutputStream(ruta));
        
            doc.open();
            Image image= Image.getInstance("src/pkg_Reportes/Garva.png");
          Paragraph fecha = new Paragraph();
         Font negrita=new Font(Font.TIMES_ROMAN,12,Font.BOLD,Color.BLUE);
         fecha.add(Chunk.NEWLINE);
         Date date=new Date();
         fecha.add("Boleta: "+"Fecha: "+new SimpleDateFormat("dd-mm-yyyy").format(date)+"\n\n");
         
         
            
            PdfPTable Encabezados=new PdfPTable(4);
            
            Encabezados.setWidthPercentage(110);
            Encabezados.getDefaultCell().setBorder(0);
            float[] columnlocation = new float[]{20f,30f,70f,40f};
            Encabezados.setWidths(columnlocation);
            Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Encabezados.addCell(image);
            
            String ruc="1231434";
            String nombre="Dante";
            String tele="1231";
            String direcc="asdasd1";
            String domi="fgfgfg";
            
            Encabezados.addCell("");
            Encabezados.addCell("Ruc: "+ruc+"\nNombre: "+nombre+"\nTelefono: "+tele+"\nDireccion: "+direcc+"\nDominicilo: "+domi);
            Encabezados.addCell(fecha);
            doc.add(Encabezados);
           
            doc.close();
            
    }
   }
      
}
