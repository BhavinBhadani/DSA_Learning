/*
Q. Second Largest
Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints
1 <= |A| <= 10^5
0 <= A[i] <= 10^9


Input Format
The first argument is an integer array A.

Output Format
Return the second largest element. If no such element exist then return -1.


Example Input
Input 1:
 A = [2, 1, 2] 

Input 2:
 A = [2]


Example Output
Output 1:
 2 

Output 2:
 -1 


Example Explanation
Explanation 1:
 First largest element = 2
 Second largest element = 2
 Third largest element = 1

Explanation 2:
 There is no second largest element in the array.

*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n<2)
            return -1;

        int largest = Integer.MIN_VALUE, second = -1, largestCount = 0;
        for(int i=0; i<n; i++) {
            largest = Math.max(largest, A.get(i));
        }

        for(int i=0; i<n; i++) {
            // if second largest is not equal to largest then this if block is not neccessary
            if(largest == A.get(i)) {
                largestCount++;
                if(largestCount > 1) {
                    return largest;
                }
            }

            if(A.get(i) != largest)
                second = Math.max(second, A.get(i));
        }

        return second;
    }
}

// --- Better Approach ----
public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n<2)
            return -1;

        int largest = Integer.MIN_VALUE, second = -1;
        for(int i=0; i<n; i++) {
            // if second largest is not equal to largest then we can have only great than(>) condition instead of great or equal to(>=)
            if(A.get(i) >= largest) { 
                second = largest;
                largest = A.get(i);
            }
            else if(A.get(i) > second && A.get(i) != largest) {
                second = A.get(i);
            }
        }

        return second;
    }
}

