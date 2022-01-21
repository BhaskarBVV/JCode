import java.util.*;

public class editor3 {
    public static Scanner sc = new Scanner(System.in);
    static int cnt;

    static boolean[] vis;

    public static void dfs(int i, int[] color, ArrayList<ArrayList> adj, boolean[] vis, int root_col) {
        vis[i] = true;
        if (color[i] != root_col) {
            cnt += 1;
        }
        ArrayList<Integer> temp = adj.get(i);
        for (Integer it : temp)
            if (vis[it] == false)
                dfs(it, color, adj, vis, color[i]);
    }

    static void solve() {
        int n = sc.nextInt(), a;
        int[] color = new int[n];
        ArrayList<ArrayList> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            a = sc.nextInt();
            adj.get(a - 1).add(i);
            adj.get(i).add(a - 1);
        }
        for (int i = 0; i < n; i++) {
            color[i] = sc.nextInt();
        }
        cnt = 0;
        int root_col = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; i++)
            vis[i] = false;
        dfs(0, color, adj, vis, root_col);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        int n;
        n = 1;
        // n = sc.nextInt();
        while (n-- > 0) {
            solve();
        }
        sc.close();
    }
}
