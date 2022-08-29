/*
Q. Noble Integer

Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.


Problem Constraints
1 <= |A| <= 2*105
1 <= A[i] <= 107


Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is present else, return -1.


Example Input
Input 1:
 A = [3, 2, 1, 3]

Input 2:
 A = [1, 1, 3, 3]

Example Output
Output 1:
 1

Output 2:
 -1


Example Explanation
Explanation 1:
 For integer 2, there are 2 greater elements in the array..

Explanation 2:
 There exist no integer satisfying the required conditions.
*/
    
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 1) {
            return (A.get(0) == 0) ? 1 : -1;
        }
            
        Collections.sort(A, Collections.reverseOrder());
        int higher = 0;
        for(int i=0; i<n; i++) {
            if(i>0 && (A.get(i) == A.get(i-1))) {
                
            } else {
                higher = i;
            }
            
            if(higher == A.get(i)) {
                return 1;
            }
        }
        return -1;
    }
