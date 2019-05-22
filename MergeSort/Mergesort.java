import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Mergesort {
    static int max_size = 50000;
    static int a[] = new int[max_size];
    static String s = null;

    void readArrayValues(int n) {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt();
            // System.out.println(a[i]);
        }
    }

    void merge(int low, int high, int mid, int n) {
        int i, j, k;
        int c[] = new int[n];
        i = low;
        j = mid;
        k = low;
        while (i < mid && j <= high) {
            if (a[i] <= a[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i < mid) {
            c[k++] = a[i++];
        }
        while (j <= high) {
            c[k++] = a[j++];
        }
        for (i = 0; i < high - low + 1; i++) {
            a[high] = c[high];
            high--;
        }
    }

    void mergesort(int low, int high) {
        int mid;
        if (low < high) {
            mid = (high + low) / 2;
            mergesort(low, mid);
            mergesort(mid + 1, high);
            merge(low, high, mid + 1, high + 1);
        }
        // System.out.println("SORTED\n\n");
        // for (int i = 0; i < high; i++) {
        // System.out.println(a[i]);
        // }
    }

    void plotGraph() throws IOException {
        // readArrayValues(10);
        // mergesort(0, 9);
        File file = new File("plot.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("TitleName: Sort Algorithm\n");
        bw.write("XUnitText: ProblemSize\n");
        bw.write("YUnitText: TimeTaken\n");
        for (int i = 5000; i <= max_size; i += 1000) {
            readArrayValues(i);
            double startTime = System.currentTimeMillis();
            mergesort(0, i - 1);
            double endTime = System.currentTimeMillis();
            double timeTaken = (endTime - startTime) / 1000;
            bw.write(i + " " + timeTaken + "\n");
        }
        bw.close();
        Process p = Runtime.getRuntime().exec("xgraph plot.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        Mergesort m = new Mergesort();
        m.plotGraph();
    }
}