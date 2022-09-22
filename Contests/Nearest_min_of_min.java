/*
Q. Nearest Minimum of Minimums
Given an array A of N integers, you have to find the shortest distance between the smallest element that occurs at least twice.
Note: Distance between 2 elements is the difference between their indices

Constraints:
1<= Size of array <=100000

Input Format
An array A

Output Format
Shortest distance between the smallest element that occurs at least twice.

Example Input
A:[0 1 0]

Example Output
2

Explanation
Here the minimum element is 0 and minimum distance between the minimum element i.e. 0 is 2
*/

 public class Solution {
    public int solve(int[] A) {
        int minDistance = Integer.MAX_VALUE;
        int N = A.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            if(map.containsKey(A[i])) {
                int e = map.get(A[i]);
                map.put(A[i], e + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() > 1) {
                minValue = Math.min(minValue, e.getKey());
            }
        }
        
        int startPoint = -1;
        for(int i=0; i<N; i++) {
            if(A[i] == minValue) {
                if(startPoint != -1) {
                    return i - startPoint;
                } else {
                    startPoint = i;
                }
            }
        }
        
        return 0;
    }
}
