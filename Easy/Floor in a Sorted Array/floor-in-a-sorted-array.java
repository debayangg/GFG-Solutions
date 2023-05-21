//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int l=0,h=n-1;
        
        if(arr[l]>x)
        return -1;
        
        if(arr[h]<x)
        return h;
        
        while(l<h)
        {
            int mid=(h-l)/2 +l;
            //System.out.println(mid );
            if(arr[mid]>x)
            {
                if(arr[mid-1]<=x)
                return mid-1;
                else
                h=mid-1;
            }
            else if(arr[mid]<x)
            {
                if(arr[mid+1]>x)
                return mid;
                else if(arr[mid+1]==x)
                return mid+1;
                else
                l=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
    
}
