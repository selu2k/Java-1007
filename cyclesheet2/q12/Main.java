import java.util.*;
import java.lang.*;

class mult extends Thread {
    int result = 0;
    int n, l;
    int[] b;

    mult(int[] a, int n, int l) {
        b = a;
        this.n = n;
        this.l = l;
    }

    public void run() {
        for (int i = n - 1; i < l; i++) {
            result = result + b[i] * (i+1);
        }
    }
}

class sum extends Thread {
    int result = 0;
    int n, l;
    int[] b ;

    sum(int[] a, int n, int l) {
        b = a;
        this.n = n;
        this.l = l;
    }

    public void run() {
        for (int i = n - 1; i < l; i++) {
            result = result + b[i];
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Map<Integer, Integer> test = new HashMap<>();
        int[] test = new int[10];
        for (int i = 0; i < 10; i++) {
            int x = sc.nextInt();
            test[i] = x;
            // test.put(i, x);
        }
        try {
            mult t1 = new mult(test, 1, 5);
            mult t2 = new mult(test, 6, 10);
            sum t3 = new sum(test, 1, 5);
            sum t4 = new sum(test, 6, 10);
            t1.start();t2.start();
            t3.start();t4.start();
            t1.join();t2.join();
            t3.join();t4.join();
            float mean = (t1.result+t2.result)/(t3.result+t4.result);
            System.out.println(mean);
        } catch (Exception e) {
        }
    }
}