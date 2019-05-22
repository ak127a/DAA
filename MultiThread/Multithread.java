import java.util.Random;

class Square implements Runnable {
    int n;

    public Square(int n) {
        this.n = n;
    }

    public void run() {
        Thread b = new Thread(new Cube(n));
        System.out.println("sqaure = " + (n * n));
        b.start();
    }
}

class Cube implements Runnable {
    int n;

    public Cube(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("cube = " + (n * n * n));
    }
}

class Generate implements Runnable {
    public void run() {
        Random r = new Random();
        int x = r.nextInt(100);
        Thread a = new Thread(new Square(x));
        System.out.println("Generated number = " + x);
        a.start();
    }
}

class Multithread {
    public static void main(String[] args) {
        while (true) {
            Thread ob = new Thread(new Generate());
            ob.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}