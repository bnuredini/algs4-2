import edu.princeton.cs.algs4.*;

public class MDFSPClient {

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        int v = Integer.parseInt(args[2]);
        MyDepthFirstSearchPaths a = new MyDepthFirstSearchPaths(g, s);

        // System.out.println(a.pathTo(v));
        for (int x : a.pathTo(v)) {
            if (x == s) System.out.print(x);
            else        System.out.print("-" + x);
        }
        System.out.println();
    }
}
