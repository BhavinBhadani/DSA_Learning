/*
Q. tolower()

Problem Description
You are given a function to_lower() which takes a character array A as an argument.

Convert each character of A into lowercase characters if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.

Return the lowercase version of the given character array.


Problem Constraints
1 <= |A| <= 105


Input Format
The only argument is a character array A.


Output Format
Return the lowercase version of the given character array.


Example Input
Input 1:
 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']

Input 2:
 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:
 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']

Output 2:
 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:
 All the characters in the returned array are in lowercase alphabets.
*/

    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        ArrayList<Character> res = new ArrayList<Character>();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) >= 'A' && A.get(i) <= 'Z') {
                res.add((char)(A.get(i) ^ (1<<5)));
            } else {
                res.add(A.get(i));
            }
        }
        return res;
    }

//---- Another Approach ----
    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        ArrayList<Character> res = new ArrayList<Character>();
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) >= 'A' && A.get(i) <= 'Z') {
                res.add((char)(A.get(i) + 'a' - 'A'));
            } else {
                res.add(A.get(i));
            }
        }
        return res;
    }
