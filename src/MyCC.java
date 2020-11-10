import edu.princeton.cs.algs4.Graph;

/**
 * algorithm 4.3: depth-first search to find connected components
 *
 * @author bleart
 */
public class MyCC {

    private boolean[] marked;
    private int id[];
    private int count;

    public MyCC(Graph g) {
        marked = new boolean[g.V()];
        id     = new int[g.V()];

        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        id[v]     = count;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }
}
