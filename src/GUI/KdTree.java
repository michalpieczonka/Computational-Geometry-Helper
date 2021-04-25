
package GUI;

import java.util.List;
import java.util.Comparator;

/**
 *
 * @author Michal
 */
//Klasa glowna zawierajaca cale drzewo
public class KdTree {
    private Node root = null; //Korzen
    private Node nearestLeaf = null; //Najblizszy lisc
    private double shortestDistance = 0; //Najmniejszy dystans
    private int visited = 0; //Licznik odwiedzonych wezlow

    //Stworzenie drzewa od korzenia
    public KdTree( List<Node> nodes) {
        root = makeTree(nodes, 0, nodes.size(), 0);
    }
    

    //Znajdowanie najblizszego wezla , argumentem jest punkt o zadanych wspolzrednych
    //Jest to tak naprawde "podfunkcja" ktora wywoluje wlasciową funkcje szukajaca, ktora bedzie dzialala rekurencyjnie przez cale drzewo
    public Node findNearest(Node target) {
        if (root == null)
            return null; //Jesli drzewo jest puste
        nearestLeaf = null;
        visited = 0;
        shortestDistance = 0;
        nearest(root, target, 0);
        return nearestLeaf;
    }

    //odwiedzone
    public int visited() {
        return visited;
    }

    //obliczanie dystansu
    public double distance() {
        return Math.sqrt(shortestDistance);
    }

    //Wlasciwa funkcja rekurencyjna odpowiedzialna za znajdowanie najblizszego wezla (target) w zadanym "aktualnym" wezle, root bedzie zmienial sie  co rekurencyjne wywolanie,
    // target jest zawsze staly
    private void nearest(Node root, Node target, int index) {
        if (root == null)
            return;
        ++visited;
        double d = root.distance(target);
        //Jesli najblizszy lisc jest nulem lub obliczone d jest mniejsze niz aktualny najmniejszy dystans
        if (nearestLeaf == null || d < shortestDistance) {       
            shortestDistance = d; //Nowy najkrotszy dystans jest teraz d
            nearestLeaf = root; //Zmiana najblizszego liscia na wezel 'root' w danym wywolaniu

        }
        if (shortestDistance == 0 ) //Jesli dystans jest 0 to wyjdz
            return;
        double dx = root.get(index) - target.get(index); //Obliczenie nastepnego podzialu
        index = (index + 1) % 2; //Podzial na pol
        nearest(dx > 0 ? root.left_ : root.right_, target, index); //Jesli obliczone dx jest wieksze niz 0 to przechodzimy szukac w lewym wezle jesli wieksze to w prawym
        if (dx * dx >= shortestDistance ) //Jesli
            return;
        nearest(dx > 0 ? root.right_ : root.left_, target, index); //Jesli obliczone dx jest wieksze od 0 to przechodzimy szukac w prawym podrzewie inaczej w lewym
    }

    private Node makeTree(List<Node> nodes, int begin, int end, int index) {
        if (end <= begin)
            return null;
        int n = begin + (end - begin)/2; //wyznaczenie 'miejsca' podzialu 'przestrzeni na pol'
        //Utworzenie "duzego wezla", ktory potem zostanie podzielony na pol i "wrzucenie" do niego punktow
        Node node = Select.select(nodes, begin, end - 1, n, new NodeComparator(index)); //Teraz utworzenie dla ktorejs ze stron nowego wezla i wrzucenie do niego wszystkich punktow na lewo
        index = (index + 1) % 2; //znowu wyznaczenie podzialu
        node.left_ = makeTree(nodes, begin, n, index); //zbudowanie lewego wezla w ktorym operacja sie powtarza az w kazdym wezle nie bedzie pojedynczego liscia
        node.right_ = makeTree(nodes, n + 1, end, index); //i prawego wezla tak samo
        return node;
    }


    //Pomocnicza klasa zeby umozliwic porownywanie wezlow zamiast rozpisywac same wspolrzedne i porwnwyac
    private static class NodeComparator implements Comparator<Node> {
        private int index_;

        private NodeComparator(int index) {
            index_ = index;
        }
        public int compare(Node n1, Node n2) {
            return Double.compare(n1.get(index_), n2.get(index_));
        }
    }

    //Klasa reprezentujaca wezel
    public static class Node {
        double[] Coords;
        private Node left_ = null; //Lewy wezel/galaz do lewego wezla
        private Node right_ = null; //Prawy wezel/galaz do prawego wezla

        public Node(double[] coords) { //Wspolrzedne graniczne wezla/konstruktor
            Coords = coords;
        }
        public Node(double x, double y) {
            this(new double[]{x, y});
        }
        double get(int index) {
            return Coords[index];
        }

        //Obliczenie odleglosci
        double distance(Node node) {
            double dist = 0;
            for (int i = 0; i < Coords.length; ++i) {
                double d = Coords[i] - node.Coords[i];
                dist += d * d;
            }
            return dist;
        }

    }
}

