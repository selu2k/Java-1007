import java.util.*;
import java.lang.*;

class NotPrimeException extends Exception {
    public NotPrimeException(String s) {
        super(s);
    }
}

class NotTwinException extends Exception {
    public NotTwinException(String s) {
        super(s);
    }
}

class Prime {
    int m;

    Prime() {
    }

    Prime(int a) {
        m = a;
    }

    public boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class TwinPrime extends Prime {
    int n, m;

    TwinPrime(int a, int b) {
        n = a;
        m = b;
    }

    public void check() throws NotPrimeException, NotTwinException {
        if (checkPrime(n) && checkPrime(m)) {
            if (Math.abs(n - m) == 2) {
                System.out.println("Pair is Twin Prime");
            } else {
                throw new NotTwinException("Not twin");
            }
        } else {
            throw new NotPrimeException("Number not prime");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TwinPrime[] tt = new TwinPrime[n];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            tt[i] = new TwinPrime(p, q);
            try {
                tt[i].check();
            } catch (NotPrimeException e) {
                System.out.println("Exception occured: " + e);
            } catch (NotTwinException ee) {
                System.out.println("Exception occured: " + ee);
            }
        }

    }
}