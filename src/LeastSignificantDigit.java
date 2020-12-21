/**
 * algorithm 5.1: LSD string sort
 *
 * performs key-indexed counting W-times to get the
 * array of strings (of equal length) in order, where
 * W is the length of each string.
 *
 * @author bleart
 */
public class LeastSignificantDigit {

    // sort array of Strings that have w characters
    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            int[] count = new int[R+1];

            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d)+1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }

            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void print(String[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = {"170", "145", "375", "290", "992", "802", "112", "166"};
        LeastSignificantDigit.sort(a, 3);
        LeastSignificantDigit.print(a);
    }
}
