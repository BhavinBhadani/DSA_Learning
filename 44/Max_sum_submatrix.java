/*
Q. Maximum Sum Submatrix
Problem Description
Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.

Problem Constraints
1 <= N, M <= 300
-104 <= A[i][j] <= 10^4

Input Format
The first argument is a 2D Integer array A.

Output Format
Return the sum of the maximum sum sub-matrix from matrix A.

Example Input
Input 1:-
    -6 -6
   -29 -8
A =  3 -8
   -15  2
    25 25
    20 -5

Input 2:-
A = -17 -2
     20 10


Example Output
Output 1:-
65

Output 2:-
30


Example Explanation
Explanation 1:-

The submatrix 
25 25
20 -5
has the highest submatrix sum 65.

Explanation 2:-

The submatrix 
20 10
has the highest sub matrix sum 30.
*/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int ans = A.get(0).get(0);
        for(int s=0; s<N; s++) {
            int sum[] = new int[M];
            for(int e=s; e<N; e++) {
                for(int i=0; i<M; i++) {
                    sum[i] += A.get(e).get(i);
                }

                int max = sum[0], curMax = sum[0];
                for(int v=1; v<sum.length; v++) {
                    curMax = Math.max(sum[v], curMax+sum[v]);
                    max = Math.max(max, curMax);
                }

                ans = Math.max(max, ans);
            }
        }
        return ans;
    }
}
