public class KeyIndexedCounting {

    private static final int R = 256;   // size of the 'alphabet'

    public static void sort(char[] a) {
        int n = a.length;
        int[] count = new int[R + 1];

        // frequency counts 
        for (int i = 0; i < n; i++)
            count[a[i]+1]++;

        // transform count[] into an index table
        for (int r = 0; r < R-1; r++)
            count[r+1] += count[r];

        char[] aux = new char[n];
        // move to aux[]
        for (int i = 0; i < n; i++)
            aux[count[a[i]]++] = a[i];

        // move back to a[]
        for (int i = 0; i < n;i ++)
            a[i] = aux[i];
    }

    public static void print(char[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args) {
        char[] a = {'d', 'a', 'c', 'b', 'a'}; 
        sort(a);
        print(a);
    }
}
