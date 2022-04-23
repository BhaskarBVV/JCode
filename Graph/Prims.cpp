#include <bits/stdc++.h>
using namespace std;
struct comp
{
    bool operator()(pair<int, int> a, pair<int, int> b)
    {
        return b.second < a.second;
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
    priority_queue<pair<int, int>, vector<pair<int, int>>, comp> pq;
    pq.push({0, 0});
    vector<bool> vis(n, false);
    int cst = 0;
    while (!pq.empty())
    {
        pair<int, int> temp = pq.top();
        pq.pop();
        if (vis[temp.first] == false)
            cst += temp.second;
        vis[temp.first] = true;
        for (auto it : adj[temp.first])
        {
            if (vis[it.first] == false)
                pq.push({it.first, it.second});
        }
    }
    cout << cst << endl;
}
