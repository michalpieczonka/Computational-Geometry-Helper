
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class StructuresContainer {
List <Point> points; //Lista do przechowywania punktow  
List <Edge> edges; //Lista do przechowywania krawedzi
List <Polygon> polygons;
Algorithms algorithms = new Algorithms();

public StructuresContainer(){
    this.points = new ArrayList<>();
    this.edges = new ArrayList<>();
    this.polygons = new ArrayList<>();
}

//Metoda pomocnicza - majaca sprawdzic czy dany punkt w przestrzeni(ustalony poprzez klikniecie w przestrzen) znajduje sie 
//w tablicy Points. Inaczej sprawdzenie czy taki punkt wogole zostal dodany. Dodatkowa tolerancja aby ulatwic klikanie.
//Jesli punkt znajduje sie w tablicy to metoda zwraca true, inaczej false.
//public boolean isPointInSurface(Point p){
//    boolean contains = false;
//        for (Point h: points){
//          if (Math.abs( h.x - p.x ) <= 9 && Math.abs( h.y - p.y ) <= 9){ //Sprawdzenie z tolerancja czy dany punkt jest na liscie (10 px tolerancji aby ulatwic klikanie i tworzenie krawedzi)
//              contains = true;
//              break;
//          }
//    }
//        return contains;
//}
public Point isPointInSurface(Point p){
    Point foundedPoint = null;
        for (Point h: points){
          if (Math.abs( h.x - p.x ) <= 9 && Math.abs( h.y - p.y ) <= 9){ //Sprawdzenie z tolerancja czy dany punkt jest na liscie (10 px tolerancji aby ulatwic klikanie i tworzenie krawedzi)
              foundedPoint = h;
              System.out.println(h.x+" "+h.y);
              break;
          }
    }
        return foundedPoint;
}

}
