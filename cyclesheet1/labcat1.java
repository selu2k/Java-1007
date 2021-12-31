import java.util.*;

class Customer {
    String name;
    int[][] purchase = new int[3][];

    Customer(String s,int[][] p){
        this.name = s;
        this.purchase = p;
    }

    void haveDiscount(Customer[] c){
        System.out.println("Customers getting the discount: ");
        for(int i =0 ; i< c.length ; i++){
            int totalPur = 0 ;
            boolean maxMonth = false;
            for(int j = 0; j<3 ; j++){
                int sum =0;
                for(int k = 0 ; k< c[i].purchase[j].length ; k++){
                    totalPur += c[i].purchase[j][k];
                    sum += c[i].purchase[j][k];
                }
                if(sum >=25000){
                    maxMonth = true;
                }
            }
            if(totalPur>=50000 || maxMonth){
                System.out.println(c[i].name);
            }
        }
    }

    void findMaxMonth(Customer[] c){
        int MonthPurchase = 0;
        int maxx=0;
        int month =0;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ;j< c.length ; j++){
                for(int k =0 ; k < c[j].purchase[i].length; k++){
                    MonthPurchase += c[j].purchase[i][k];
                }
            }
            if(MonthPurchase > maxx){
                maxx = MonthPurchase;
                month = i;
            }
        }
        System.out.println();
        System.out.println("Month with max purchase: " + month );
    }
}


class MainCla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers: ");
        int n = sc.nextInt();
        Customer[] c = new Customer[n]; 
        //Customer c1 = new Customer();
        int[][] p = new int[3][];

        for(int i= 0 ; i<n ;i++){

            String s = sc.next();

            for(int j =0 ; j<3 ; j++){
                int x = sc.nextInt();
                p[i] = new int[x];
                for(int k = 0 ; k < x ; k ++){
                    p[i][k] = sc.nextInt();
                }
            }
            c[i] = new Customer(s,p);
        }
        System.out.println();
        System.out.println();
        c[0].haveDiscount(c);
        c[0].findMaxMonth(c);

    }
}
