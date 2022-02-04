#include <bits/stdc++.h>
using namespace std;
int LIS(vector<int> a, int i, vector<int> al)
{
    if (i > a.size())
        return 0;
    if (al.size() > 1 && al[al.size() - 1] <= al[al.size() - 2])
        return 0;
    if (i == a.size())
    {
        return al.size();
    }
    int x = LIS(a, i + 1, al);
    al.push_back(a[i]);
    int y = LIS(a, i + 1, al);
    // al.pop_back();
    return max(x, y);
}

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for (auto &it : v)
        cin >> it;
    vector<int> al;
    int ans = LIS(v, 0, al);
    cout << ans;
}
