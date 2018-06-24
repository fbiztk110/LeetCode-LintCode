/* Description
Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string word. Any other string is not a valid abbreviation of word.

Example
Example 1:

Given s = "internationalization", abbr = "i12iz4n":
Return true.
Example 2:

Given s = "apple", abbr = "a2e":
Return false.
*/

//LintCode 637
/*Easy*/

/**
 * ValidWordAbbreviation408
 */
public class ValidWordAbbreviation408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (word == null || abbr == null) {
            return false;
        }
        int i = 0, j = 0;
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();

        while(i < w.length && j < a.length){
            if(Character.isDigit(a[j])){
                if(a[j] == '0'){
                    return false;
                }
                int val = 0;
                while(j < a.length && Character.isDigit(a[j])){
                    val = val*10 + a[j] - '0';
                    j++;
                }
                i += val;
            } else{
                if(w[i++] != a[j++]){
                    return false;
                }
            }
        }
        return i == w.length && j == a.length;
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(new ValidWordAbbreviation408().validWordAbbreviation(word, abbr));
        String word1 = "apple";
        String abbr1 = "a2e";
        System.out.println(new ValidWordAbbreviation408().validWordAbbreviation(word1, abbr1));
    }
}