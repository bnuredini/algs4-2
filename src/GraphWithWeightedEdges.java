import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import java.util.*;


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
    public Bag<Edge>[] adj;
    // public int[] marked;
    // public int[] edgeTo[];

    public GraphWithWeightedEdges(int V) {
        this.V = V;
        this.E = E;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Edge>(); 
        }
    }

    public GraphWithWeightedEdges(In in) {
        if (in == null) throw new IllegalArgumentException("input is null");
        V = in.readInt();
        E = in.readInt();
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Edge>(); 
        }

        for (int j = 0; j < E; j++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            validateEdge(v, w, weight);
            addEdge(e);
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(); 
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    // returns all edges adjacent to v
    public Iterable<Edge> adj(int v) {
        return adj[v]; 
    }

    // returns all edges
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) b.add(e);
            }
        }

        return b;
    }

    private void validateEdge(int v, int w, double weight) {
        if ((v < 0 || v > V) && (w < 0 || w > V)) 
            throw new IllegalArgumentException("vertex value must be within (0, V-1)");
    }

    public static void main(String[] args) {
        GraphWithWeightedEdges wg = new GraphWithWeightedEdges(new In(args[0]));
        for (Edge e : wg.edges())
            System.out.println(e);
    }
}
