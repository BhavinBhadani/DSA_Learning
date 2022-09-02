/*
Q. First Repeating element

Problem Description
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.


Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9


Input Format
The first and only argument is an integer array A of size N.

Output Format
Return an integer denoting the first repeating element.


Example Input
Input 1:
 A = [10, 5, 3, 4, 3, 5, 6]

Input 2:
 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:
 5

Output 2:
 -1


Example Explanation
Explanation 1:
 5 is the first element that repeats

Explanation 2:
 There is no repeating element, output -1
*/

//---- Approach 1 ----

    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<A.size(); i++) {
            if(hm.containsKey(A.get(i))) {
                Integer freq = (Integer)hm.get(A.get(i));
                hm.put(A.get(i), freq+1);
            } else {
                hm.put(A.get(i), 1);
            }
        }
      
        for(int i=0; i<A.size(); i++) {
            if(hm.get(A.get(i)) > 1) {
                return A.get(i);
            }

        }

        return -1;
    }


//---- Approach 2 ----

    public int solve(ArrayList<Integer> A) {
        // Initialize index of first repeating element
        int minimumIndex = -1;
 
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Iterate over the input array from right to left
        for (int i=A.size()-1; i>=0; i--) {
            // If set contains the element, update minimum index
            if (set.contains(A.get(i)))
                minimumIndex = i;
            else   
                // Else add element to hash set
                set.add(A.get(i));
        }

        if (minimumIndex != -1) {
            return A.get(minimumIndex);
        }

        return -1;
    }
