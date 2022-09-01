/*
Q. toupper()

Problem Description

You are given a function to_upper() consisting of a character array A.

Convert each charater of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.

Return the uppercase version of the given character array.


Problem Constraints
1 <= |A| <= 105


Input Format
Only argument is a character array A.


Output Format
Return the uppercase version of the given character array.


Example Input
Input 1:
 A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']

Input 2:
 A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']


Example Output
Output 1:
 ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']

Output 2:
 ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:
 All the characters in the returned array are in uppercase alphabets.
 */


    public static ArrayList<Character> to_lower(ArrayList<Character> A) {
        ArrayList<Character> res = new ArrayList<Character>();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) >= 'a' && A.get(i) <= 'z') {
                res.add((char)(A.get(i) ^ (1<<5)));
            } else {
                res.add(A.get(i));
            }
        }
        return res;
    }

//----Another Approach----
    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        ArrayList<Character> res = new ArrayList<Character>();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) >= 'a' && A.get(i) <= 'z') {
                res.add((char)(A.get(i) + 'A' - 'a'));
            } else {
                res.add(A.get(i));
            }
        }
        return res;
    }
