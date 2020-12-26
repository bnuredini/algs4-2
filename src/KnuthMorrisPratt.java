public class KnuthMorrisPratt {

    private int R;
    private int m;          // length of pattern
    private int[][] dfa;

    public KnuthMorrisPratt(String pat) {
        this.R = 256;
        this.m = pat.length();
        dfa = new int[R][m];
        // construct dfa . . .
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];      // for mismatches
            }
            dfa[pat.charAt(j)][j] = j + 1;  // for matches
            x = dfa[pat.charAt(j)][x];      // update x
        }
    }

    public int search(String txt) {
        int n = txt.length();
        int i;
        int j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;  // pattern found (final state)
        else        return n;      // pattern not found
    }

    public static void main(String[] args) {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt("ababac");
        System.out.println(kmp.search("ffffffababac")); // returns where the pattern starts
    }
}
