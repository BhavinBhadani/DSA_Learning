/*
Q. Rain Water Trapped
Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is the vector A

Output Format
Return one integer, the answer to the question

Example Input
Input 1:
A = [0, 1, 0, 2]

Input 2:
A = [1, 2]

Example Output
Output 1:
1

Output 2:
0

Example Explanation
Explanation 1:
1 unit is trapped on top of the 3rd element.

Explanation 2:
No water is trapped.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int[] pfMax = prefixMax(A);
        int[] sfMax = suffixMax(A);
        int ans = 0;
        for(int i=1; i<A.size()-1; i++) {
            int pf = pfMax[i-1];
            int sf = sfMax[i+1];
            int n = Math.min(pf, sf) - A.get(i);
            if(n>0)
                ans += n;
        }
        return ans;
    }

    public int[] prefixMax(List<Integer> A) {
        int[] a = new int[A.size()];
        a[0] = A.get(0);
        for(int i=1; i<A.size(); i++) {
            a[i] = Math.max(a[i-1], A.get(i));
        }
        return a;
    }

    public int[] suffixMax(List<Integer> A) {
        int[] a = new int[A.size()];
        a[A.size()-1] = A.get(A.size()-1);
        for(int i=A.size()-2; i>=0; i--) {
            a[i] = Math.max(a[i+1], A.get(i));
        }
        return a;
    }
}
