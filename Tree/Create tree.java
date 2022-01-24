import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static class ListNode {
        int data;
        ListNode left, right;

        ListNode() {
            data = 0;
            left = null;
            right = null;
        }

        ListNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static ListNode create() {
        System.out.println("Enter the val(-1) for no child");
        int a = sc.nextInt();
        if (a == -1)
            return null;
        ListNode root = new ListNode(a);
        System.out.println("Enter left child of " + a);
        root.left = create();
        System.out.println("Enter right child of " + a);
        root.right = create();
        return root;
    }

    public static void preOrder(ListNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        ListNode root = create();
        System.out.println("PreOrder");
        preOrder(root);
    }
}
