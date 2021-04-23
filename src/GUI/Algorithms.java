
package GUI;

import java.awt.Point;
import java.util.Random;

public class Algorithms {
    int maxRange = 580;
    int minRange = 10;
    
    Point[] generateRandomPoints(int numberOfPoints){
        Random r = new Random();
        Point[] generatedPoints = new Point[numberOfPoints];
        for (int i=0; i<numberOfPoints; i++){
           Point pTmp = new Point();
           pTmp.x = r.nextInt() * (maxRange - minRange + 1) + minRange;
           pTmp.y = r.nextInt() * (maxRange - minRange + 1) + minRange;
           generatedPoints[i] = pTmp;
        }
        return generatedPoints;
    }
}
