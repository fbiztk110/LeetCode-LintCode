/*Description
There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.
The given array will be in the range [1, 20000].

Example
Given flowers = [1,3,2], k = 1, return 2.

Explanation: 
In the second day, the first and the third flower have become blooming.
Given flowers = [1,2,3], k = 1, return -1.
 */

//Lintcode 861
/*Hard*/
import java.util.*;
public class KEmptySlots683 {
    /**
     * @param flowers: the place where the flower will open in that day
     * @param k:  an integer
     * @return: in which day meet the requirements
     */
    public int kEmptySlots(int[] flowers, int k) {
        // Write your code here
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k){
                return day;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        int[] test2 = {1,3,2};
        System.out.println(new KEmptySlots683().kEmptySlots(test, 1));
        System.out.println(new KEmptySlots683().kEmptySlots(test2, 1));
    }
}