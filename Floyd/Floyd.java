import java.util.Scanner;

class Floyd {
    void floyd(int a[][], int n) {
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = new int[10][10];
        int n;
        System.out.println("Enter number of vertices:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Enter the weight matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Floyd f = new Floyd();
        f.floyd(a, n);
        System.out.println("Shortest path matrix is :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}