import java.util.*;
import java.lang.*;

class Line {
    int x1, y1, x2, y2;

    Line() {
    }

    Line(int a1, int b1, int a2, int b2) throws NumberFormatException {
        if (a1 == a2 && b1 == b2) {
            throw new NumberFormatException("Points same");
        } else {
            x1 = a1;
            y1 = b1;
            x2 = a2;
            y2 = b2;
        }
    }
}

class TriangleNotPossibleException extends Exception {
    public TriangleNotPossibleException(String s) {
        super(s);
    }
}

class Triangle extends Line {
    Line p1;
    Line p2;

    Triangle(Line a, Line b) throws TriangleNotPossibleException {
        if ((a.x2 == b.x1 && a.y2 == b.y1) || (a.x2 == b.x2 && a.y2 == b.y2) || (a.x1 == b.x1 && a.y1 == b.y1)
                || (a.x1 == b.x2 && a.y1 == b.y2)) {
            p1 = a;
            p2 = b;
        } else {
            throw new TriangleNotPossibleException("Lines not joined");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag = true;
        int count =0 ;
        while(flag){
            int a1,b1,a2,b2;
            int x1,y1,x2,y2;
            count++;
            System.out.print("Enter the points: ");
            a1=sc.nextInt();
            b1=sc.nextInt();
            a2=sc.nextInt();
            b2=sc.nextInt();
            x1=sc.nextInt();
            y1=sc.nextInt();
            x2=sc.nextInt();
            y2=sc.nextInt();
            try{
                Line l1 = new Line(a1,b1,a2,b2);
                Line l2 = new Line(x1,y1,x2,y2);
                Triangle t = new Triangle(l1, l2);
                flag = false;
            }catch(NumberFormatException e){
                System.out.println("Exception occured: " + e);
                continue; 
            }catch(TriangleNotPossibleException tt){
                System.out.println("Exception occured: " + tt);
                continue; 
            }
        }
        count--;
        System.out.println("Additional attempts: " + count); 
    }
}
