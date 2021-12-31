import java.util.*;


class Ragged {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0 ; i<n ; i++){
            a[i] = sc.nextInt();
        }
        
        int[][] array = new int[n-2][];
        for(int i =1 ;i<=n-2;i++){
            array[i-1] = new int[n-i];
            for(int j = 0 ; j < n-i ; j++){
                int sum =0 ;
                int x = i,y = j;
                while(x>=0){
                    sum = sum + a[y];
                    x-=1;
                    y+=1;
                }
                array[i-1][j] = sum;
            }
        }
        System.out.println();
        for(int i=0; i<n-2;i++){
            boolean flag = false;
            for(int j =0; j< array[i].length && !flag ;j++){
                for(int k = j+1 ; k< array[i].length && !flag; k++ ){
                    if((array[i][j] ^ array[i][k]) == (array[i][j]|array[i][k])){
                        System.out.println("("+array[i][j]+","+array[i][k] + ")"+ " OR="+(array[i][j]|array[i][k])+" XOR="+(array[i][j] ^ array[i][k]) );
                        System.out.println("Row "+ i + " is abruptly terminated");
                        flag = true;
                        break;
                    }
                    else{
                        System.out.println("("+array[i][j]+","+array[i][k] + ")"+ " OR="+(array[i][j]|array[i][k])+" XOR="+(array[i][j] ^ array[i][k]) );
                        if(j == array[i].length -2 && k == array[i].length -1){
                            System.out.println("Row " + i+" is processed entirely");
                        }
                    }
                }
            }
        }
    }
}
