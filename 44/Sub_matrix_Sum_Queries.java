/*
Q. Sub-matrix Sum Queries
Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:
    Rows are numbered from top to bottom, and columns are numbered from left to right.
    Sum may be large, so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M


Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.


Output Format
Return an integer array containing the submatrix sum for each query.


Example Input

Input 1:
 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]

Input 2:
 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:
 [12, 28]

Output 2:
 [22, 19]



Example Explanation
Explanation 1:
 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.

Explanation 2:
 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 
*/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> pfMatrix = prefixMatrixSum(A);
        for(int i=0; i<B.size(); i++) {
            int a1 = B.get(i) - 1;
            int b1 = C.get(i) - 1;
            int a2 = D.get(i) - 1;
            int b2 = E.get(i) - 1;
            long sum = pfMatrix.get(a2).get(b2);
            if(a1>0) 
                sum = sum - pfMatrix.get(a1-1).get(b2);

            if(b1>0) 
                sum = sum - pfMatrix.get(a2).get(b1-1); 

            if(a1>0 && b1>0) 
                sum = sum + pfMatrix.get(a1-1).get(b1-1);

            while(sum<0) {
                sum+=1000000007;
            } 

            res.add((int)sum%1000000007);
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> prefixMatrixSum(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        for(int r=0; r<N; r++) {
            for(int c=1; c<M; c++) {
                long sum = A.get(r).get(c-1) + A.get(r).get(c);
                A.get(r).set(c, (int)sum%1000000007);
            }
        }

        for(int c=0; c<M; c++) {
            for(int r=1; r<N; r++) {
                long sum = A.get(r-1).get(c) + A.get(r).get(c);
                A.get(r).set(c, (int)sum%1000000007);
            }
        }
        
        return A;
    }
}
