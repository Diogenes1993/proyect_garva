
package Modelo;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Envio_Correo {
    
    private String email="deadpool22003elinmortal@gmail.com";
    private String pass="njut hmozzyvxjnsj";
    private String destinatario;
    private String motivo;
    private String mensaje;
    
    
    private Session session;
    private MimeMessage correo;
     Properties propiedades = new Properties();

    public Envio_Correo(String destinatario, String motivo, String mensaje) {
        this.destinatario = destinatario;
        this.motivo = motivo;
        this.mensaje = mensaje;
    }
     public Envio_Correo(String destinatario, String motivo) {
        this.destinatario = destinatario;
        this.motivo = motivo;
    }
    
            
    public void Create_Email()
    {
        
     
     propiedades.put("mail.smtp.host",  "smtp.gmail.com");
     propiedades.put("mail.smtp.ssl.trust","smtp.gmail.com");
   
     propiedades.setProperty("mail.smtp.starttls.enable","true");
     propiedades.setProperty("mail.smtp.port","587");
     propiedades.setProperty("mail.smtp.user",email);
     propiedades.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
     propiedades.setProperty("mail.smtp.auth","true");
     
     
     session=Session.getDefaultInstance(propiedades);
     
     try
     {
         correo=new MimeMessage(session);
         correo.setFrom(new InternetAddress(email));
         
         correo.setRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
         correo.setSubject(motivo);
         correo.setContent(mensaje,"text/html");
         System.out.println("SE ACABA DE CREAR EL CORREO");
     }catch(MessagingException ex)
     {
         System.out.println("ERROR "+ ex.getMessage());
     }
    }
    
    public void Send_Message()
    {
        try
        {
            Transport transport_message= session.getTransport("smtp");
            transport_message.connect(email,pass);
            transport_message.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
            transport_message.close();
            System.out.println("CORREO ENVIADO");
        }catch(MessagingException ex)
        {
             System.out.println("ERROR "+ ex.getMessage());
        }
    }
    
    
    
    
       public void Create_Email2(String ruta) {
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.user", email);
        propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(propiedades);

        try {
            correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress(email));

            correo.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            correo.setSubject(motivo);

            // Cuerpo del mensaje HTML con una imagen incrustada
            String mensajeHTML = "<p>Este es un correo personalizado con una imagen Como?:</p>";
            mensajeHTML +="<img src=\""+ruta+"\" style=\"max-width: 100px; height: auto;\">";
            correo.setContent(mensajeHTML, "text/html");

            // Adjunta la imagen
            MimeBodyPart parteImagen = new MimeBodyPart();
            parteImagen.attachFile(ruta); // Reemplaza con la ruta de tu imagen
            parteImagen.setContentID("<imagen>");

            // Crea una parte mixta para combinar el mensaje y la imagen
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(parteImagen);

            correo.setContent(multipart);

            System.out.println("SE ACABA DE CREAR EL CORREO");
        } catch (MessagingException ex) {
            System.out.println("ERROR " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error al adjuntar la imagen: " + e.getMessage());
        }
    }

       
       public void Create_Email3(String ruta) {
    propiedades.put("mail.smtp.host", "smtp.gmail.com");
    propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    propiedades.setProperty("mail.smtp.starttls.enable", "true");
    propiedades.setProperty("mail.smtp.port", "587");
    propiedades.setProperty("mail.smtp.user", email);
    propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    propiedades.setProperty("mail.smtp.auth", "true");

    session = Session.getDefaultInstance(propiedades);

    try {
        correo = new MimeMessage(session);
        correo.setFrom(new InternetAddress(email));

        correo.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        correo.setSubject(motivo);

        // Cuerpo del mensaje HTML con una imagen incrustada
        String mensajeHTML = "<img src='data:image/jpeg;base64," + obtenerImagenBase64(ruta) + "' style='max-width: 100%; height: auto;'>";
        mensajeHTML += "<p>Este es un correo personalizado con una imagen:</p>";        
        correo.setContent(mensajeHTML, "text/html");

        System.out.println("SE ACABA DE CREAR EL CORREO");
    } catch (MessagingException ex) {
        System.out.println("ERROR " + ex.getMessage());
    }
}
       
    public void Send_Message2() {
        try {
            Transport transport_message = session.getTransport("smtp");
            transport_message.connect(email, pass);
            transport_message.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
            transport_message.close();
            System.out.println("CORREO ENVIADO");
        } catch (MessagingException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }
    
    
    private String obtenerImagenBase64(String ruta) {
    try {
       
        File file = new File(ruta);
        FileInputStream imageInFile = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        imageInFile.read(imageData);
        imageInFile.close();

        System.out.println();
        return Base64.getEncoder().encodeToString(imageData);
    } catch (IOException e) {
        System.out.println("Error al convertir la imagen a base64: " + e.getMessage());
    }

    return ""; // Retorna una cadena vacía si hay un error
}
    
    
}
