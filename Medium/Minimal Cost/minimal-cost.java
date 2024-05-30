//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int a[],int N,int K){
        int[] arr = new int[N];
        arr[0]=0;
        arr[1]=Math.abs(a[1]-a[0]);
        for(int i=2;i<N;i++)
        {
            arr[i]=Integer.MAX_VALUE;
            for(int j=i-1;j>=0 && j>=i-K;j--)
            {
                arr[i]=Math.min(arr[i],arr[j]+Math.abs(a[i]-a[j]));
            }
        }
        return arr[N-1];
    }
}
