import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

/*
 * sort the digraph such that the directed edges
 * point from a vertex earlier in the order to a 
 * vertex latter in order. this is my implemnetation
 * of Princeton's Topological.java
 */
public class TopologicalOrder {

    private boolean[] marked;
    private Stack<Integer> order;

    public TopologicalOrder(Digraph g) {
        marked = new boolean[g.V()];        
        order  = new Stack<Integer>();

        for (int i = 0; i < g.V(); i++) {
            if (!marked[i])
                dfs(g, i);
        }
    }

    public void dfs(Digraph g, int v) {
        marked[v] = true; 
        for (int w : g.adj(v)) {
            if (!marked[w])
               dfs(g, w); 
        }

        order.push(v);
    }

    public String toString() {
        return order.toString(); 
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(new In(args[0]));  
        TopologicalOrder tp = new TopologicalOrder(g);

        System.out.println(tp);
    }
}
