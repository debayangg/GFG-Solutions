//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int rowWithMax1s(int arr[][], int n, int m) {
        int max_row=-1,max_pos=-1;
        
        for(int i=0;i<n;i++)
        {
            int pos=helper(arr[i],m);
            if(pos>max_row)
            {
                max_row=pos;
                max_pos=i;
            }
        }
        
        return (max_row>0)?max_pos:-1;
    }
    
    int helper(int arr[], int m)
    {
        int l=0,h=m-1;
        
        if(arr[h]==0)
        return 0;
        
        if(arr[l]==1)
        return m;
        
        while(l<h)
        {
            int mid=(h-l)/2 + l;
            if(arr[mid]==1)
            {
                if(arr[mid-1]==1)
                h=mid-1;
                else
                return m-mid;
            }
            else
            {
                if(arr[mid+1]==0)
                l=mid+1;
                else
                return m-mid-1;
            }
        }
        
        return 0;
    }
}