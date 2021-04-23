
package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class graphPanell extends JPanel{
    StructuresContainer sct;
    private String cords;//Zmienna do wypisywania wspolrzednych punktow w formie tekstu
    private Color pointColor = new Color(60,63,65 );
    private int pointBold = 11;// Grubosc punktu
    private final Font defaultFont = new Font("Serif",Font.ITALIC,12); //Domyslna czcionka
    private final Font boldedFont = new Font("default", Font.BOLD, 12); // Czcionka pogrubiona
    private final BasicStroke boldedLine = new BasicStroke(3);
    
        public graphPanell(StructuresContainer sct) {
            this.sct = sct;
        }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

                 g2d.setColor(pointColor);
                 g2d.setFont(boldedFont);
                 //pogrubienie czcionki opisujacej punkt
                
                //Rysowanie pojedynczych punktow na przestrzeni wizualizacyjnej (graphPanelu)
                for(Point p: sct.points ){
                    cords = "("+p.x+" , "+p.y+")";
                    g2d.drawString(cords, p.x, p.y-12); //Opis punktu (x,y)
                   // g2d.drawLine(p.x, p.y, p.x, p.y); 
                    g2d.fillOval(p.x, p.y, pointBold, pointBold); //Zamiast wykorzystywac drawLine do rysowania punktu wykorzystuje fillOval - tylko po to,aby punkt byl lepiej widoczny 
                }
                g2d.setFont(defaultFont);
                g2d.setStroke(boldedLine);
                
                //Rysowanie krawedzi na przestrzeni wizualizacyjnej (graphPanelu)
                for(Edge p: sct.edges ){                  
                    g2d.drawLine(p.getEdgeCords()[0].x, p.getEdgeCords()[0].y, p.getEdgeCords()[1].x, p.getEdgeCords()[1].y);
                }
                
               
	}
        
        
        
 }        



