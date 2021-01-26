import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Edge;

public class EagrePrim {

    private boolean[] marked;
    private double[] distTo;
    private Edge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public EagrePrim(EdgeWeightedGraph g) {
        marked = new boolean[g.V()];
        distTo = new double[g.V()];
        edgeTo = new Edge[g.V()];
        for (int v = 0; v < g.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<>(g.V());

        pq.insert(0, 0.0);
        while (!pq.isEmpty())
            visit(g, pq.delMin());
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }
}
