//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static long[] arr = new long[100000]; 
    static long topDown(int n) {
        if(n<=1)return n;
        
        long mod = 1000000007;
        
        if(arr[n]!=0)
        return arr[n];
        
        return arr[n]=(topDown(n-1)%mod+topDown(n-2)%mod)%mod;
    }

    static long bottomUp(int n) {
        long mod = 1000000007;
        
        arr[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            arr[i]=(arr[i-1]%mod+arr[i-2]%mod)%mod;
        }
        return arr[n];
    }
}
