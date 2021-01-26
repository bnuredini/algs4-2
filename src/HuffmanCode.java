import edu.princeton.cs.algs4.*;

public class HuffmanCode {

    private static final int R = 256;

    public static class Node implements Comparable<Node> {
        private int ch;
        private int freq;
        private Node left;
        private Node right;

        public Node(int ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return (left == null) && (right == null);
        }

        public int compareTo(Node x) {
            return this.freq - x.freq;
        }
    }

    public static void compress() {
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int[] freq = new int[R];

        // find frequencies
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++; 
        }

        // build the trie
        Node root = buildTrie(freq);

        // create the codeword table
        String[] st = new String[R];    
        buildCode(st, root , "");

        // write trie so it can expanded later
        writeTrie(root);

        BinaryStdOut.write(input.length);

        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                } else if (code.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                } else {
                    throw new IllegalStateException("Illegal state");
                }
            }
        }
    }

    private static Node buildTrie(int[] freq) {
        MinPQ<Node> pq = new MinPQ();

        for (int c = 0; c < freq.length; c++) {
            if (freq[c] > 1) pq.insert(new Node(c, freq[c], null, null));
        }

        while (pq.size() > 1) {
            Node left   = pq.delMin();
            Node right  = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
        }

        return pq.delMin();
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static Node readTrie() {
        if (BinaryStdIn.readBoolean()) {
            return new Node(BinaryStdIn.readChar(), 0, null, null);
        }
        return new Node('\0', 0, readTrie(), readTrie());
    }

    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        // else if (args[1].equals("+")) expand();
        else throw new IllegalArgumentException("Excepted a \'-\' or a \'+\'");
    }
}
