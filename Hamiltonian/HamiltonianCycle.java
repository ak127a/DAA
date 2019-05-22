import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

class Hamiltonian {
    int adj[][], x[];
    int n, cycle_count = 0;

    public Hamiltonian() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        x = new int[n];
        x[0] = 0;
        for (int i = 1; i < n; i++) {
            x[i] = -1;
        }
        adj = new int[n][n];
        System.out.println("Enter adj matrix: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                adj[i][j] = sc.nextInt();
    }

    public void nextValue(int k) {
        int j;
        do {
            x[k] = (x[k] + 1);
            if (x[k] == n)
                x[k] = -1;
            if (x[k] == -1)
                return;
            if (adj[x[k - 1]][x[k]] == 1) {
                for (j = 0; j < k; j++) {
                    if (x[j] == x[k])
                        break;
                }
                if (j == k) {
                    if (k < n - 1 || ((k == n - 1) && adj[x[n - 1]][x[0]] == 1))
                        return;
                }
            }
        } while (true);
    }

    void getHCycle(int k) {
        do {
            nextValue(k);
            if (x[k] == -1)
                return;
            if (k == n - 1) {
                System.out.println("Soultion:");
                for (int i = 0; i < n; i++) {
                    System.out.print((x[i] + 1) + " ");
                }
                System.out.println(1);
            } else {
                getHCycle(k + 1);
            }
        } while (true);
    }

}

public class HamiltonianCycle {
    public static void main(String[] args) {
        Hamiltonian ht = new Hamiltonian();
        ht.getHCycle(1);
    }
}