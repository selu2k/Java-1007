import java.util.*;

class QuesVowel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of string:");
        String word;
        int n = s.nextInt();
        for (int k = 0; k < n; k++) {
            word = s.next();

            char arr[] = new char[word.length()];

            for (int i = 0; i < arr.length; i++) {
                if (word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'O'
                        || word.charAt(i) == 'U' || word.charAt(i) == 'a' || word.charAt(i) == 'e'
                        || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                    arr[i] = 'V';
                } else {
                    arr[i] = 'C';
                }
            }
            char[] finalSeq = new char[arr.length];
            finalSeq[0] = arr[0];
            char x = arr[0];
            int j = 1;
            System.out.print(finalSeq[0]);
            for (int i = 1; i < arr.length; i++) {
                if (x != arr[i]) {
                    x = arr[i];
                    finalSeq[j] = arr[i];
                    System.out.print(finalSeq[j]);
                    j += 1;
                    
                }

            }
            int len =0;
            if(finalSeq[0] == 'C'){
                if(finalSeq[j-1] =='V'){
                    len = (j-2)/2;
                }else{len = (j -1)/2;}
            }else{
                if(finalSeq[j-1] =='V'){
                    len = (j-1)/2;
                }
                else{len = (j)/2;}
            }
            System.out.println();
            //System.out.println(finalSeq.length);
            System.out.println(len);
        }
    }
}