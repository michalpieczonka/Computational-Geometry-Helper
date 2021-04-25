
package GUI;
import java.util.Comparator;
import java.util.*;
import java.util.Random;

/**
 *
 * @author Michal
 */


public class Select {
    private static final Random random = new Random();

   //Wybor z listy i piwotowanie
    public static <T> T select(List<T> list, int left, int right, int n, Comparator<? super T> cmp) {
        for (;;) {
            if (left == right)
                return list.get(left);
            int pivot = pivotIndex(left, right);
            pivot = partition(list, left, right, pivot, cmp);
            if (n == pivot)
                return list.get(n);
            else if (n < pivot)
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }

    //Podzial na podstawie pivota
    private static <T> int partition(List<T> list, int left, int right, int pivot, Comparator<? super T> cmp) {
        T pivotValue = list.get(pivot);
        swap(list, pivot, right);
        int store = left;
        for (int i = left; i < right; ++i) {
            if (cmp.compare(list.get(i), pivotValue) < 0) {
                swap(list, store, i);
                ++store;
            }
        }
        swap(list, right, store);
        return store;
    }

    //Zamiana w liscie
    private static <T> void swap(List<T> list, int i, int j) {
        T value = list.get(i);
        list.set(i, list.get(j));
        list.set(j, value);
    }

    //Wybiernaie pivota
    private static int pivotIndex(int left, int right) {
        return left + random.nextInt(right - left + 1);
    }
}
