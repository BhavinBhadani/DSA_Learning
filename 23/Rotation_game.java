/*
Q. Rotation Game
Problem Description
Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 10^6
1 <= A[i] <=10^8
1 <= B <= 10^9


Input Format
There are 2 lines in the input
Line 1: The first number is the size N of the array A. Then N numbers follow which indicate the elements in the array A.
Line 2: A single integer B.


Output Format
Print array A after rotating it B times towards the right.


Example Input
Input 1 :
4 1 2 3 4
2


Example Output
Output 1 :
3 4 1 2


Example Explanation
Example 1 :
N = 4, A = [1, 2, 3, 4] and B = 2.
Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Final array = [3, 4, 1, 2]
*/

// LOGIC:
// Reverse full array
// Reverse first part of an array(0 to B-1)
// Reverse last part of an array(B to N-1)

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = scn.nextInt();
        }

        int B = scn.nextInt() % N; // condition because if B is more than N
        int p1 = 0, p2 = N-1;
        A = reverseArray(A, p1, p2);
        
        p2 = B-1;
        A = reverseArray(A, p1, p2);

        p1 = B;
        p2 = N-1;
        A = reverseArray(A, p1, p2);
        for(int i=0; i<N; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static int[] reverseArray(int[] A, int p1, int p2) {
        while(p1 < p2) {
            int temp = A[p1];
            A[p1] = A[p2];
            A[p2] = temp;
            p1++;
            p2--;
        }

        return A;
    }
}
