
package pkg_main;

import Modelo.Envio_Correo;




public class Main {

    public static void main(String[] args) {
        
        
        String[] mesaje={"PRESTAME","DINERO","CAROLINA","MAZAMORRA","123456","QUETAL"};
        String[] ruta_image={"images\\Model_Coceptual.jpeg","images/Modelo_Logico.png"};
        String[] correo1={"albert123ot@gmail.com","caracely1026@gmail.com"};
        
           for (int i=0;i<ruta_image.length;i++){
         Envio_Correo correo=new Envio_Correo(correo1[0],"Prestamo");
         correo.Create_Email3(ruta_image[i]);
         correo.Send_Message();
            }
      
    }
    
    
    
   



}
