import java.util.*;

class Rotate {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        
        System.out.println("Enter the elements: ");
        for(int i = 0; i<n ; i++)
        {
            for(int j= 0 ; j<n ; j++)
            {
                arr[i][j] = sc.next();
            }
        }


        //row rotation
        for(int i=1 ; i<n ;i++)
        {
            int j = i;
            while(j>0){
                for(int k = 1 ; k<n ;k++){
                    String temp = arr[i][k];
                    arr[i][k] = arr[i][k-1];
                    arr[i][k-1] = temp;
                }
                j= j-1;
            }
        }
        //column rotation
        for(int j = 1 ; j<n ; j++)
        {
            int x = j;
            while(x>0){
                for(int k = 1; k<n;k++)
                {
                    String temp = arr[k][j];
                    arr[k][j]= arr[k-1][j];
                    arr[k-1][j] = temp;
                }
                x = x -1;
            }
        }
        System.out.println();
        //output
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            System.out.print(arr[i][j] + " ");
            System.out.println();
        }


    }
}