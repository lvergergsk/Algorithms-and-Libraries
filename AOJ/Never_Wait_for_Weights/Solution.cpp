#include <vector>
#include <iostream>
using namespace std;
const int INF = 1000000000;
#define REP(i,s,n) for(int i=(int)(s);i<(int)(n);i++)
#define rep(i,n) REP(i, 0, n)
 
struct UnionFind
{
    vector<int> data;
    vector<int> rootd;//rootd[i] : dist from node[i] to node[root(i)]
    UnionFind(int N) : data(N), rootd(N, 0)
    {
        for (int i = 0; i != N; ++i) { data[i] = i; }
    }
 
    void unite(int x_, int y_, int weight)
    {
        int x = root(x_), y = root(y_);
        if (x != y)
        {
            //          data[x] += data[y];
            data[y] = x;
            rootd[y] = weight - rootd[y_] + rootd[x_];
        }
    }
 
    int root(int x_)
    {
        int x = x_;
        vector<int> memo;
        while (data[x] != x)
        {
            memo.push_back(x);
            x = data[x];
        }
        int res = x;
        for (int i = memo.size() - 1; i >= 0; --i)
        {
            int k = memo[i];
            rootd[k] += rootd[data[k]];
            data[k] = res;
        }
        return res;
    }
 
    int dist(int a, int b) { return rootd[b] - rootd[a]; }
    bool same(int a, int b) { return root(a) == root(b); }
};
 
int main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);
    int N, M;
    while (cin >> N >> M && N)
    {
        UnionFind uf(N);
        char q;
        int a, b;
        int w;
        rep(i, M)
        {
            cin >> q >> a >> b;
            --a;
            --b;
            if (q == '?')
            {
                if (uf.same(a, b)) cout << uf.dist(a, b) << '\n';
                else cout << "UNKNOWN" << '\n';;
            }
            else
            {
                cin >> w;
                uf.unite(a, b, w);
            }
        }
    }
    return 0;
}