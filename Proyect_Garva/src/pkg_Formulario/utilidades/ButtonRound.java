package pkg_Formulario_utilidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonRound extends JButton {
 

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor_hover() {
        return color_hover;
    }

    public void setColor_hover(Color color_hover) {
        this.color_hover = color_hover;
    }

    public Color getColor_click() {
        return color_click;
    }

    public void setColor_click(Color color_click) {
        this.color_click = color_click;
    }

    public Color getBorder_color() {
        return border_color;
    }

    public void setBorder_color(Color border_color) {
        this.border_color = border_color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
       
    public ButtonRound()
    {
        setColor(Color.BLUE);
        
        color_hover=new Color(63,81,244);
        color_click=new Color(56,72,219);
        border_color=new Color(56,72,219);
        
        
        setContentAreaFilled(false);
        
        
        addMouseListener(new MouseAdapter()
        {
           @Override
           public void mouseEntered(MouseEvent me)
           {
             setBackground(color_hover);
             hover=true;
           }
           
           @Override
           public void mouseExited(MouseEvent me)
           {
             setBackground(color);
             hover=false;
           }
           
           @Override
           public void mousePressed(MouseEvent me)
           {
             setBackground(color_click);
           }
           
           @Override
           public void mouseReleased(MouseEvent me)
           {
               if(hover)
               {
                   setBackground(color_hover);
               }else
               {
                   setBackground(color);
               }
           }
        });
        
    }
    
    private boolean hover;
    private Color color;
    private Color color_hover;
    private Color color_click;
    private Color border_color;
    
    private int radius = 0;
    
    @Override
    protected void paintComponent(Graphics gra)
    {
        Graphics2D g2=(Graphics2D) gra;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(border_color);
        g2.fillRoundRect(0, 0, getWidth(),getHeight(),radius, radius);
        g2.setColor(getBackground());
        
        g2.fillRoundRect(2, 2, getWidth()-4,getHeight()-4,radius, radius);
        
        super.paintComponent(gra);
        
    }
    
    
}
