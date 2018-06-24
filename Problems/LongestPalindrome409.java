/* Description
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.
Assume the length of given string will not exceed 1010.

Example
Given s = "abccccdd" return 7

One longest palindrome that can be built is "dccaccd", whose length is 7. 
*/

//LintCode 627
/*Easy*/
import java.util.HashMap;
import java.util.Iterator;

public class LongestPalindrome409 {
    public int solution(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        int counter = 0;
        boolean isMaxFound = false;
        Iterator<Integer> integerIterator = hashMap.values().iterator();
        while (integerIterator.hasNext()) {
            int value = integerIterator.next();
            if (value % 2 == 0) {
                counter += value;
            } else {
                counter += value - 1;
                isMaxFound = true;
            }
        }
        return isMaxFound ? counter + 1 : counter;

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome409().solution("abccccdd"));
    }
}