public class LZWCompression {

    private static final int R = 256;
    private static final int L = 4096;
    private static final int W = 12;

    // this class should not be instanciated
    private LZWCompression() {}

    public void compress() {
        String input = BinaryStdIn.readString();
        TernarySearchTrie<Integer> tst = new TernarySearchTrie<>();

        // fill the TST with ASCII characters
        for (int i = 0; i < R; i++) {
            st.put("" + (char) i, i);
        }
        int code = R+1;

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input); 
            BinaryStdOut.write(s);
            int l = s.length();
            if (l < input.length() && code < L) {
                st.put(input.substring(0, l+1), code++);
            }
            input = input.substring(l);
        }
    }
}
