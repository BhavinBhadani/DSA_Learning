/*
Q. Simple Reverse

Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.


Problem Constraints
1 <= |A| <= 10^5
String A consist only of lowercase characters.


Input Format
First and only argument is a string A.


Output Format
Return a string denoting the reversed string.


Example Input
Input 1:
 A = "scaler"

Input 2:
 A = "academy"
 

Example Output
Output 1:
 "relacs"

Output 2:
 "ymedaca"
 

Example Explanation
Explanation 1:
 Reverse the given string.
*/

    public String solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int p1 = 0, p2 = sb.length()-1;
        while(p1<p2) {
            sb.setCharAt(p1, A.charAt(p2));
            sb.setCharAt(p2, A.charAt(p1));
            p1++;
            p2--;
        }
        return sb.toString();
    }
