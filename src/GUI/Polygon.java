
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Polygon {
    List<Point> points;
    List<Edge> edges;
    
    public Polygon(){
        this.points = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
