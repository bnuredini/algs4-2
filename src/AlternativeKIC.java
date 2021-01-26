import edu.princeton.cs.algs4.*;

/**
 * 5.1.7 Develop an implementation of key-indexed counting 
 * that makes use of an array of Queue objects.
*/
@SuppressWarnings({"unchecked", "deprecated"})
public class AlternativeKIC {

    private static final int R = 256;

    public static void sort(char[] a) {
        Queue<Character>[] count = new Queue[R];  
        for (int r = 0; r < R; r++) {
            count[r] = new Queue<>();
        }

        for (int i = 0; i < a.length; i++) {
            count[a[i]].enqueue(a[i]);
        }

        int j = 0;
        for (int r = 0; r < R; r++) {
            while (!count[r].isEmpty()) {
                a[j++] = count[r].dequeue();
            }
        }
    }

    public static void printCharArray(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        char[] arr = {'c', 'h', 'a', 'r', 'a', 'r', 'r', 'a', 'y'};
        sort(arr);
        printCharArray(arr);
    }
}
