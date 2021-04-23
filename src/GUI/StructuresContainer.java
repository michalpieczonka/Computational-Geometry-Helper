
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class StructuresContainer {
List <Point> Points; //Lista do przechowywania punktow  
List <Edge> Edges; //Lista do przechowywania krawedzi

public StructuresContainer(){
    this.Points = new ArrayList<>();
    this.Edges = new ArrayList<>();
}

//Metoda pomocnicza - majaca sprawdzic czy dany punkt w przestrzeni(ustalony poprzez klikniecie w przestrzen) znajduje sie 
//w tablicy Points. Inaczej sprawdzenie czy taki punkt wogole zostal dodany. Dodatkowa tolerancja aby ulatwic klikanie.
//Jesli punkt znajduje sie w tablicy to metoda zwraca true, inaczej false.
public boolean isPointInSurface(Point p){
    boolean contains = false;
        for (Point h: Points){
          if (Math.abs( h.x - p.x ) <= 10 && Math.abs( h.y - p.y ) <= 10){ //Sprawdzenie z tolerancja czy dany punkt jest na liscie (10 px tolerancji aby ulatwic klikanie i tworzenie krawedzi)
              contains = true;
              break;
          }
    }
        return contains;
}

}
