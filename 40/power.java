/*
Q. Implement Power Function

Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.


Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109


Input Format
Given three integers A, B, C.


Output Format
Return an integer.

Example Input
A = 2, B = 3, C = 3

Example Output
2

Example Explanation
23 % 3 = 8 % 3 = 2
*/

    public int pow(int A, int B, int C) {
        if(A==0) return 0;
        long res = 1;
        long x=A;

        while(B>0){
            if((B&1)==1) 
                res = (res*x)%C;
            B = B>>1; 
            x = (x*x)%C;  
        }
        return (int)((C + res)%C);
    }
