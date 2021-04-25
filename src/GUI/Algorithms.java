
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithms {
    int maxXRange = 580;
    int minXRange = 10;
    int maxYRange = 490;
    int minYRange = 10;
    
    //Losowanie wspolrzednych dla losowych punktow
    Point[] generateRandomPoints(int numberOfPoints){
        Random r = new Random();
        Point[] generatedPoints = new Point[numberOfPoints];
        for (int i=0; i<numberOfPoints; i++){
           Point pTmp = new Point();
           pTmp.x = r.nextInt(maxXRange - minXRange)  + minXRange;
           pTmp.y = r.nextInt(maxYRange - minYRange)  + minYRange;
           generatedPoints[i] = pTmp;
        }
        return generatedPoints;
    }
    
    List<Point> convexHull (List<Point> points){
        int numberOfPoints = points.size();
         //Co najmniej 3 punkty zeby wyznaczyc otoczke wypukla
        if (numberOfPoints < 3)
            return null;
        
        //Wynik bedzie przechowywany w liscie punktow
        List<Point> Convexhull = new ArrayList<>();
        
        // najpierw znajduje najbardziej skrajny lewy punkt czyli iteruje po x'ach
        int l = 0;
        for (int i = 1; i < numberOfPoints; i++)
            if (points.get(i).x < points.get(l).x)
                l = i;
        
        // Jak znajde najbardziej skrajny lewy punkt to sprawdzma po kolei
        // przeciwnie do ruchu wskazowek zegara do poki nie dojde ponownie do punktu
        //z ktorego zaczalem
        int p = l, q;
        
         //Petla dziala tak dlugo jak nie przejdziemy przez wszysktie punkty az do tego ktory zostal wyznaczony jako poczatkowy
        do
        {
            //Dodaje kolejny punkt do zbioru wchodzacego w sklad otoczki wypuklej
            Convexhull.add(points.get(p));

            // Wyszukiwanie punktu ktory z punktem p po x'ach ma tworzy orientacje/uklad przeciwny do ruchu wskazowek zegara
            // Zapamietuje ostatnio odwiedzony punkt, ktory spelnial powyzszy warunek i byl najbardziej sklajny po lewej
            // Jezeli jakis inny punkt przy iterowaniu bedzie bardziej na lewo niz q to zmieniam aktualny q na wlasnie ten punkt
            q = (p + 1) % numberOfPoints;

            for (int i = 0; i < numberOfPoints; i++)
            {
                //Sprawdzenie czy punkt w tej iteracji jest bardziej na lewo niz q i spelnia warunki
                if (positioning(points.get(p), points.get(i), points.get(q)) == 2)
                    q = i;
            }


            // Po przejsciu przez wszystkie punkty, wyznaczone q jest najbardziej skrajnym punktem w stosunku do p
            // Wiec teraz p zostaje nowym q a q jest dodawane do zbioru tworzacego otoczke wypukla
            p = q;

        } while (p != l);
        
        return Convexhull;
    }
    
        //  Metoda odpowiedzialna za sprawdzenie orientacji 3 punktow wzgledem siebie
    // 0 --> p, q oraz r sa rownolegle
    // 1 --> orientacja zgodna z kierunkiem ruchu wskazowek zegara
    // 2 --> przeciwnie do ruchu wskazowek zegara
    int positioning(Point p, Point q, Point r)
    {
        double orientation = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (orientation == 0)
            return 0; //rownolegle
        else if (orientation > 0 )
            return 1; //zgodnie z ruchem wskazowek
        else
            return 2;// przeciwnie do ruchu wsazowek zegara
    }
    
    //Metoda obliczajaca i zwracajca rownanie przeslanej lini 
    //Linia zawiera w sobie 2 punkty - poczatek i koniec - w tablicy
    //Poczatek znajduje sie w indeksie 0, koniec w indeksie 1
    String lineEquation (Edge e){
        String equation = "";
        
        double a =  (double)((e.vertices[0].y - e.vertices[1].y))/ (double)((e.vertices[0].x - e.vertices[1].x)) ;  
        double b = e.vertices[0].y - a*(double)((e.vertices[0].x));       
        equation = "y = "+a+"*x + "+b;
        return equation;
    }
    
    //Metoda obliczajaca punkt przeciecia dwoch lini podanych  jako argumenty
   //Metoda bazuje na wzorach Cramera oraz dodatkowej metodzie, calcGeneralCharacter, ktora
    //Pozwala wyznaczyc rownanie ogolne prostej (nie kierunkowe), niezbedne do obliczen we wzorach Cramera
       Point crossingPointCramerMod (Edge l1, Edge l2){
        Point resultPoint = new Point();
        double []abforL1 = new double [3];
        double []abforL2 = new double [3];
        abforL1 = calcGeneralCharacter(l1.vertices[0],l1.vertices[1]); //Postac ogolna Ax+By+C=0 
        abforL2 = calcGeneralCharacter(l2.vertices[0],l2.vertices[1]); //Vertices[0] - glowa/poczatek linii ; Vertices[1] - ogon/koniec linii

        double x,y,W,Wx,Wy;
        W = abforL1[0]*abforL2[1] - abforL2[0]*abforL1[1];
        Wx = (-1*abforL1[2])*abforL2[1]- ( -1*abforL2[2]*abforL1[1]);
        Wy = (abforL1[0]* (-1*abforL2[2])) - (abforL2[0]*(-1*abforL1[2]));
        x = Wx/W;
        y = Wy/W;
        resultPoint.x = (int) x;
        resultPoint.y = (int) y;
        return resultPoint;
        //System.out.println("Punkt przeciecia: ("+x+" , "+y+")");
    }
       
       //Metoda wyznacza A,B,C z rownania ogolnego prostej na podstawie dwoch zawartych w niej punktow
       double[] calcGeneralCharacter(Point p1,Point p2){
        double []tab = new double [3];
        tab[0] = p1.y - p2.y; //A
        tab[1] = p2.x - p1.x; //B
        tab[2] = (p1.x - p2.x)*p1.y + (p2.y-p1.y)*p1.x; //C
        return tab;
    }
       
       //Metoda oblicza pole trojkata bazujac na jego 3 wierzcholkach, bedacych punktami
       double areaOfTriangle(Point p1, Point p2, Point p3){
        double area = 0.5*( (p2.x-p1.x)*(p3.y-p1.y) - (p3.x-p1.x)*(p2.y-p1.y));
        if (area < 0 )
            area = area * -1;
        return area;
    }
       
       //Metoda sprawdzajaca czy trojkat mozna zbudowac z podanych wierzcholkow
       boolean isTrianglePossible(Point p1, Point p2, Point p3){
           boolean possible;
           int a = p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y);
           if (a == 0)
               possible = false;
           else
               possible = true;
           
           return possible;
       }
       
       
      //Metoda sprawdzajaca po ktorej stronie podanej lini znajduje sie podany punkt
      //Metoda zwraca stringa, ktory zostanie pozniej wypisany w optionPane
     String whichSide(Edge l1, Point p3){
        String result = "";
        int checker = (l1.vertices[1].y - l1.vertices[0].y)*p3.x + (l1.vertices[0].x-l1.vertices[1].x)*p3.y + (l1.vertices[1].x*l1.vertices[0].y - l1.vertices[0].x*l1.vertices[1].y);
        if (checker < 0 )
            result = "Punkt ("+p3.x+","+p3.y+") znajduje sie z prawej strony prostej";
        else if ( checker > 0)
            result = "Punkt ("+p3.x+","+p3.y+") znajduje sie z lewej strony prostej";
        else
            result = "Punkt ("+p3.x+","+p3.y+") znajduje sie na prostej";
        
        return result;
    }

       
       
}
