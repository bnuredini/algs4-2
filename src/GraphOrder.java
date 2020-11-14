import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * can compute the preorder, postorder, and topological order of
 * directed graphs.
 *
 * @author bleart
 */
public class GraphOrder {

    private boolean[] marked;
    private int[] edgeTo;
    private Queue<Integer> pre;         // preorder
    private Queue<Integer> post;        // postorder
    private Stack<Integer> reversePost; // reverse postorder

    public GraphOrder(Digraph g, int s) {
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

    private void dfs(Digraph g, int v) {
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