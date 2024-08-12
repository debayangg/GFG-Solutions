//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int numProvinces(vector<vector<int>> &isConnected, int n) {
        vector<int> visited(n,0),stk;
        int count=0;
        for(int i=0;i<visited.size();i++)
        {
            if(!visited[i])
            {
                count++;
                stk.push_back(i);
            }
            while(stk.size())
            {
                int v = stk[stk.size()-1];
                stk.pop_back();
                if(!visited[v]){
                    visited[v]++;
                    for(int j=0;j<n;j++)
                    {
                        if(isConnected[v][j])
                        stk.push_back(j);
                    }
                }
            }
        }
        return count;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V,x;
        cin>>V;
        
        vector<vector<int>> adj;
        
        for(int i=0; i<V; i++)
        {
            vector<int> temp;
            for(int j=0; j<V; j++)
            {
                cin>>x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }
        

        Solution ob;
        cout << ob.numProvinces(adj,V) << endl;
    }
    return 0;
}
// } Driver Code Ends