package pkg_main;

import pkg_Formulario.Menu.frm_Menu;
import pkg_Formulario.frm_Login;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.MYSQLMaster;
import pkg_Modelo.Envio_Correo;
import pkg_utilidades.Utilidades;




public class Main {

    public static void main(String[] args) throws IException {
        
        //frm_Menu login=new frm_Menu();
        
        MYSQLMaster master =new MYSQLMaster("localhost","root","123456admin","GARVA");
       frm_Login login=new frm_Login(master);
        //login.setVisible(true);
       // frm_Menu login=new frm_Menu(master);
        login.setVisible(true);
        
      /*  String[] mesaje={"PRESTAME","DINERO","CAROLINA","MAZAMORRA","123456","QUETAL"};
        String[] ruta_image={"images\\Model_Coceptual.jpeg","images/Modelo_Logico.png"};
        String[] correo1={"albert123ot@gmail.com","gepsehefyu@gufum.com"};
        
           for (int i=0;i<ruta_image.length;i++){
         Envio_Correo correo=new Envio_Correo(correo1[1],"Prestamo");
         correo.Create_Email3(ruta_image[i]);
         correo.Send_Message();
            }*/
      
    }
    
    
    
   



}
