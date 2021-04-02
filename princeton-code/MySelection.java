public class MySelection {

    public static void sort(int[] a) {
        int min = 0;

        for (int i = 0; i < a.length; i++) {
           for (int j = i+1; j < a.length; j++) {
               min = i;
               if (a[j] < a[min])
                    min = j; 

           exch(a, i, min);
           }
        }
    }

    public static void print(int[] a) {
        for (int k = 0; k < a.length; k++) 
            System.out.println(a[k]);
    }
    
    private static void exch(int[] a, int v, int w) {
        int tmp = a[v];
        a[v] = a[w];
        a[w] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {23, 17, 5, 11, 31, 26, 19, 14, 29, 18, 15, 6, 22}; 
        sort(array);
        print(array);
    }
}
