import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class GraphTestDrive {

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w = 0; w < G.V(); w++) {
            degree++;
        }

        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > maxDegree) {
                maxDegree = degree(G, v);
            }
        }

        return maxDegree;
    }

    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (w == v) count++;
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
         In in = new In(args[0]);
         Graph g = new Graph(in);
         StdOut.print(g);
    }
}
