/**
 * algorithm 5.2: MSD string sort
 * 
 * @author bleart
 */
public class MostSignificantDigit {

    private static final int R = 256;

    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, aux, 0, n-1, 0);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (lo >= hi) return;
        
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) { 
            count[r+1] += count[r];
        }

        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i - lo];
        }

        // recursively sort for each character
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r+1] - 1, d + 1);
        }
    }

    private static int charAt(String s, int d) {
        if (s.length() == d) return -1;
        return s.charAt(d);
    }

    public static void print(String[] a) {
        for (String s : a) {
            System.out.println(s);
        }
    }

    /*
    public static void sort(int[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
    */

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exch(String[] a, int v, int w) {
        String tmp = a[v];
        a[v] = a[w];
        a[w] = tmp;
    }

    public static void main(String[] args) {
        String[] a = {"170", "045", "075", "025", "002", "024", "802", "066"};
        //String[] a = {"now", "is", "the", "time", "for", "all", "good", "people", "to", "come", "to", "the", "aid", "of"};
        sort(a);
        print(a);
    }
}
