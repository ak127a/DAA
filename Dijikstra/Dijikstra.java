import java.util.Scanner;

class Dijikstra {
    static int a[][];
    private int n;

    // Function to read the array
    void read(int n) {
        this.n = n;
        a = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    // Function to find the shortest path
    void shortdis(int src, int des) {
        // Min distance array
        int[] d = new int[n];
        // Selected yet or not array
        int[] s = new int[n];
        // Parent of an element
        int[] p = new int[n];
        // Intermediate vertex
        int u;
        // Minimum distance
        int min;
        // Initialize all parents to source and distance to the distance from source ,
        // And mark nothing as visited
        for (int i = 0; i < n; i++) {
            d[i] = a[src][i];
            p[i] = src;
            s[i] = 0;
        }

        // Visit the source
        s[src] = 1;
        // Find the shortest distance
        for (int i = 0; i < n; i++) {
            u = -1;
            min = 999;
            for (int j = 0; j < n; j++) {
                if (s[j] == 0 && d[j] < min) {
                    // every iteration , the min distance is saved in min
                    min = d[j];
                    // u here is the index of the min distance vertex
                    u = j;
                }
            }
            // Now , if the min dist vertex itself is the destination , then , no need to
            // proceed further , This will be the answer
            if (u == des)
                break;
            // Else , find the min distance to the destination vertex
            // visit the vertex with min distance --> u
            s[u] = 1;
            for (int v = 0; v < n; v++) {
                // If the distance of the current min + distance from that min to the
                // destination < current distance to the destination , change it. Also , change
                // the parent
                if ((d[u] + a[u][v] < d[v]) && (u != v) && (s[v] == 0)) {
                    d[v] = d[u] + a[u][v];
                    p[v] = u;
                    System.out.println("p[" + u + "} is " + v);
                }
            }
        }
        if (d[des] == 999) {
            System.out.println("No path exists");
            return;
        }
        System.out.println("shortest distance : " + d[des]);
        int i = des;
        while (i != src) {
            System.out.print(i + "<--");
            i = p[i];
        }
        System.out.print(i);
    }

    public static void main(String[] args) {
        Dijikstra ob = new Dijikstra();
        ob.read(5);
        ob.shortdis(0, 4);
    }

}