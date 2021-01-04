/**
 * Boyer-Moore algorithm for the substring search problem
 *
 * @author bleart
 */
public class BM {

    private int[] right;
    private String pat;
    private final int R = 256;

    public BM(String pat) {
        this.pat = pat;
        int m = pat.length();
        // compute right[]
        right = new int[R];
        for (int c = 0; c < R; c++) 
            right[c] = -1;
        for (int j = 0; j < m; j++)
            right[pat.charAt(j)] = j;
    }

    public int search(String txt) {
        int n = txt.length();
        int m = pat.length();
        int skip;
        for (int i = 0; i <= n-m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }

            if (skip == 0) return i;    // pattern match
        }

        return n;                       // no pattern match
    }

    public static void main(String[] args) {
        String text    = "rrahmanierrotulloirrotenrrethrrajesserrushit";
        String text2   = "irreth";
        String pattern = "rreth";
        BM boyerMoore  = new BM(pattern);
        System.out.println(boyerMoore.search(text2));
    }
}
