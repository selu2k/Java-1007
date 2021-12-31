package parentpackage.childpackage;

import java.util.*;
import parentpackage.*;
//implements BinaryTree
public class LinkedBinaryTree  {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public LinkedBinaryTree() {
        root = null;
    }

    public void BFTraversal() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (true) {
                Node node = queue.remove();
                if (node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    if (node.left == null) {
                        node.left = newNode;
                        queue.add(node.left);
                    }
                    else {
                        node.right = newNode;
                        queue.add(node.right);
                    }
                    break;
                }
            }
        }
    }
}