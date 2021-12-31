import java.util.*;
import java.lang.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NumFaculty = sc.nextInt();
        int faculty=0;
        int student=0;
        int NumMst = sc.nextInt();
        int NumFst = sc.nextInt();
        while(NumFaculty>0 || NumFst>0 || NumMst>0){
            int j=3;
            while(NumFaculty!=0 && j!=0){
                NumFaculty--;
                int bill = 0;
                faculty++;
                j--;
                System.out.println("Enter faculty's choice: ");
                bill += 50*(sc.nextInt());
                bill += 75*(sc.nextInt());
                bill += 100*(sc.nextInt());
                bill += 150*(sc.nextInt());
                System.out.println("Faculty bill: "+bill);
            }
            if(NumMst!=0){
                NumMst--;
                int bill = 0;
                student++;
                System.out.println("Enter male student's choice: ");
                bill += 50*(sc.nextInt());
                bill += 75*(sc.nextInt());
                bill += 100*(sc.nextInt());
                bill += 150*(sc.nextInt());
                System.out.println("Male student bill: "+bill);
            }
            if(NumFst!=0){
                NumFst--;
                int bill = 0;
                student++;
                System.out.println("Enter female student's choice: ");
                bill += 50*(sc.nextInt());
                bill += 75*(sc.nextInt());
                bill += 100*(sc.nextInt());
                bill += 150*(sc.nextInt());
                System.out.println("Female student bill: "+bill);
            }
        }
        System.out.println("Number of faculty: "+faculty);
        System.out.println("Number of student: "+student);
    }
}