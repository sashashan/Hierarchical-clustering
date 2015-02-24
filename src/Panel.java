import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;


public class Panel extends JPanel {
	
	public void paint(Graphics g)
        {
	 	Graphics2D g2 = (Graphics2D) g;
	 	g2.setColor(Color.white);
                g2.fillRect(0, 0, 700, 700);
                g2.setColor(Color.black);
                g2.drawLine(0, 700, 700, 700); // y
                g2.drawLine(0, 0, 0, 700); // x

        
        for(int i=0; i<Hcluster.data.length; i++)
        {
        	//Shape p = new Ellipse2D.Double(data[i].x, data[i].y, data[i].x, data[i].y);
        	double first = Hcluster.data[1].cluster;
        	if(Hcluster.data[i].cluster == first)
        		g2.setColor(Color.blue);
        	else {
        		g2.setColor(Color.red);
        	}
        	//System.out.println("test");
        	Shape l = new Ellipse2D.Double(700 - (Hcluster.data[i].x)*250 - 20, 700 - (Hcluster.data[i].y)*250 - 20, 10, 10);
        	g2.draw(l);
        }

        
        
 }
}
