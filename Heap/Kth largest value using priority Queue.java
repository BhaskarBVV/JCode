import java.util.*;

public class temp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter the kth largest value you want");
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
      //at first add first k values of array in P.q.
        for (int i = 0; i < k; i++)
            pq.add(a[i]);
      // now the smallest value of pq (that will be changig continuously) will be compared each time with the next (n-k) values one by one.
// if the smallest value of pq is smaller than current value, than we have another value that can become the kth largest, hence replace the min of pq by current value of a[i].        for (int i = k; i < n; i++) {
            if (a[i] > pq.peek()) {
                pq.remove();
                pq.add(a[i]);
            }
        }
        System.out.println("The kth largest value will be" + pq.peek());
    }
}
