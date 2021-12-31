import java.text.NumberFormat.Style;
import java.util.*;

class Encoding {
    private String inputtext;
    private String[] SA;
    private int[] IA;

    Encoding(String s) {
        inputtext = s;
        SA = s.split(" ");
        IA = new int[SA.length];
    }

    String[] sort(Encoding[] e) {
        String temp = e[0].inputtext;
        for (int i = 1; i < e.length; i++) {

            temp = temp + " " + e[i].inputtext;
        }
        String[] Combined;
        Combined = temp.split(" ");
        String x;
        for (int i = 0; i < Combined.length; i++) {
            for (int j = i + 1; j < Combined.length; j++) {
                if (Combined[i].compareTo(Combined[j]) > 0) {
                    x = Combined[i];
                    Combined[i] = Combined[j];
                    Combined[j] = x;
                }
            }
        }
        String[] single= new String[Combined.length];
        single[0] = Combined[0];
        int j =1;
        System.out.print(single[0]+ " ");
        for(int i =1 ; i<Combined.length ; i++){
            if(!(single[j-1].equals(Combined[i]))){
                single[j] = Combined[i];
                
                System.out.print(single[j]+ " ");
                j=j+1;
            }
        }
        
        return single;
    }

    void encodeText(String[] s, Encoding[] e) {
        System.out.println();
        System.out.println();
        System.out.println("Encoded list from first encodeText(): ");
        for(int i = 0 ; i<e.length ; i++){
            for(int j = 0 ; j<e[i].SA.length ;j++){
                int index = Arrays.asList(s).indexOf(e[i].SA[j]);
                System.out.print(index + " ");
            }
            
            System.out.println();
        }
    }

    void encodeText(String[] s, Encoding[] e,boolean b) {
        System.out.println();
        System.out.println("Encoded list from second encodeText(): ");
        int max= e[0].SA.length;
        for(int i =1 ;i<e.length; i++){
            if(e[i].SA.length > max){
                max = e[i].SA.length;
            }
        }
        for(int i = 0 ; i<e.length ; i++){
            for(int j = 0 ; j<e[i].SA.length ;j++){
                int index = Arrays.asList(s).indexOf(e[i].SA[j]);
                System.out.print(index + " ");
            }
            if(e[i].SA.length != max){
                int x = max-e[i].SA.length;
                while(x>0){
                    System.out.print(-1);
                    x-=1;
                }
            }
            System.out.println();
        }
    }
}

class MainCl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Encoding[] e = new Encoding[n];
        Encoding e1 = new Encoding("");
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = sc.nextLine();
            e[i] = new Encoding(temp);
        }
        String[] s = e1.sort(e);
        e1.encodeText(s,e);
        e1.encodeText(s, e,true);
    }
}
