import java.util.*;

class Main
{
	public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int least=10000, greatest=0,countReg=0,countCGPA=0,countName=0;
        float sum=0;
        String ans = "";
        int n = scan.nextInt();
        while(n>0)
        {
            n = n -1;
            if(scan.hasNextInt())
            {
                int temp = scan.nextInt();
                scan.nextLine();
                countReg++;
                if(greatest<temp)
                {
                    greatest = temp;
                }
                if(temp<least)
                {
                    least = temp;
                }
            }
            else if(scan.hasNextFloat())
            {
                float tempf = scan.nextFloat();
                scan.nextLine();
                countCGPA++;
                sum += tempf;
            }
            else if(scan.hasNext())
            {
                String string = scan.nextLine();
                countName++;
                ans = ans + string + ",";
            }
            
        }
        float avg = (float)sum/countCGPA;
        System.out.println(countReg);
        System.out.println(countCGPA);
        System.out.println(countName);
        System.out.println(avg);
        System.out.println(least);
        System.out.println(greatest);
        System.out.println(ans.substring(0,ans.length()-1));
    }
}