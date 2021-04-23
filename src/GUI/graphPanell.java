
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class graphPanell extends JPanel{
    StructuresContainer sct;
        public graphPanell(StructuresContainer sct) {
            this.sct = sct;
        }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

                 g2d.setColor(Color.BLUE);
		// prostokat
		g2d.drawRect(10, 10, 380, 380);
		// kolo
                //dla lini to samo tylko dodac tolerancje+/- 20px i juz :)
		g2d.drawOval(10, 10, 380, 380);
                
                //Rysowanie pojedynczych punktow na przestrzeni wizualizacyjnej (graphPanelu)
                for(Point p: sct.Points ){
                    g2d.drawLine(p.x, p.y, p.x, p.y);
                }
                
                //Rysowanie krawedzi na przestrzeni wizualizacyjnej (graphPanelu)
                for(Edge p: sct.Edges ){                  
                    g2d.drawLine(p.getEdgeCords()[0].x, p.getEdgeCords()[0].y, p.getEdgeCords()[1].x, p.getEdgeCords()[1].y);
                }
                
               
	}
        
        public void addPoint(){     
            repaint();
        }
        
        
 }        



