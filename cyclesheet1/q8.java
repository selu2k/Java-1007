import java.util.*;

class Faculty {
    int n;
    Faculty(int x){
        this.n = x;
    }
    class Student {
        int sum = 0;
        int[] marks = new int[5];

        void getIndividualTotal() {
            int sum = 0;
            Scanner sc = new Scanner(System.in);
            int temp;
            for (int i = 0; i < 5; i++) {
                temp = sc.nextInt();
                this.marks[i]=temp;
                sum += temp;
            }
            this.sum = sum;
            //return sum;
        }
    }

        void findClassAverage(Student[] s) {
            
            int totalSum=0;
            for(int i = 0; i<n; i++){
                totalSum += s[i].sum;
            }
            float avg = (float)totalSum/n;
            System.out.println(avg);
        }
        void findMaxScore(Student[] s){
            int max = s[0].sum;
            for(int i= 1; i<n ; i++){
                if(s[i].sum > max){
                    max = s[i].sum;
                }
            }
            System.out.println(max);
        }
    }
    class MainC{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Faculty fac = new Faculty(n);
        Faculty.Student[] s = new Faculty.Student[n];
        for(int i= 0; i<n ; i++){
            s[i] = fac.new Student();
            s[i].getIndividualTotal();
        }
        //fac = new Faculty(n);
        fac.findClassAverage(s);
        fac.findMaxScore(s);
    }
}
