/*
Q. Subarray with given sum
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9


Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5

Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110

Example Output
Output 1:
 [2, 3]

Output 2:
 -1


Example Explanation
Explanation 1:
 [2, 3] sums up to 5.

Explanation 2:
 No subarray sums up to required number.
*/

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currentSum = A.get(0), start = 0, i;
 
        // Pick a starting point
        for (i = 1; i <= A.size(); i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > B && start < i - 1) {
                currentSum = currentSum - A.get(start);
                start++;
            }
 
            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == B) {
                int p = i - 1;

                for(int j=start; j<=p; j++) {
                    res.add(A.get(j));
                }
                return res;
            }
 
            // Add this element to curr_sum
            if (i < A.size())
                currentSum = currentSum + A.get(i);
        }

        if(res.size() == 0)
            res.add(-1);
        return res;
    }
