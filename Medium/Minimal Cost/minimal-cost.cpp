//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int minimizeCost(vector<int>& a, int N, int k) {
        int arr[N];
        arr[0]=0;
        arr[1]=abs(a[1]-a[0]);
        for(int i=2;i<N;i++)
        {
            arr[i]=INT_MAX;
            for(int j=i-1;j>=0 && j>=i-k;j--)
            {
                arr[i]=min(arr[i],arr[j]+abs(a[i]-a[j]));
            }
        }
        return arr[N-1];
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> N >> K;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        Solution obj;
        cout << obj.minimizeCost(arr, N, K) << "\n";
    }
    return 0;
}
// } Driver Code Ends