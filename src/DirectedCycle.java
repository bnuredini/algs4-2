import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * finds out whether graph contains a cycle or not. if it does,
 * using the cycle() method, it allows you to see the cycle's path.
 *
 * @author bleart
 */
public class DirectedCycle {

    private int[] edgeTo;           // vertex-index array to keep track of path
    private boolean[] marked;       // vertices that have been visited
    private boolean[] onStack;      // vertices who's recursive call hasn't returned yet
    private Stack<Integer> cycle;   // the cycle's path

    public DirectedCycle(Digraph g) {
        edgeTo  = new int[g.V()];
        marked  = new boolean[g.V()];
        onStack = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) dfs(g, v);
        }
    }

    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v]  = true;
        for (int w : g.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {    // we've found a cycle
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }

        // v's recursive call has finished; remove it from onStack[]
        onStack[v] = false; // no longer on the recursive call stack
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(new In(args[0]));
        DirectedCycle dc = new DirectedCycle(g);

        if (dc.hasCycle()) {
            System.out.println("the graph contains a cycle");
            for (int x : dc.cycle()) {
                System.out.print(x + " ");
            }
        } else {
            System.out.println("the graph doesn't contain a cycle");
        }
    }
}