/*
Q. Counting Subarrays Easy
Problem Description
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.

Problem Constraints
1 <= N <= 10^3
1 <= A[i] <= 1000
1 <= B <= 10^7

Input Format
First argument is an integer array A.
Second argument is an integer B.


Output Format
Return an integer denoting the number of subarrays in A having sum less than B.

Example Input
Input 1:
 A = [2, 5, 6]
 B = 10

Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:
 4

Output 2:
 4


Example Explanation
Explanation 1:
 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},

Explanation 2:
 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}

*/

//--- Better Approach ---
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size(), cnt = 0, sum = 0;
        for(int i=0; i<n; i++) {
            if(A.get(i) >= B) 
                continue;

            sum = 0;                    
            for(int j=i; j<n; j++) {
                if (sum + A.get(j) < B) {
                    sum += A.get(j);
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}

//--- Using prefix array ---
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size(), cnt = 0;

        int[] prefixArray = new int[n+1];
        prefixArray[0] = 0;
        for(int i=1; i<=n; i++) {
            prefixArray[i] = prefixArray[i-1] + A.get(i-1);  
        }

        for(int i=0; i<n; i++) {
            if(A.get(i) >= B) 
                continue;

            for(int j=i+1; j<=n; j++) {
                if((prefixArray[j] - prefixArray[i]) < B) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}



// Another better approach is sliding window approach with 2 pointers mentioned in https://www.geeksforgeeks.org/number-subarrays-sum-less-k/
