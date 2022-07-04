//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
class Solution {
      long cnt;

      public void call(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> vis) {
         cnt += 1;
         vis.set(i, 1);
         for (Integer it : adj.get(i)) {
            if (vis.get(it) == -1)
               call(adj, it, vis);
         }
      }

      public long countPairs(int n, int[][] edges) {

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
         for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
         for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
         }

         ArrayList<Integer> vis = new ArrayList<>();
         for (int i = 0; i < n; i++)
            vis.add(-1);
         ArrayList<Long> ans = new ArrayList<>();

         long pro = 0, sum = 0;
         for (int i = 0; i < n; i++) {
            if (vis.get(i) == -1) {
               cnt = 0;
                call(adj, i, vis);
               pro += sum * cnt;
               sum += cnt;
            }
         }
         return pro;
      }
   }
