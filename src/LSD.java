import java.util.Arrays;

public class LSD {

    public static final int R = 256;

    public static void sort(String[] a, int w) {
        int n = a.length;

        for (int col = w - 1; col >= 0; col--) {
            int[] count = new int[R + 1];

            for (String s : a) {
                count[s.charAt(col) + 1]++;
            }

            for (int r = 0; r < R - 1;  r++) {
                    count[r + 1] += count[r];
            }

            String[] aux = new String[n];
            for (String s : a) {
                aux[count[s.charAt(col)]++] = s;
            }

            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "dad", "yes", "zoo", "now", "for", "tip", "ilk", "dim", "tag"};

        sort(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
