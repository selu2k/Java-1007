import java.util.*;
import java.lang.*;

public interface q9 {
    public class CodeMain {
        CodeMain() {
            this.table();
        }

        String[] array = { "0101", "0100", "0000", "1111", "1000", "1011", "1001", "0111", "1010", "0110" };
        public int[][] arr = new int[10][2];

        public void table() {
            int j = 0;
            for (String i : array) {
                int deci = i.charAt(0) * 8 + i.charAt(1) * 4 - i.charAt(2) * 2 - i.charAt(3);
                arr[j][0] = Integer.parseInt(i);
                arr[j][1] = deci;
                j++;
            }
        }
    }
}

class Class8421 extends q9.CodeMain {
    int n;
    String res = "";

    Class8421(int x) {
        n = x;
    }

    public String getCode() {
        while (n > 0) {
            int dig = n % 10;
            for (int i = 0; i < 10; i++) {
                if (dig == arr[i][1]) {
                    res = String.valueOf(arr[i][0]) + " " + res;
                }
            }
            n = n / 10;
        }
        return res;
    }

}

class Complement9 extends Class8421 {
    String s;
    String x = "";

    Complement9(String s, int x) {
        super(x);
        this.s = s;
    }

    public String compli() {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                x = x + '0';
            } else if (s.charAt(i) == '0') {
                x = x + '1';
            } else {
                x = x + " ";
            }
        }
        return x;
    }

    public int compliDecimal() {
        String[] tokens = x.split(" ");
        String res = "";
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[j][0] == Integer.parseInt(tokens[i])) {
                    res = res + String.valueOf(arr[i][1]);
                    break;
                }
            }
        }
        return Integer.parseInt(res);
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q9.CodeMain a = new q9.CodeMain();
        Class8421 b = new Class8421(395);
        b.table();
        System.out.println(b.getCode());
        Complement9 c = new Complement9(b.getCode(), 395);
        System.out.println(c.compli());
        System.out.println(c.compliDecimal());
    }
}