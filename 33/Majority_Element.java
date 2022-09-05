/*
Q. Majority Element

Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exists in the array.

Problem Constraints
1 <= N <= 5*10^5
1 <= num[i] <= 109

Input Format
Only argument is an integer array.

Output Format
Return an integer.

Example Input
[2, 1, 2]


Example Output
2

Example Explanation
2 occurs 2 times which is greater than 3/2.

*/

    public static int majorityElement(final List<Integer> A) {
        int m = A.get(0);
        int n = 1;
        for(int i=1; i<A.size(); i++) {
            if(n==0) { 
                m = A.get(i); 
            }
            
            if(A.get(i) == m) {
                n++;
            } else {
                n--;
            }
        }

        return m;
    }
