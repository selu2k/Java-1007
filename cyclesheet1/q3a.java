import java.util.*;

class Series {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans=0;
        for(int i = 1; i<=n; i++)
        {
            int temp=0;
            int j = i-1;
            while(j>=0){
                temp = temp +(int)Math.pow(10,j) ;
                j= j-1;
            }
            temp = temp*i;
            if(i%2==0)
            {
                ans = ans - temp;
            }else{ans = ans + temp;}
        }
        System.out.println(ans);
    }
}