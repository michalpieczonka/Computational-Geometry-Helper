
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithms {
    int maxRange = 580;
    int minRange = 10;
    
    Point[] generateRandomPoints(int numberOfPoints){
        Random r = new Random();
        Point[] generatedPoints = new Point[numberOfPoints];
        for (int i=0; i<numberOfPoints; i++){
           Point pTmp = new Point();
           pTmp.x = r.nextInt(maxRange - minRange)  + minRange;
           pTmp.y = r.nextInt(maxRange - minRange)  + minRange;
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
}
