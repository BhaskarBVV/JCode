#include <bits/stdc++.h>
using namespace std;
class pairr
{
public:
    int node, parent, cost;
    pairr(){};
    pairr(int a, int b, int c)
    {
        node = a;
        parent = b;
        cost = c;
    }
};
struct comp
{
    bool operator()(pairr &a, pairr &b)
    {
        return b.cost < a.cost;
    }
};
int main()
{
    int n, m, a, b, w;
    cin >> n >> m;
    vector<pair<int, int>> adj[n];
    while (m--)
    {
        cin >> a >> b >> w;
        adj[a].push_back({b, w});
        adj[b].push_back({a, w});
    }
    priority_queue<pairr, vector<pairr>, comp> pq;
    pq.push(pairr(0, -1, 0));
    vector<bool> vis(n, false);
    vis[0] = true;
    int cst = 0;
    vector<pairr> final;
    while (!pq.empty())
    {
        pairr temp = pq.top();

        pq.pop();
        // cout << temp.node << " " << temp.parent << " " << temp.cost << endl;
        if (vis[temp.node] == false)
        {
            cst += temp.cost;
            final.push_back(temp);
        }
        vis[temp.node] = true;
        for (auto it : adj[temp.node])
        {
            if (vis[it.first] == false)
                pq.push(pairr(it.first, temp.node, it.second));
        }
    }
    for (auto it : final)
        cout << "[" << it.node << "-" << it.parent << "@" << it.cost << "]" << endl;
    // cout << cst << endl;
}
