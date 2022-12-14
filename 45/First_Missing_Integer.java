/*
Q. First Missing Integer
Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 10^9

Input Format
First argument is an integer array A.


Output Format
Return an integer denoting the first missing positive integer.


Example Input
Input 1:
[1, 2, 0]

Input 2:
[3, 4, -1, 1]

Input 3:
[-8, -7, -6]


Example Output
Output 1:
3

Output 2:
2

Output 3:
1


Example Explanation
Explanation 1:
A = [1, 2, 0]
First positive integer missing from the array is 3.
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i=0; i<n; i++) {
            while(A[i]>0 && A[i]<=n && A[i]!=i+1) {
                int e = A[i];
                if(A[i] == A[e-1]) break;
                A[i] = A[i] ^ A[e-1];
                A[e-1] = A[i] ^ A[e-1];
                A[i] = A[i] ^ A[e-1];
            }
        }

        for(int i=0; i<n; i++) {
            if(A[i] != i+1) 
                return i+1;
        }
        return n+1;
    }
}

