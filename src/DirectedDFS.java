import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.In;

/**
 *  
 */
public class DirectedDFS {

    private boolean[] marked;
    private int[] edgeTo;
    private Queue<Integer> pre;         // preorder
    private Queue<Integer> post;        // postorder
    private Stack<Integer> reversePost; // reverse postorder

    public DirectedDFS(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        pre    = new Queue<Integer>();
        post   = new Queue<Integer>();
        reversePost = new Stack<Integer>();

        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Graph g, int v) {
        pre.enqueue(v);
        marked[v] = true;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
                post.enqueue(v);
                reversePost.push(v);
            }
        }
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}