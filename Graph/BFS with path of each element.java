vector<pair<int, string>> bfs(vector<vector<Edge>> graph, int src)
{
    vector<pair<int, string>> ans;
    queue<pair<int, string>> q;
    vector<bool> vis(graph.size(), false);
    vis[src] = true;
    q.push({src, "@" + to_string(src)});
    while (!q.empty())
    {
        pair<int, string> temp = q.front();
        q.pop();
        ans.push_back(temp);
        for (auto it : graph[temp.first])
        {
            if (vis[it.nbr] == false)
            {
                q.push({it.nbr, temp.second + to_string(it.nbr)});
                vis[it.nbr] = true;
            }
        }
    }
    return ans;
}
// string is path, int is node (pair<int,string>)
