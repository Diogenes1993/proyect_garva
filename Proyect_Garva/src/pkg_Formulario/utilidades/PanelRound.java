package pkg_Formulario.utilidades;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound  extends JPanel{

   
    
    public int getRound_top_left() {
        return round_top_left;
    }

    public void setRound_top_left(int round_top_left) {
        this.round_top_left = round_top_left;
        repaint();
    }

    public int getRound_top_right() {
        return round_top_right;
    }

    public void setRound_top_right(int round_top_right) {
        this.round_top_right = round_top_right;
        repaint();
    }

    public int getRound_bottom_left() {
        return round_bottom_left;
    }

    public void setRound_bottom_left(int round_bottom_left) {
        this.round_bottom_left = round_bottom_left;
        repaint();
    }

    public int getRound_bottom_right() {
        return round_bottom_right;
    }

    public void setRound_bottom_right(int round_bottom_right) {
        this.round_bottom_right = round_bottom_right;
        repaint();
    }
     private int round_top_left=0;
    private int round_top_right=0;
    private int round_bottom_left=0;
    private int round_bottom_right=0;
    
    public PanelRound()
    {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics graficas)
    {
        Graphics2D  grafic2=(Graphics2D) graficas.create();
        
        grafic2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        grafic2.setColor(getBackground());
        Area area=new Area(CreateRoundTopLeft());
        if(round_top_right>0)
        {
            area.intersect(new Area(CreateRoundTopRight()));
        }
        grafic2.fill(area);
        grafic2.dispose();
        super.paintComponent(graficas);
    }
    
    
    private Shape CreateRoundTopLeft()
    {
        int width=getWidth();
        int height=getHeight();
        
        int round_X=Math.min(width,round_top_left);
        int round_Y=Math.min(height,round_top_left);
        
        Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,round_X,round_Y));
        
        area.add(new Area(new Rectangle2D.Double(round_X/2,0,width - round_X/2,height)));
        area.add(new Area(new Rectangle2D.Double(0, round_Y/2, round_X/2,height-round_Y/2)));
        
        return area;
    }
    
    private Shape CreateRoundTopRight()
    {
        int width=getWidth();
        int height=getHeight();
        
        int round_X=Math.min(width,round_top_right);
        int round_Y=Math.min(height,round_top_right);
        
        Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,round_X,round_Y));
        
        area.add(new Area(new Rectangle2D.Double(0,0,width - round_X/2,height)));
        area.add(new Area(new Rectangle2D.Double(0, round_Y/2, round_X/2,height-round_Y/2)));
        
        return area;
    }
}
