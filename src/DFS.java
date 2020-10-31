import edu.princeton.cs.algs4.Graph;

// warm-up
public class DFS {

    private boolean[] marked;
    private int count;

    public DFS(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int getCount() {
        return count;
    }
}
