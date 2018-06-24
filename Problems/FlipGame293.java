/* Description
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example
Given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].

*/

//LintCode 914
/*Easy*/
/**
 * FlipGame293
 */
import java.util.*;
public class FlipGame293 {

    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> result = new ArrayList<>();

        if(s == null){
            return result;
        }

        char[] array = s.toCharArray();
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == '+' && array[i + 1] == '+'){
                array[i] = array[i  + 1] = '-';
                result.add(new String(array));
                array[i] = array[i + 1] = '+';
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(new FlipGame293().generatePossibleNextMoves(s));
    }
}