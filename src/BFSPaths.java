import edu.princeton.cs.algs4.*;

/**
 * algorithm 4.2: breadth-first search to find paths in a
 *                graph
 * can find the shortest path form vertex s to vertex v by
 * using a (FIFO) queue.
 *
 * @author bleart
 */
public class BFSPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BFSPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<>();
        marked[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s   = Integer.parseInt(args[1]);
        int v   = Integer.parseInt(args[2]);
        BFSPaths bfs = new BFSPaths(g, s);

        if (bfs.hasPathTo(v)) {
            for (int x : bfs.pathTo(v)) {
                if (x == s) System.out.print(x);
                else        System.out.print("-" + x);
            }
        } else {
            System.out.print(s + " is not connected w/ " + v);
        }
    }
}
