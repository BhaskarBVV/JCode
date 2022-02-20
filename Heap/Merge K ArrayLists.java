import java.io.*;
import java.util.*;

public class JavaEditor3 {
    public static class triplet implements Comparable<triplet> {
        int listNum, idx, val;
      
        triplet() {
        }
      
        triplet(int listNum, int idx, int val) {
            this.listNum = listNum;
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(triplet o) {
            return this.val - o.val;// this - other results in default type of heap.
            // o.val-this.val; results in other type.
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> ans = new ArrayList<>();
      
        PriorityQueue<triplet> pq = new PriorityQueue<>();
      
        for (int i = 0; i < lists.size(); i++) {
            triplet temp = new triplet(i, 0, lists.get(i).get(0));
            pq.add(temp);
        }

        while (pq.size() > 0) {
            triplet top = pq.remove();
            ans.add(top.val);

            int newLi = top.listNum;
            int newIdx = top.idx + 1;

            if (newIdx < lists.get(top.listNum).size()) {
                int newVal = lists.get(newLi).get(newIdx);

                triplet temp = new triplet(newLi, newIdx, newVal);
                pq.add(temp);
            }

        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
