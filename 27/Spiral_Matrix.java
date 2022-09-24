/*
Q. Spiral Order Matrix II
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements added in spiral order.


Example Input
Input 1:
1

Input 2:
2

Input 3:
5


Example Output
Output 1:
[ [1] ]

Output 2:
[ [1, 2], [4, 3] ]

Output 2:
[ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]


Example Explanation
Explanation 1:
Only 1 is to be arranged.

Explanation 2:
1 --> 2
      |
      |
4<--- 3

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        int[][] resMatrix = new int[A][A];

        int cnt = 1;
        int i=0, j=0;
        while(A>0) {    
            
            for(int k=1; k<A; k++) {
                resMatrix[i][j] = cnt;
                cnt++;
                j++;
            }

            for(int k=1; k<A; k++) {
                resMatrix[i][j] = cnt;
                cnt++;
                i++;
            }

            for(int k=1; k<A; k++) {
                resMatrix[i][j] = cnt;
                cnt++;
                j--;
            }

            for(int k=1; k<A; k++) {
                resMatrix[i][j] = cnt;
                cnt++;
                i--;
            }

            A-=2;
            if(A<0) {
                resMatrix[i][j] = cnt;
            }
            
            i++; j++;
        }
        
        for(int r=0; r<resMatrix.length; r++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            for(int c=0; c<resMatrix[r].length; c++) {
                e.add(resMatrix[r][c]);
            }
            res.add(e);
        }

        return res;
    }
}
