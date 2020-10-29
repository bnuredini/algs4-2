import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

public class ClassFromCh4 {

    public static void main(String[] args) {
        System.out.println("hello, world!");
        System.out.println("pershendetje te gjitheve!");
        StdOut.print("hello again");
        Comparable<Integer>[] arr = new Comparable[3];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;

        Selection.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i]);
        }
    }
}