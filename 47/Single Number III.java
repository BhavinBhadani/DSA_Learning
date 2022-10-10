/*
Q. Single Number III

Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 10^9


Input Format
The first argument is an array of integers of size N.

Output Format
Return an array of two integers that appear only once.


Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]

Input 2:
A = [1, 2]

Example Output
Output 1:
[3, 4]

Output 2:
[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.

Explanation 2:
1 and 2 appear only once.

*/

public class Solution {
    public int[] solve(int[] A) {
        int XOR = A[0];
         
        for (int i = 1; i < A.length; i++)
            XOR = XOR ^ A[i];
 
        // Now XOR has XOR of two missing elements.
        // Any set bit in it must be set in one
        // missing and unset in other missing number
 
        // Get a set bit of XOR (We get the
        // rightmost set bit)
        int set_bit_no = XOR & ~(XOR-1);
 
        // Now divide elements in two sets by
        // comparing rightmost set bit of XOR with
        // bit at same position in each element.
        // Initialize missing numbers
        int x = 0, y = 0;
         
        for (int i = 0; i < A.length; i++)
        {
            if ((A[i] & set_bit_no)>0)
             
                /*XOR of first set in arr[] */
                x = x ^ A[i];
            else
                /*XOR of second set in arr[] */
                y = y ^ A[i];
        }

        int[] result = new int[2];
        if(x > y) {
            result[0] = y;
            result[1] = x;
        } else {
            result[1] = y;
            result[0] = x;
        } 
        return result;
    }
}
