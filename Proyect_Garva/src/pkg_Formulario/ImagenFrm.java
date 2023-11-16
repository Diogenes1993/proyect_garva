
package pkg_Formulario;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenFrm  extends JPanel{
    
    private Image imagen=null;

    public ImagenFrm() {

    }
    
    
    @Override
    public void paint(Graphics g)
    {
       imagen = new ImageIcon(getClass().getResource("../pkg_utilidades/images/imagen_01.jpeg")).getImage();
        g.drawImage(imagen, 0, 0,getWidth(),getHeight(),this);
        setOpaque(false);
        
        super.paint(g);
    }
    
}
