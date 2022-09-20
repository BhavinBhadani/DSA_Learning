/*
Q. Product array puzzle
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.


Input Format
The only argument given is the integer array A.

Output Format
Return the product array.

Constraints
2 <= length of the array <= 1000
1 <= A[i] <= 10

For Example
Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]

*/

// --- Approach 1 (With prefix and suffix array) ----
public class Solution {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] pf = prefixProduct(A, n);
        int[] sf = suffixProduct(A, n);

        for(int i=0; i<n; i++) 
            arr.add(pf[i] * sf[i]);

        return arr;
    }

    public static int[] prefixProduct(ArrayList<Integer> A, int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i=1; i<n; i++) 
            arr[i] = A.get(i-1) * arr[i-1];

        return arr;
    }

    public static int[] suffixProduct(ArrayList<Integer> A, int n) {
        int[] arr = new int[n];
        arr[n-1] = 1;
        for(int i=n-2; i>=0; i--) 
            arr[i] = A.get(i+1) * arr[i+1];
        return arr;
    }

}

// --- Approach 2 ---
public class Solution {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int product = 1;
        for(int i=0; i<n; i++) {
            product *= A.get(i);
        }

        for(int i=0; i<n; i++) {
            arr.add(product/A.get(i));
        }
        
        return arr;
    }
}
