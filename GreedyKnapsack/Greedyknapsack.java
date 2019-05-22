import java.util.Scanner;

class Greedyknapsack {
    void Knapsack(int m, int n, int[] w, int[] p) {
        int i, k;
        int maxindex = -1;
        double rem = (double) m;
        double x[] = new double[n + 1];
        for (i = 0; i < n; i++) {
            x[i] = 0.0;
        }
        for (i = 0; i < n; i++) {
            double maxelement = 0.0;
            for (k = 0; k < n; k++) {
                if ((maxelement < (double) p[k] / w[k]) && x[k] == 0) {
                    maxelement = (double) p[k] / w[k];
                    maxindex = k;
                }
            }
            if (w[maxindex] > rem)
                break;
            rem = rem - w[maxindex];
            x[maxindex] = 1;
        }
        if (i <= n) {
            x[maxindex] = rem / w[maxindex];
        }
        double maxvalue = 0;
        System.out.println("items included are : ");
        for (int j = 0; j < n; j++) {
            if (x[j] != 0) {
                System.out.println("item" + (j + 1) + "(" + x[j] + ")");
                maxvalue += p[j] * x[j];
            }
        }
        System.out.println("maxprofit : " + maxvalue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Max capacity:");
        int m = sc.nextInt();
        System.out.println("Number of items:");
        int n = sc.nextInt();
        System.out.println("Weight of each");
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("For item" + (i + 1) + ":");
            w[i] = sc.nextInt();
        }
        System.out.println("Profit of each");
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("For item" + (i + 1) + ":");
            p[i] = sc.nextInt();
        }
        Greedyknapsack ob = new Greedyknapsack();
        ob.Knapsack(m, n, w, p);
    }
}