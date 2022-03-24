import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static int size(Node node) {
      
      //size is the number of nodes in current tree.
      //size of current subtree = size of left subtree + 1(for root node of current tree) + height of right subtree.
      
        if (node == null)
            return 0;
        int l = size(node.left);
        int r = size(node.right);
        return l + r + 1;
    }

    public static int sum(Node node) {
        if (node == null)
            return 0;
        int l = sum(node.left);
        int r = sum(node.right);
        return l + node.data + r;
    }

    public static int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int l = max(node.left);
        int r = max(node.right);
        return Math.max(l, Math.max(node.data, r));
    }

    public static int height(Node node) {
        if (node == null)
            return -1;
        int l = height(node.left);
        int r = height(node.right);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) throws Exception {

        Node root;
        // root = construct();

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}
