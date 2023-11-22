
package pkg_Hilos;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class HReloj extends Thread {
  
   private JLabel fecha_;

    public HReloj(JLabel fecha_) {
        this.fecha_ = fecha_;
    }
   
    public void run(){
    super.run();
    
    while (true){
        try {
            Date fecha = new Date();
            DateFormatSymbols simbolo=new DateFormatSymbols();
            String[] newAmpms={"AM","PM"};
            simbolo.setAmPmStrings(newAmpms);
            
            SimpleDateFormat dateformat=new SimpleDateFormat("hh:mm:ss a",simbolo);
            
           fecha_.setText(dateformat.format(fecha).toUpperCase());
            
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
     }
        }
  
}
