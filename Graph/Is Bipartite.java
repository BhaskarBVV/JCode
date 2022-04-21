class Solution {
    public class pair {
        int vertex, color;

        pair() {
        }

        pair(int vtx, int clr) {
            this.vertex = vtx;
            this.color = clr;
        }
    }

    public boolean isBipartite(int[][] graph) 
    {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);

        Queue<pair> q = new LinkedList<>();

        for (int i = 0; i < vis.length; i++) 
        {
            if (vis[i] == -1) 
            {
                q.add(new pair(i, 1));
                while (q.size() != 0) 
                {
                    pair temp = q.remove();
                    if (vis[temp.vertex] != -1) 
                    {
                        // remove krne ke baad ek baar aur check krlo 
                        // kya pata ye vertex kisi aur color se visit hua ho vis main
                        if (vis[temp.vertex] == temp.color)
                            continue;
                        else
                            return false;
                    } 
                    else 
                    {
                        vis[temp.vertex] = temp.color;
                        // remove krte main mark krna
                        for (Integer it : graph[temp.vertex]) 
                        {
                            if (vis[it] == -1) 
                            {
                                // insert krte main mark mat krna vis main
                                // bcz maanlo ek node x hai, wo y and z do nodes se joint hai
                                // toh agar y se x ko enter kroge queue main and use mark kr doge toh z ke through enter ni kr paaoege
                                // and jab multiple times add ni kr paaoge, toh check kaise kroge, ("color from other nodes").
                                q.add(new pair(it, 1 - temp.color));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
