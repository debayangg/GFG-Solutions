//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int minimumEnergy(vector<int>& height, int n) {
        vector<int> arr(n,-1);
        arr[0]=0;
        arr[1]=abs(height[0]-height[1]);
        for(int i=2;i<n;i++)
        {
            arr[i]=min(arr[i-1]+abs(height[i]-height[i-1]),arr[i-2]+abs(height[i]-height[i-2]));
        }
        return arr[n-1];
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        Solution obj;
        cout << obj.minimumEnergy(arr, N) << "\n";
    }
    return 0;
}
// } Driver Code Ends