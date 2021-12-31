import java.util.*;

class PythonDic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = "mydict={'A': (1,-2,3), 'B': (4,8), 'C': (3,6,-4,5), 'D': (1,7,8,-2,-6), 'E': (9,10)}";
        String input = sc.nextLine();
        int start = input.indexOf('{');
        int end = input.indexOf('}');
        String extract = input.substring(start + 1, end);
        String[] s = extract.split("\\),");
        String[] keys = new String[s.length];
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            String[] parts = s[i].split(":");
            keys[i] = parts[0].replace("'","");
            keys[i] = keys[i].replace(" ","");
            parts[1] = parts[1].replace("(","");
            parts[1] = parts[1].replace(")","");
            parts[1] = parts[1].replace(" ","");
            int sum = 0;
            String[] values = parts[1].split(",");
            for (String ii : values) {
                String x;
                if (ii.charAt(0) == '-') {
                    x = ii.substring(1);
                    sum += (Integer.parseInt(x)*(-1));
                } else {
                    sum += Integer.parseInt(ii);
                }
            }
            v[i] = sum;
        }
        for (int i = 0; i < v.length; i++) {
            System.out.print(keys[i] + ": ");
            System.out.println(v[i]);
        }
    }
}
