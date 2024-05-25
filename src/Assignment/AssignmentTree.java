package Assignment;

import java.util.Scanner;

class Dnode {
    Dnode left, right;
    int data;
    Dnode(int data){
        this.data = data;
        left = right = null;
    }
}

public class AssignmentTree {
    Dnode root;

    void init_tree() {
        root = null;
    }

    void insert(Dnode r, Dnode n) {
        if (root == null)
            root = n;
        else {
            if (n.data < r.data) {
                if (r.left == null)
                    r.left = n;
                else
                    insert(r.left, n);
            } else {
                if (r.right == null)
                    r.right = n;
                else
                    insert(r.right, n);
            }
        }
    }

    void inorder(Dnode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + ",");
            inorder(r.right);
        }
    }

    int count(Dnode r) {
        if (r == null)
            return 0;
        else {
            int left = count(r.left);
            int right = count(r.right);
            return left + right + 1;
        }
    }

    int depth(Dnode r) {
        if (r == null)
            return 0;
        else {
            int left = depth(r.left);
            int right = depth(r.right);
            return Math.max(left, right) + 1;
        }
    }

    boolean isBalanced(Dnode r) {
        if (r == null)
            return true;
        else {
            int left = depth(r.left);
            int right = depth(r.right);
            int balanceFactor = left - right;
            return balanceFactor == -1 || balanceFactor == 0 || balanceFactor == 1;
        }
    }

    boolean search(Dnode r, int data) {
        if (r == null)
            return false;
        if (r.data == data)
            return true;
        if (data < r.data)
            return search(r.left, data);
        else
            return search(r.right, data);
    }

    public static void main(String[] args) {
        int ch, e;
        Scanner sc = new Scanner(System.in);
        AssignmentTree db = new AssignmentTree();

        do {
            System.out.println("\n1.insert\n2.inorder\n3.search\n4.counting\n5.depth\n6.check_balance\n0.exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter data");
                    e = sc.nextInt();
                    Dnode n = new Dnode(e);
                    db.insert(db.root, n);
                    break;
                case 2:
                    System.out.println("inorder print");
                    db.inorder(db.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("enter number you are searching for");
                    e = sc.nextInt();
                    System.out.println(e + " found in tree: " + db.search(db.root, e));
                    break;
                case 4:
                    System.out.println("number of nodes: " + db.count(db.root));
                    break;
                case 5:
                    System.out.println("number of depth: " + (db.depth(db.root) - 1));
                    break;
                case 6:
                    System.out.println("is tree balanced: " + db.isBalanced(db.root));
                    break;
                case 0:
                    System.out.println("exiting");
                    break;
                default:
                    break;
            }
        } while (ch != 0);
        sc.close();
    }
}
