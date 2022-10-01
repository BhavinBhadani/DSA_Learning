/*
Maximum Sum Square SubMatrix

Problem Description
Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.


Problem Constraints
1 <= N <= 10^3.
1 <= B <= N
-10^2 <= A[i][j] <= 10^2.


Input Format
First arguement is an 2D integer matrix A.
Second argument is an integer B.


Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.


Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3

Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2



Example Output
Output 1:
 48

Output 2:
 8

*/

//--- Brute Force ---
public class Solution {
    public int solve(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i+B <= row && j+B <= col) {
                    int sum = 0;
                    for(int k=i; k<i+B; k++) {
                        for(int l=j; l<j+B; l++) {
                            sum += A[k][l];
                        }
                    }
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}

//--- Solution with DP (Better solution) ---
public class Solution {
    public int solve(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] dp = new int[row+1][col+1];

        // sum
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                dp[i][j] = A[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        // process
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                // B*B
                int sum = Integer.MIN_VALUE;
                if(i-B>=0 && j-B>=0) {
                    sum = dp[i][j] - dp[i-B][j] - dp[i][j-B] + dp[i-B][j-B];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}

