import edu.princeton.cs.algs4.KosarajuSharirSCC;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class CCTestDrive {

    public static void main(String[] args) {
        Digraph g = new Digraph(new In(args[0]));
        KosarajuSharirSCC connectedComps = new KosarajuSharirSCC(g);

        System.out.println(connectedComps.count());
    }
}
