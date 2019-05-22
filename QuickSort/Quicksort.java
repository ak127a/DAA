import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Quicksort
 */
public class Quicksort {
    static int max_size = 100000;
    static int a[] = new int[max_size];
    static String s = null;

    void readArrayValues(int n) {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt();
        }
    }

    void exchange(int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    int partition(int l, int r) {
        int p = a[l];
        int i = l;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (i <= r && a[i] <= p);
            do {
                j--;
            } while (j > l && a[j] > p);
            if (i < j) {
                exchange(i, j);
            }
        }
        if (l < r) {
            exchange(l, j);
        }
        return j;
    }

    void Quicksort(int l, int r) {
        int s;
        if (l < r) {
            s = partition(l, r);
            Quicksort(l, s - 1);
            Quicksort(s + 1, r);
        }
    }

    void plotGraph() throws IOException {
        File file = new File("plot.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("TitleName: Sort Algorithm\n");
        bw.write("XUnitText: ProblemSize\n");
        bw.write("YUnitText: TimeTaken\n");
        for (int i = 5000; i <= max_size; i += 1000) {
            readArrayValues(i);
            double startTime = System.currentTimeMillis();
            Quicksort(0, i - 1);
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
        Quicksort m = new Quicksort();
        m.plotGraph();
    }
}