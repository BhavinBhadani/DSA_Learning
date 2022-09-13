/*
Q. Implement Power Function

Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.


Problem Constraints
-109 <= A <= 10^9
0 <= B <= 10^9
1 <= C <= 10^9


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


//---- Another Approach ---
    public int pow(int A, int B, int C) {
        if(A<0 && B==1) 
            return A+C;

        if(A==0) 
            return 0;

        if(B==0) 
            return 1;
        
        long e = pow(A, B>>1, C) % C; // pow(A, B/2, C) % C;
        long f = ((e % C) * (e % C)) % C;

        if ((B & 1) == 0) { // (B % 2 == 0) 
            return (int)f;
        } else {
            return (int)(((f % C) * (A % C)) % C); 
        }

    }
