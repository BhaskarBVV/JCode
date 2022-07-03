public class JavaEditor3 {
   public static class Node {
      int data;
      Node left;
      Node right;

      int ht = 1;
      int bal = 0;

      Node() {
      }

      Node(int data) {
         this.data = data;
      }
   }

   private static int getHeight(Node node) {
      int lh = node.left != null ? node.left.ht : 0;
      int rh = node.right != null ? node.right.ht : 0;
      return Math.max(lh, rh) + 1;
   }

   private static int getBalance(Node node) {
      int lh = node.left != null ? node.left.ht : 0;
      int rh = node.right != null ? node.right.ht : 0;
      return lh - rh;
   }

   public static Node construct(int[] arr) {
      return construct_helper(arr, 0, arr.length - 1);
   }

   public static Node construct_helper(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      }
      int mid = (lo + hi) / 2;
      Node node = new Node(arr[mid]);
      node.left = construct_helper(arr, lo, mid - 1);
      node.right = construct_helper(arr, mid + 1, hi);
      node.ht = getHeight(node);
      node.bal = getBalance(node);
      return node;
   }

   public static void display(Node node) {
      if (node == null) {
         return;
      }
      String str = " <- " + node.data + "[" + node.ht + ", " + node.bal + "] -> ";
      String lstr = node.left != null ? node.left.data + "" : ".";
      String rstr = node.right != null ? node.right.data + "" : ".";
      System.out.println(lstr + str + rstr);
      display(node.left);
      display(node.right);
   }

   public static Node add(Node root, int val) {
      if (root == null) {
         return new Node(val);
      }
      if (val > root.data) {
         root.right = add(root.right, val);
      } else if (val < root.data) {
         root.left = add(root.left, val);
      }

      root.ht = getHeight(root);
      root.bal = getBalance(root);

      // bal = lh - rh
      if (root.bal > 1) { // ll, lr
         System.out.println(root.data);
         if (root.left.bal >= 0) { // ll
            root = rightRotate(root);
         } else { // lr
            root.left = leftRotate(root.left);
            root = rightRotate(root);
         }
      } else if (root.bal < -1) {
         System.out.println(root.data);// rr, rl
         if (root.right.bal < 0) { // rr
            root = leftRotate(root);
         } else { // rl
            root.right = rightRotate(root.right);
            root = leftRotate(root);
         }
      }

      return root;
   }

   public static Node del(Node root, int val) {
      if (root == null)
         return root;
      if (root.data > val)
         root.left = del(root.left, val);
      else if (root.data < val)
         root.right = del(root.right, val);
      else if (root.data == val) {
         if (root.left != null && root.right != null) {
            int maxi = get_max(root.left);
            root.data = maxi;
            root.left = del(root.left, maxi);
         } else if (root.left != null) {
            return root.left;
         } else if (root.right != null) {
            return root.right;
         } else
            return null;
      }
      root.ht = getHeight(root);
      root.bal = getBalance(root);

      // bal = lh - rh
      if (root.bal > 1) { // ll, lr
         System.out.println(root.data);
         if (root.left.bal >= 0) { // ll
            root = rightRotate(root);
         } else { // lr
            root.left = leftRotate(root.left);
            root = rightRotate(root);
         }
      } else if (root.bal < -1) {
         System.out.println(root.data);// rr, rl
         if (root.right.bal < 0) { // rr
            root = leftRotate(root);
         } else { // rl
            root.right = rightRotate(root.right);
            root = leftRotate(root);
         }
      }
      return root;
   }

   public static Node rightRotate(Node node) {
      Node z = node;
      Node y = z.left;
      Node t3 = y.right;

      z.left = t3;
      y.right = z;

      z.ht = getHeight(z);
      z.bal = getBalance(z);
      y.ht = getHeight(y);
      y.bal = getBalance(y);

      return y;
   }

   public static Node leftRotate(Node node) {
      Node z = node;
      Node y = z.right;
      Node t2 = y.left;

      z.right = t2;
      y.left = z;

      z.ht = getHeight(z);
      z.bal = getBalance(z);
      y.ht = getHeight(y);
      y.bal = getBalance(y);

      return y;
   }

   public static int get_max(Node root) {
      if (root.right == null)
         return root.data;
      return get_max(root.right);
   }

   public static void main(String[] args) {
      // Construct is uswd to create the tree from array, by taking mid element each
      // time.
      Node root = null;
      root = add(root, 1);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 2);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 3);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 4);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 5);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 6);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 7);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 8);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 9);
      display(root);
      System.out.println("---------------------------");
      root = add(root, 10);
      display(root);
      System.out.println("---------------------------");
      root = del(root, 1);
      display(root);
      System.out.println("---------------------------");
      root = del(root, 3);
      display(root);
      System.out.println("---------------------------");
   }
}
