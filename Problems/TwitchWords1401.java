import java.util.Arrays;

/* Description
Our normal words do not have more than two consecutive letters. If there are three or more consecutive letters, this is a tics. Now give a word, from left to right, to find out the starting point and ending point of all tics.

The input string length is n, n <= 100000.

Example
Given str = "whaaaaatttsup", return [[2,6],[7,9]].

Explanation:
"aaaa" and "ttt" are twitching letters, and output their starting and ending points.
Given str = "whooooisssbesssst", return [[2,5],[7,9],[12,15]].

Explanation:
"ooo", "sss" and "ssss" are twitching letters, and output their starting and ending points.*/

//LintCode 1401
/*Easy*/

/**
 * TwitchWords1401
 */
import java.util.*;

public class TwitchWords1401 {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        // Write your code here
        if (str == null || str.length() == 0) {
            return new int[][] {};
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                int start = i;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    i++;
                }
                if (i - start > 1) {
                    result.add(Arrays.asList(new Integer[] { start, i }));
                }
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }

    private static void printRes(int[][] res){
        int i = 0;
        int j = 0;
        System.out.print("[");
        while(i < res.length){
            System.out.print(res[i][j]);
            if(j / (res.length - 1) != 1){
                j++;
            }else{
                System.out.print(" ");
                j = 0; 
                i++;
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        String str = "whaaaaatttsup";
        int[][] res = new TwitchWords1401().twitchWords(str);
        printRes(res);
    }
}