import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intCount= 0;
        int floatCount = 0;
        for(int i = 0 ; i<10 ;i++){
            try{
                int x = sc.nextInt();
                intCount++;
            }catch(InputMismatchException e){
                floatCount++;
            }
        }
        System.out.println("Integet count: "+intCount+"\n"+"Float count: "+floatCount);
    }
}