/*
Q. Sum of pairwise Hamming Distance
Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
For example,
HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).
Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array. Return the answer modulo 1000000007.

Example
Let f(x, y) be the hamming distance defined above.
A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8

*/

public class Solution {
    public int hammingDistance(final int[] A) {
        long ans = 0, n = A.length;
        for (int i = 0; i <= 30; i++) {
            long count = 0; // number of elements with ith bit set
            for (int j = 0; j < n; j++) {
                if ( (A[j] & (1 << i)) != 0 )
                    count++;
            }
            long clear = n - count;
            long diff = count * clear * 2; 
            ans = (ans + diff)%1000000007 ; // mul by 2 because {1,2} and {2,1} different pairs
        }
        return (int)ans;
    }
}
