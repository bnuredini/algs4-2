public class KeyIndexedCounting {

    private static final int R = 256;   // size of the 'alphabet'

    public static void sort(char[] a) {
        int n = a.length;
        int[] count = new int[R + 1];

        // frequency counts 
        for (int i = 0; i < n; i++) {
            count[a[i] + 1]++;
        }

        // transform count[] into an index table
        for (int r = 0; r < R - 1; r++) {
            count[r + 1] += count[r];
        }

        char[] aux = new char[n];
        // move to aux[]
        for (int i = 0; i < n; i++) {
            aux[count[a[i]]++] = a[i];
        }

        // move back to a[]
        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }
    }

    public static void sort(Pair[] a) {
        int n = a.length;
        int[] count = new int[R];

        for (Pair pair : a) {
            count[pair.key() + 1]++;
        }

        for (int i = 0; i < R - 1; i ++) {
            count[i + 1] += count[i];
        }

        Pair[] aux = new Pair[n];
        for (int i = 0; i < n; i++) {
            aux[count[a[i].key()]++] = a[i];
        }

        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }
    }

    public static void print(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Pair[] pairs = {
            new Pair("Student 1.0", 1),
            new Pair("Student 3.0", 3),
            new Pair("Student 1.2", 1),
            new Pair("Student 2.0", 2),
            new Pair("Student 4.0", 4),
            new Pair("Student 4.1", 4),
            new Pair("Student 1.1", 1),
            new Pair("Student 2.1", 2),
        };

        sort(pairs);
        print(pairs);

//        char[] a = {'d', 'a', 'c', 'b', 'a'};
//        sort(a);
    }
}

class Pair {

    public String studentName;
    public int section;

    public Pair(String studentName, int section) {
        this.studentName = studentName;
        this.section = section;
    }

    public int key() {
        return section;
    }

    public String toString() {
        return studentName + " " + section;
    }
}