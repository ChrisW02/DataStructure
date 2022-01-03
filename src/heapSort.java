import java.util.Arrays;
import java.util.*;

public class heapSort {


    /**
     * @author Yixin Cao (November 1, 2020)
     * <p>
     * The in-place version of heapsort
     */

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     * The element at index c bubbles up the heap.
     * <p>
     * Running time O( log n ), or more precisely, O( log size ).
     */
    private static void up(int[] a, int c) {
        if (c == 0) return;         // already the root (index 0)
        int p = (c - 1) / 2;        // get the father node
        if (a[c] <= a[p]) return;   // if child node is smaller, return directly
        swap(a, c, p);
        up(a, p);                   // continue from the father node (as the child node)
    }

    /**
     * The element at index p bubbles down the heap.
     * Unlike up, we need to pass <em>size</em>.
     *
     * @param p    the current node under consideration
     * @param size the size of the current heap, from index 0 to index size - 1.
     *             <p>
     *             Running time O( log n ), or more precisely, O( log size ).
     */
    private static void down(int[] a, int p, int size) {
        if (p * 2 + 2 > size) return;   // over bound (already the leaf)
        int larger = p * 2 + 1;         // get left child node
        if (larger + 1 < size && a[larger] < a[larger + 1]) // check if right child node is larger
            larger++;                                       // turn to right child node
        if (a[p] >= a[larger]) return;  // if father node is larger, return directly
        swap(a, p, larger);
        down(a, larger, size);          // continue from the larger child node (as the father node)
    }

    /**
     * The in-place heapsort algorithm.
     * <p>
     * First, include elements into the virtual heap one by one.
     * Second, remove the max from the virtual heap one by one.
     * <p>
     * Running time O( n log n ).
     */
    public static void heapsort(int[] a) {

        for (int i = 1; i < a.length; i++)
            up(a, i);

        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);  // similar to removeMax.
            down(a, 0, i);
        }
    }

    public static void main(String args[]) {
        /*
         * testing with random data.
        int size = 10;
        int[] a = new int[size];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(size);
         */

        int testData[][] = { // try different inputs.
                {10, 8, -4, 89, 2, 0, 4, -19, 200},
                {5, 4, 3, 2, 1, 1, 0, 0, -1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                {1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8},
                {3, 2, 6, 13, 8, 4, 10, 7, 14, 11, 12, 5, 9},
                {65, 85, 17, 88, 66, 71, 45, 38, 95, 48, 18, 68, 60, 96, 55},
                {10, 8, 14, 89, 32, 50, 77, 38}
        };
        for (int[] a : testData) {
            System.out.println("The original array: " + Arrays.toString(a));
            heapsort(a);
            System.out.println("Sorted: " + Arrays.toString(a));
        }
    }

    // iterative version
    private static void iUp(int[] a, int c) {

        for (int i = 1; i < c; i++) {
            int parent = (i - 1) / 2;
            if (a[i] > a[parent]) {
                int j = i;
                while (a[j] > a[(j - 1) / 2]) {
                    swap(a, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    // iterative version
    private static void iDown(int[] a, int p) {

        for (int i = p - 1; i > 0; i--) {
            swap(a, i, 0);
            int j = 0, index;

            do {
                index = (j * 2 + 1); // Left Child Node
                if (index + 1 < i && a[index] < a[index + 1]) index++; // Larger Child Node
                if (index < i && a[j] < a[index])
                    swap(a, j, index);
                j = index;
            } while (index < i);
        }
    }
}