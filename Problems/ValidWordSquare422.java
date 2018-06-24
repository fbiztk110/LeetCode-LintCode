/* Description
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 <= k < max(numRows, numColumns).

Example
Given
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
return true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Given
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
return true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Given
[
  "ball",
  "area",
  "read",
  "lady"
]
return false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
*/

//LintCode 888
/**
 * ValidWordSquare422
 */
public class ValidWordSquare422 {

    public boolean validWordSquare(String[] words) {
        // Write your code here
        if (words.length == 0 || words.length != words[0].length()) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length(); j++) {
                if (j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "abcd", "bnrt", "crmy", "dtye" };
        System.out.println(new ValidWordSquare422().validWordSquare(words));
    }
}