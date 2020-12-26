import edu.princeton.cs.algs4.*;

/**
 * my implementation of Princeton's LazyPrimMST.java
 * the lazy version of Prim's MST algorithm
 *
 * @author bleart
 */
public class LazyPrim {

    private boolean[] marked; 
    private Edge[] edgeTo;
    private MinPQ<Edge> pq;
    private Queue<Edge> mst;
    
    public LazyPrim(EdgeWeightedGraph g) {
        marked = new boolean[g.V()];
        pq     = new MinPQ<Edge>();
        mst    = new Queue<Edge>();
        visit(g, 0);

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();   // get edge w/ minimal weight
            int v  = e.either();    // find e's first vertex
            int w  = e.other(v);    // fins e's second vertex 

            if (marked[v] && marked[w])
                continue;

            mst.enqueue(e);
            if (!marked[v]) visit(g, v); 
            if (!marked[w]) visit(g, w);
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) 
                pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst; 
    }

    public static void main(String[] args) {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new In(args[0]));
        LazyPrim lazy = new LazyPrim(ewg);
        for (Edge e : lazy.edges())
            System.out.println(e);
    }
}
