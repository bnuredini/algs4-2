/**
 * finds a substring pattern from some text by using
 * the brute force algorithm
 *
 * @author bleart
 */
public class BFSubstring {

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i+j) != pat.charAt(j)) break;
            }

            if (j == M) return i;   // pattern found
        }

        return N;   // pattern not found
    }

    public static int alternateSearch(String pat, String txt) {
        int i = 0;
        int j = 0;
        int n = txt.length();
        int m = pat.length();

        for (i = 0, j = 0; i < n && j < m; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j  = 0;
            }
        }

        if (j == m) return i - m;
        else        return n;       // pattern not found
    }

    public static void main(String[] args) {
        String text    = "hello, don't forget to attack at dawn";
        String pattern = "attack";

        System.out.println(BFSubstring.search(pattern, text));
    }
}
