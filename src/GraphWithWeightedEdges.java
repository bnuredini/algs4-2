import edu.princeton.cs.algs4.Bag;

/**
 * my implementation of Princeton's EdgeWeightedGraph.java
 * it can represent a edge-weighted graph, using a vertex-indexed 
 * array of lists, where -- for some vertex -- each list contains 
 * the edges incident to that vertex 
 *
 * @author bleart
 */
public class GraphWithWeightedEdges {
    
    public int V;
    public int E;
    public Bag<Edges>[] adj;
    // public int[] marked;
    // public int[] edgeTo[];

    public GraphWithWeightedEdges(int V) {
        this.V = V;
        this.E = E;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj = new Bag<Edges>(); 
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(); 
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> edges(int v) {
        reutrn adj[v]; 
    }
}
