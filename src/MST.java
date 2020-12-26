import java.util.Scanner;

public class Edge implements Comparable<Edge> {

    private int v;      // starting edge
    private int w;      // terminating edge
    private int weight; // weight asociated with the edge

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    public int either() {
        return v; 
    }

    public int other(int vertex) {
        if (vertex == v) return w; 
        if (vertex == w) return v;
        // else throw new RuntimeException("illegal vertex");
    }

    public int compareTo(Edge that) {
        if (this.weight() > that.weight()) return +1; 
        if (this.weight() < that.weight()) return -1;
        else                               return 0;
    }

    public String toString() {
        return v + "->" + w + " " + weight; 
    }
}
