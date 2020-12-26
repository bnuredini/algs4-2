/**
 * algorithm 5.5: TST symbol table
 *
 * @author bleart
 */
public class TernarySearchTries<Value> {

    private Node root;

    public class Node {
        private Value val;
        private char c;
        private Node left;
        private Node middle;
        private Node right;
    }
    
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }

        if      (x.c < c)              x.right  = put(x.right, key, val, d);
        else if (x.c > c)              x.left   = put(x.left, key, val, d); 
        else if (d < key.length() - 1) x.middle = put(x, key, val, d+1);
        else                           x.val    = val;
        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;

        int cmp = Integer.compare(key.charAt(d), x.c); 
        if (cmp == -1) {
            return get(x.left, key, d);
        } else if (cmp == 1) { 
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.middle, key, d + 1);
        } else {
            return x;
        }
    }
}
