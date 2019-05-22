import java.util.Scanner;

class Subset {
    static int n, cnt, d;
    static int[] x, arr;

    static void initialize() {
        for (int i = 0; i < n; i++) {
            x[i] = -1;
        }
    }

    static void subset(int s, int k, int sum) {
        x[k] = 1;
        if (s + arr[k] == d) {
            System.out.println("Solution " + cnt + ":");
            System.out.print("{");
            for (int i = 0; i < n; i++) {
                if (x[i] == 1) {
                    System.out.print(arr[i] + ",");
                }
            }
            System.out.print("}");
            System.out.println();
            cnt++;
        }
        if (k < n - 1) {
            if ((s + arr[k] + arr[k + 1]) <= d) {
                subset(s + arr[k], k + 1, sum - arr[k]);
            }
            if ((s + sum - arr[k]) > d && (s + arr[k + 1] <= d)) {
                x[k] = 0;
                subset(s, k + 1, sum - arr[k]);
            }
        }
        x[k] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("number of elements: ");
        n = sc.nextInt();
        arr = new int[n];
        x = new int[n];
        System.out.println("Enter the numbers in asc order");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("req sum = ");
        d = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum < d || arr[0] > d) {
            System.out.println("1st if no solution exists");
            System.exit(0);
        } else {
            initialize();
            cnt = 1;
            subset(0, 0, sum);
        }
        if (cnt == 1) {
            System.out.println("2nd if no solution exists");
            System.exit(0);
        }
        sc.close();
    }

}