import java.util.Scanner;

class Pattern {
  public static void main(String args[]) {
    int i, j;
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter the number of rows:\n");
    int rows = scan.nextInt();

    for (i = 1; i <= rows; i++) {
      for (j = rows; j > i; j--) {
        System.out.print(" ");
      }
      System.out.print(1);
      for (j = 1; j < (i - 1) * 2; j++) {
        System.out.print(" ");
      }
      if (i == 1) {
        System.out.print("\n");
      } else {
        System.out.print(i + "\n");
      }
    }

    for (i = rows - 1; i >= 1; i--) {
      for (j = rows; j > i; j--) {
        System.out.print(" ");
      }
      System.out.print(1);
      for (j = 1; j < (i - 1) * 2; j++) {
        System.out.print(" ");
      }
      if (i == 1) {
        System.out.print("\n");
      } else {
        System.out.print(i + "\n");
      }
    }
  }
}