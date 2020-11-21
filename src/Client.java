import edu.princeton.cs.algs4.*;

/**
 * this class is used primarily for testing and could be 
 * anybody's client.
 *
 * @author bleart
 */
public class Client {
    
   public static void main(String[] args) {
       EdgeWeightedGraph g = new EdgeWeightedGraph(new In(args[0]));
       MSTwithLazyPrim mst = new MSTwithLazyPrim(g);
//       LazyPrimMST mst = new LazyPrimMST(g);
       for (Edge e : mst.edges()) {
            System.out.println(e); 
       }
   } 
}
