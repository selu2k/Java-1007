package parentpackage.childpackage;

import parentpackage.*;

public class ArrayBinaryTree implements BinaryTree {

    static int root = 0;
    static String[] str = new String[10];

    public void Root(String key) {
        str[0] = key;
    }

    @Override
    public void BFTraversal() {
        for (int i = 0; i < 10; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }

    }

    @Override
    public void insertNode(String key, int root, String s) {
        if (s == "right") {
            int t = (root * 2) + 2;

            if (str[root] == null) {
                System.out.printf("Can't set child at %d, no parent found\n", t);
            } else {
                str[t] = key;
                str[root] += "0";
            }
        } else {
            int t = (root * 2) + 1;

            if (str[root] == null) {
                System.out.printf("Can't set child at %d, no parent found\n", t);
            } else {
                str[t] = key;
                str[root] += "1";
            }
        }
    }

}
