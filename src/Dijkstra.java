import edu.princeton.cs.algs4.*;

public class Dijkstra {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ pq;

    public Dijkstra(EdgeWeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        pq = new IndexMinPQ(g.V());

        for (int i = 0; i < g.V(); i++) {
            distTo[i] = 999999999;
        }

        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : g.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.change(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In(args[0]));
        Dijkstra spt = new Dijkstra(g, 0);
          
    }
}
