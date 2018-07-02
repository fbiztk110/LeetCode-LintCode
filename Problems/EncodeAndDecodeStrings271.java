/* Description
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Example
Given strs = ["lint","code","love","you"]
string encoded_string = encode(strs)

return ["lint","code","love","you"] when you call decode(encoded_string)
*/

//LintCode 659
/*Medium*/

/**
 * EncodeAndDecodeStrings271
 */
import java.util.*;

public class EncodeAndDecodeStrings271 {
    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(ArrayList<String> strs) {
        // write your code here
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == ':') {
                    res.append("::");
                } else {
                    res.append(c);
                }
            }
            res.append(":;");
        }
        return res.toString();
    }

    /*
     * @param str: A string
     * 
     * @return: dcodes a single string to a list of strings
     */
    public static ArrayList<String> decode(String str) {
        // write your code here
        ArrayList<String> res = new ArrayList<>();
        char[] sc = str.toCharArray();
        StringBuilder item = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (sc[i] == ':') {
                if (sc[i + 1] == ';') {
                    res.add(item.toString());
                    item = new StringBuilder();
                    i += 2;
                } else {
                    item.append(sc[i + 1]);
                    i += 2;
                }
            }else{
                item.append(sc[i]);
                i += 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<String>();
        str.add("lint");
        str.add("code");
        str.add("love");
        str.add("you");
        
        System.out.println(encode(str));
        System.out.println(decode(encode(str)));
    }
}
