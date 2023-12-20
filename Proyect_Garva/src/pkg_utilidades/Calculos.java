
package pkg_utilidades;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
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
   public int getMensage(String ruta_image,String title,String content){
   ImageIcon icono = new ImageIcon(ruta_image);
   int respuesta=JOptionPane.showConfirmDialog(null, content,
                title, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,icono);
   return respuesta;
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
      
       public void BoletaPdf(JTable table_form,String total) throws DocumentException, FileNotFoundException, BadElementException, IOException
   {
    String ruta="";    
   
        JFileChooser ventana=new JFileChooser();
        
        File directorioInicial= new File("C:/Users/ERROR4~1/Desktop/");
        ventana.setCurrentDirectory(directorioInicial);
        ventana.setDialogTitle("Guardar Archivo");
        
        
        int select=ventana.showSaveDialog(null);
        
    if(select== JFileChooser.APPROVE_OPTION){
       ruta = ventana.getSelectedFile().toString().concat(".pdf");
        
       Document doc=new Document(new Rectangle(5*72, 8*72));
       
        File rutita=new File(ruta);    
        PdfWriter.getInstance(doc,new FileOutputStream(ruta));
        Image image= Image.getInstance("src/pkg_Reportes/GARVA_FONDO.png");
        doc.open();
        Paragraph fecha = new Paragraph();
        fecha.setSpacingBefore(10);
        Font titles_=new Font(Font.TIMES_ROMAN,12,Font.BOLD,Color.BLACK);
        Font titles2=new Font(Font.TIMES_ROMAN,10,Font.BOLD,Color.BLACK);
        Font parrafos=new Font(Font.TIMES_ROMAN,10,Font.NORMAL,Color.BLACK);
        Font negrita=new Font(Font.TIMES_ROMAN,10,Font.BOLD,Color.WHITE);
         
        fecha.add(new Chunk("BOLETA DE VENTA",titles_));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("ELECTRONICA",titles_));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("NEGOCIOS ALIMENTICIOS",titles_));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("GARVA S.A.C",titles_));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("20161635899",parrafos));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("Av. 15 de Enero 330 Nro 15047 Lima",parrafos));
        fecha.add(Chunk.NEWLINE);
        fecha.add(new Chunk("Lima,Lima",parrafos));
        fecha.setAlignment(Element.ALIGN_CENTER);
        Date date=new Date();
       
         String hoy= new SimpleDateFormat("dd-mm-yyyy").format(date)+"\n\n";
         
            PdfPTable Encabezados=new PdfPTable(2);
            
            Encabezados.setWidthPercentage(110);
            Encabezados.getDefaultCell().setBorder(0);
            float[] columnlocation = new float[]{30f,50f};
            Encabezados.setWidths(columnlocation);
            Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Encabezados.addCell(image);
            PdfPCell cellImageFecha = new PdfPCell();
            cellImageFecha.setBorder(0);
            cellImageFecha.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellImageFecha.addElement(fecha);
            
            Encabezados.addCell(cellImageFecha);
          //Encabezados.addCell("Ruc: "+ruc+"\nNombre: "+nombre+"\nTelefono: "+tele+"\nDireccion: "+direcc+"\nDominicilo: "+domi);
            doc.add(Encabezados);
           
            
            Paragraph Nro_Boleta=new Paragraph();
            Nro_Boleta.add(new Chunk(" N° B001",titles_));
            Nro_Boleta.setAlignment(Element.ALIGN_CENTER);
            Nro_Boleta.add(Chunk.NEWLINE);
            Nro_Boleta.add(Chunk.NEWLINE);
            Nro_Boleta.add(Chunk.NEWLINE);
            doc.add(Nro_Boleta);
            
            
            Paragraph Datos=new Paragraph();
            Datos.add(new Chunk("Cliente:   ",titles2));
            Datos.add(Chunk.NEWLINE);
            Datos.add(new Chunk("Fecha:     ",titles2));
            Datos.add(Chunk.NEWLINE);
            Datos.add(new Chunk("N° Pedido: ",titles2));
            
            PdfPTable tableDatos_=new PdfPTable(2);
            tableDatos_.getDefaultCell().setBorder(0);
            float[] columnDatos = new float[]{50f,50f};
            tableDatos_.setWidths(columnDatos);
            tableDatos_.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cellDato1 = new PdfPCell();
            cellDato1.setBorder(0);
            cellDato1.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellDato1.addElement(Datos);
            
            tableDatos_.addCell(cellDato1);
            
            Paragraph Datos2=new Paragraph();
            Datos2.add(new Chunk("Cliente:",parrafos));
            Datos2.add(Chunk.NEWLINE);
            Datos2.add(new Chunk("Fecha:",parrafos));
            Datos2.add(Chunk.NEWLINE);
            Datos2.add(new Chunk("N° Pedido:",parrafos));
            
            PdfPCell cellDato2 = new PdfPCell();
            cellDato2.setBorder(0);
            cellDato2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellDato2.addElement(Datos2);
            
            tableDatos_.addCell(cellDato2);
            
            doc.add(tableDatos_);
            
            
           /*Paragraph cli=new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos de los Clientes");
            doc.add(cli);
            
            PdfPTable tabla_cliente=new PdfPTable(4);
            tabla_cliente.setWidthPercentage(100);
            tabla_cliente.getDefaultCell().setBorder(0);
            float[] columnaCli = new float[]{20f,50f,30f,40f};
            tabla_cliente.setWidths(columnaCli);
            
            tabla_cliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            PdfPCell cliente_ce1=new PdfPCell(new Phrase("DNI",negrita));
            PdfPCell cliente_ce2=new PdfPCell(new Phrase("Nombre",negrita));
            PdfPCell cliente_ce3=new PdfPCell(new Phrase("Telefono",negrita));
            PdfPCell cliente_ce4=new PdfPCell(new Phrase("Direccion",negrita));
            
            cliente_ce1.setBorder(0);
            cliente_ce2.setBorder(0);
            cliente_ce3.setBorder(0);
            cliente_ce4.setBorder(0);
            
            cliente_ce1.setBackgroundColor(Color.blue);
            cliente_ce2.setBackgroundColor(Color.blue);
            cliente_ce3.setBackgroundColor(Color.blue);
            cliente_ce4.setBackgroundColor(Color.blue);
            
            
            tabla_cliente.addCell(cliente_ce1);
            tabla_cliente.addCell(cliente_ce2);
            tabla_cliente.addCell(cliente_ce3);
            tabla_cliente.addCell(cliente_ce4);
            
            tabla_cliente.addCell("12345678");
            tabla_cliente.addCell("Maria");
            tabla_cliente.addCell("98765432");
            tabla_cliente.addCell("Jesus Maria");
            
            
            
            doc.add(tabla_cliente);
            */
            // Productos
            PdfPTable tabla_producto=new PdfPTable(4);
            tabla_producto.setWidthPercentage(120);
            tabla_producto.getDefaultCell().setBorder(0);
            float[] columnaPro = new float[]{20f,30f,20f,20f};
            tabla_producto.setWidths(columnaPro);
            
            tabla_producto.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell pro_ce1=new PdfPCell(new Phrase("CANTIDAD",negrita));
            PdfPCell pro_ce2=new PdfPCell(new Phrase("DESCRIPCION",negrita));
            PdfPCell pro_ce3=new PdfPCell(new Phrase("PRECIO U",negrita));
            PdfPCell pro_ce4=new PdfPCell(new Phrase("PRECIO F",negrita));
            
            
            pro_ce1.setBorder(0);
            pro_ce2.setBorder(0);
            pro_ce3.setBorder(0);
            pro_ce4.setBorder(0);
            
            pro_ce1.setBackgroundColor(Color.blue);
            pro_ce2.setBackgroundColor(Color.blue);
            pro_ce3.setBackgroundColor(Color.blue);
            pro_ce4.setBackgroundColor(Color.blue);
            
            tabla_producto.addCell(pro_ce1);
            tabla_producto.addCell(pro_ce2);
            tabla_producto.addCell(pro_ce3);
            tabla_producto.addCell(pro_ce4);
            
            for(int i=0;i< table_form.getRowCount();i++){
            String cantidad=table_form.getValueAt(i,0).toString();
            String descripcion=table_form.getValueAt(i,2).toString();
            String precio=table_form.getValueAt(i,3).toString();
            String preciof=table_form.getValueAt(i,4).toString();
            
            tabla_producto.addCell(cantidad);
            tabla_producto.addCell(descripcion);
            tabla_producto.addCell(precio);
            tabla_producto.addCell(preciof);
            
            }
            
            doc.add(tabla_producto);
            
            Paragraph info=new  Paragraph();
            info.add("Total a Pagar: "+total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma=new  Paragraph();
            firma.add("Cancelacion y Firma\n\n");
            firma.add("____________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            
             Paragraph mensaje=new  Paragraph();
            mensaje.add("Gracias por su Compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
       
            doc.close();
            
            Desktop.getDesktop().open(rutita);
            
    }
   }
      
}
