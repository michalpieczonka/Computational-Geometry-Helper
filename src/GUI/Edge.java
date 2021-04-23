
package GUI;

import java.awt.Point;

/**
 *
 * @author Michal
 */
public class Edge {
    
    Point [] vertices; //Tablica dla wierzcholkow bo krawedz sklada sie z poczatka i konca
    
    public Edge(){
        this.vertices = new Point [2];
    }
    
    public Edge (Point start, Point end) {
        this.vertices = new Point [2];
        vertices[0] = start;
        vertices[1] = end;
    }
    
    public Point[] getEdgeCords(){
        return vertices;
    }
}
