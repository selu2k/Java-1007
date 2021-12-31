package mainpackage;

import java.util.*;

import parentpackage.childpackage.ArrayBinaryTree;
import parentpackage.childpackage.LinkedBinaryTree;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedBinaryTree bt = new LinkedBinaryTree();
        System.out.print("Enter number of node: ");
        int n = sc.nextInt();
        System.out.print("Enter nodes: ");
        for(int i = 1 ; i<=n ;i++){
            int temp = sc.nextInt();
            bt.insertNode(temp);
        }
        bt.BFTraversal();
        System.out.println();
        System.out.println("Array representation: ");
        ArrayBinaryTree btt = new ArrayBinaryTree();
        btt.Root("A");
        btt.insertNode("B", 0, "right");
        btt.insertNode("C", 1, "left");
        btt.insertNode("D", 1, "right");
        btt.insertNode("E", 2, "left");
        btt.BFTraversal();
    }
}
