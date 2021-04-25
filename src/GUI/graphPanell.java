
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
    private Color convexHullColor = new Color(255,0,0);
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
                 
          if (sct.convexHullEnabled == true){
              Point prev = null; //Punkt pomocniczy, potrzebny do rysowania lini, poczatkowo jest nullem, a potem przy kazdej iteracji
                                //przez liste punktow stanowiacych otoczke wypukla jest ustawiany na ten juz "przeiterowany".
              Point firstPoint = sct.convexHullResult.get(0); //Pomocniczy punkt, bedzie potrzebny pozniej
              
              
                    for (Point p: sct.convexHullResult){
                        
                    g2d.setStroke(boldedLine);                        
                    g2d.setColor(pointColor);
                    cords = "("+p.x+" , "+p.y+")";
                    g2d.drawString(cords, p.x, p.y-12); //Opis punktu (x,y)
                    g2d.drawLine(p.x, p.y, p.x, p.y);  //narysowanie punktow
                    
                    if (prev !=null){ //Jesli nie jest to pierwsza iteracja to:
                        g2d.setColor(convexHullColor);
                        g2d.drawLine(prev.x, prev.y, p.x, p.y);
                    }
                    
                    prev = p;   //Ustawienie aktualnego poprzednika do nastepnej iteracji                 
                  }
                    
                g2d.drawLine(firstPoint.x,firstPoint.y,prev.x,prev.y); //Dorysowanie brakujacej lini pomiedzy punktem poczatkowym, a punktem ostatnim
                sct.setConvexHullDisabled(); //Wylaczenie otoczki wypuklej po narysowaniu aby umozliwic "rysowanie" kolejnych punktow
                }
          
          else{
               //Rysowanie pojedynczych punktow na przestrzeni wizualizacyjnej (graphPanelu)
                for(Point p: sct.points ){
                    cords = "("+p.x+" , "+p.y+")";
                    g2d.drawString(cords, p.x, p.y-12); //Opis punktu (x,y)
                    //g2d.drawLine(p.x, p.y, p.x, p.y); 
                    g2d.fillOval(p.x, p.y, 4, 4);
                   // g2d.fillOval(p.x, p.y, pointBold, pointBold); //Zamiast wykorzystywac drawLine do rysowania punktu wykorzystuje fillOval - tylko po to,aby punkt byl lepiej widoczny 
                }
                g2d.setFont(defaultFont);
                g2d.setStroke(boldedLine);
                
                //Rysowanie krawedzi na przestrzeni wizualizacyjnej (graphPanelu)
                for(Edge p: sct.edges ){                  
                    g2d.drawLine(p.getEdgeCords()[0].x, p.getEdgeCords()[0].y, p.getEdgeCords()[1].x, p.getEdgeCords()[1].y);
                }
          }

                

                
               
	}
        
        
        
 }        



