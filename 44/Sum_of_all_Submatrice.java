/*
Q. Sum of all Submatrices
Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.


Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10


Input Format
Single argument representing a 2-D array A of size N x N.


Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.


Example Input
A = [ [1, 1]
      [1, 1] ]



Example Output
16


Example Explanation
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
*/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int sum = 0;
        int n = A.get(0).size(); 
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                int tl = (r+1) * (c+1);
                int br = (n-r) * (n-c);
                sum += A.get(r).get(c) * tl * br;
            }
        }
        return sum;
    }
}
