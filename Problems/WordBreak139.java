/* Description
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

//LintCode 107
/*Medium*/

/**
 * WordBreak139
 */
import java.util.*;
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(res[i - str.length()]){
                        if(s.substring(i - str.length(), i).equals(str)){
                            res[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(new WordBreak139().wordBreak(s, wordDict));
        String s1 = "catsandog";
        List<String> wordDict1 = new ArrayList<String>();
        wordDict1.add("cats");
        wordDict1.add("dog");
        wordDict1.add("sand");
        wordDict1.add("and");
        wordDict1.add("cat");
        
        System.out.println(new WordBreak139().wordBreak(s1, wordDict1));
    }
}