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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int h[],int n){
        int[] arr= new int[n];
        arr[0]=0;
        if(n>1)
        arr[1]=Math.abs(h[1]-h[0]);
        for(int i=2;i<n;i++)
        {
            arr[i]=Math.min(arr[i-1]+Math.abs(h[i]-h[i-1]),
                            arr[i-2]+Math.abs(h[i]-h[i-2]));
        }
        return arr[n-1];
    }
}
