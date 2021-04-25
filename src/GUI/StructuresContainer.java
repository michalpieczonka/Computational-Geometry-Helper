
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class StructuresContainer {
List <Point> points; //Lista do przechowywania punktow  
List <Edge> edges; //Lista do przechowywania krawedzi
List <Polygon> polygons;
List <Point> convexHullResult; //Lista do przechowywania wyniku zawierajacego otoczke wypukla
boolean convexHullEnabled = false; //Zmienna do wlaczania lub wylaczania algorytmu otoczki wypuklej
Algorithms algorithms = new Algorithms(); //Utworzenie instancji klasy zawierajacej wszystkie algorytmy
boolean isKdTreeEnabled = false; //Zmienna do wlaczania lub wylaczania drzew kd - potrzebna do uzyskania odpowiednich pozniejszych wizualizacji
KdTree kdTree;
List <KdTree.Node> treeElements; //Lista przekonwertowanych punktow jako liscie w drzewie kd, ktore zostanie utworzone w razie potrzeby
List <Point> closestPoints; //Lista do przechowywania dwoch punktow bedacych najblizej siebie, bedzie potrzebna do odpowiedniej wizualizacji

public StructuresContainer(){
    this.points = new ArrayList<>();
    this.edges = new ArrayList<>();
    this.polygons = new ArrayList<>();
    this.convexHullResult = new ArrayList<>();
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
              //System.out.println(h.x+" "+h.y);
              break;
          }
    }
        return foundedPoint;
}

//Uruchomienie otoczki wypuklej
 public void setConvexHullEnabled (){
     this.convexHullEnabled = true;
 }
 
 //Wylaczenie otoczki wypuklej
  public void setConvexHullDisabled (){
     this.convexHullEnabled = false;
 }

  //Metoda uruchamia tworzenie drzewa KD na podstawie wszystkich punktow znajdujacych sie w liscie points
  public void enableAndBuildKdTREE(Point p){
      isKdTreeEnabled = true;
      treeElements = new ArrayList<>();
      //Dodanie wszystkich punktow do listy elementow/lisci drzewa KD 
      for (int i=0; i<points.size(); i++){
          if (p != points.get(i)){
              this.treeElements.add(new KdTree.Node(points.get(i).x,points.get(i).y));
          }
      }
      //Stworzenie drzewa KD
      this.kdTree = new KdTree(treeElements);
      
  }
  
  //Metoda wyszukuje w wczesniej utworzonym drzewie KD punkt, ktory znajduje sie najblizej punktu przekazanego jako parametr
  public double [] findClosestPointInKdTree(Point p){
      double []closestPointInTree = new double [2];
      
      //Wyszukanie i przypisanie do tablicy double, po to zeby nie dodawac kolejnych importow w klasie MainGui
      KdTree.Node closestNode = kdTree.findNearest(new KdTree.Node(p.x,p.y));
      closestPointInTree[0] = closestNode.Coords[0];
      closestPointInTree[1] = closestNode.Coords[1];
      
      //Zainicjowanie nowej tymczasowej listy najblizszych punktow, aby umozliwic jej narysowanie na graphPanelu
      closestPoints = new ArrayList<>();
      closestPoints.add(p);
      closestPoints.add((new Point ((int)(closestNode.Coords[0]),(int)(closestNode.Coords[1]))));
      return closestPointInTree;   
  }
  
  //Zresetowanie danych w drzewie kd
  public void disableKdTree (){
      this.kdTree = null;     
      this.treeElements = null;
      this.closestPoints = null;
  }
  
}
