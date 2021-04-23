
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class StructuresContainer {
List <Point> Points; //Lista do przechowywania punktow  
List <Edges> Edges; //Lista do przechowywania krawedzi

public StructuresContainer(){
    this.Points = new ArrayList<>();
    this.Edges = new ArrayList<>();
}
}
