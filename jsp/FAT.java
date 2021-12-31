import java.util.*;
import java.io.*;

class Captcha {
    String alpha;
    int associated;
     List<Integer> arr = new ArrayList<Integer>();
    Captcha(int x){
        alpha = String.valueOf((char)x);
    }
    Captcha(){}

    void generateRandom(){
        boolean flag = true;
        while(flag){
            int a = (int) ((Math.random() * ( 26- 1)) + 1);
            if(!(arr.contains((int) ((Math.random() * ( 26- 1)) + 1)))){
                associated = a;
                flag = false;
            }
        }
    }
    void generateCaptcha(Captcha[] a, String s){
        String res=s;
        char c = s.charAt(0);
        for(int i = 0 ; i<4 ; i++){
            int x = a[(int)c-97].associated;
            c = a[x].alpha.charAt(0);
            res = res + a[x].alpha;
        }
        System.out.println(res);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();

        for(int k = 0 ; k<3 ; k++){
        Captcha[] obj = new Captcha[26];
        for(int i = 97,j=0 ; i<=122 ;i++,j++ ){
            obj[j] = new Captcha(i);
            obj[j].generateRandom();
        }
        Captcha objCaptcha = new Captcha();
        objCaptcha.generateCaptcha(obj,inp);
    }
    }
}

