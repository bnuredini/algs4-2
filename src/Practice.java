import edu.princeton.cs.algs4.*;

public class Practice {

    private Node root;

    private static class Node {
        private Node[] next;
        private int val;

        public int getValue() {  return val;  }
    }

    public int get(String key) {
        return get(root, key, 0);
    }

    private int get(Node x, String key, int d) {
        if (x == null) return null;

        
    }

    public void put(String key, int val) {
        this.root = put(root, ket, val, 0);
    }

    private Node put(Node x, String key, int val, int d) {
        if (x == null) {
            return new Node(val);
        }

        int cmp = x.next[key.charAt(d)].compareTo(key);
    }
}
