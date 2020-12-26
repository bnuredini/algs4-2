public class SubstringSearch {

    public static int search(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n-m; i++) {
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i+j) != pat.charAt(j)) break; // compare txt's i+j-th char w/ pat's 
            }                                                // j-th char
            if (j == m) return i;
        }

        return n;   // not found
    }
}
