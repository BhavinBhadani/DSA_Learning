/*
Q. Single Number
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
    2 <= |A| <= 2000000
    0 <= A[i] <= INTMAX

Input Format
The first and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1:
 A = [1, 2, 2, 3, 1]

Input 2:
 A = [1, 2, 2]


Example Output
Output 1:
 3

Output 2:
 1
*/

public class Solution {
    public int singleNumber(final int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; i++)
            res = res ^ A[i];
     
        return res;
    }
}

//--- Another Approach ---
public class Solution {
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int i=0; i<=30; i++) {
            int cnt = 0;
            for(int j=0; j<A.length; j++) {
                if ((A[j] & (1 << i)) != 0)
                    cnt++;
            }

            if(cnt%2==1)
                ans = ans + (1<<i);
        }
        return ans;
    }
}

