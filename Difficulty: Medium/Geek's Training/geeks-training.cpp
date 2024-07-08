//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    int maximumPoints(vector<vector<int>>& points, int n) {
      vector<vector<int>> dp(n+1 , vector<int>(4,-1));
      dp[0][1]=points[0][0];
      dp[0][2]=points[0][1];
      dp[0][3]=points[0][2];
      for(int i=1;i<n;i++)
      {
          for(int j=1;j<=3;j++)
          {
              int a,b,c;
              a=b=c=INT_MIN;
              if(j==1)
              {
                  b=dp[i-1][2];
                  c=dp[i-1][3];
                  dp[i][j]=max(b,c)+points[i][j-1];
              }
              else if(j==2)
              {
                  a=dp[i-1][1];
                  c=dp[i-1][3];
                  dp[i][j]=max(a,c)+points[i][j-1];
              }
              else
              {
                  a=dp[i-1][1];
                  b=dp[i-1][2];
                  dp[i][j]=max(b,a)+points[i][j-1];
              }
          }
      }
      return max(dp[n-1][1],max(dp[n-1][2],dp[n-1][3]));
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> points;
        for (int i = 0; i < n; ++i) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            points.push_back(temp);
        }

        Solution obj;
        cout << obj.maximumPoints(points, n) << endl;
    }
    return 0;
}
// } Driver Code Ends