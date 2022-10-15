/*
Problem Description
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
Find the maximum value of GCD.


Problem Constraints

2 <= N <= 10^5
1 <= A[i] <= 10^9


Input Format
First argument is an integer array A.


Output Format
Return an integer denoting the maximum value of GCD.


Example Input
Input 1:
 A = [12, 15, 18]

Input 2:
 A = [5, 15, 30]


Example Output
Output 1:
 6

Output 2:
 15



Example Explanation
Explanation 1:
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.

Explanation 2:
 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.

*/

public class Solution {
    public int solve(int[] A) {
        return MaxGCD(A, A.length);
    }

    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    
    public int MaxGCD(int a[], int n)
    {
     
        // Prefix and Suffix arrays
        int Prefix[] = new int[n + 2];
        int Suffix[] = new int[n + 2] ;
     
        // Single state dynamic programming relation
        // for storing gcd of first i elements
        // from the left in Prefix[i]
        Prefix[1] = a[0];
        for (int i = 2; i <= n; i += 1)
        {
            Prefix[i] = gcd(Prefix[i - 1], a[i - 1]);
        }
     
        // Initializing Suffix array
        Suffix[n] = a[n - 1];
     
        // Single state dynamic programming relation
        // for storing gcd of all the elements having
        // greater than or equal to i in Suffix[i]
        for (int i = n - 1; i >= 1; i -= 1)
        {
            Suffix[i] = gcd(Suffix[i + 1], a[i - 1]);
        }
     
        // If first or last element of
        // the array has to be removed
        int ans = Math.max(Suffix[2], Prefix[n - 1]);
     
        // If any other element is replaced
        for (int i = 2; i < n; i += 1)
        {
            ans = Math.max(ans, gcd(Prefix[i - 1], Suffix[i + 1]));
        }
     
        // Return the maximized gcd
        return ans;
    }
}
