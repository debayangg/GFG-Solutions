//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long arr[100000];
    long long int topDown(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        
        long long mod=1e9+7;
        
        if(arr[n]==0)
        arr[n]=(topDown(n-1)%mod+topDown(n-2)%mod)%mod;
        
        return arr[n];
    }
    long long int bottomUp(int n) {
        arr[1]=1;
        long long mod=1e9+7;
        for(int i=2;i<=n;i++)
        {
            arr[i]=(arr[i-1]%mod+arr[i-2]%mod)%mod;
        }
        return arr[n];
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;
        long long int topDownans = obj.topDown(n);
        long long int bottomUpans = obj.bottomUp(n);
        if (topDownans != bottomUpans) cout << -1 << "\n";
        cout << topDownans << "\n";
    }
}
// } Driver Code Ends