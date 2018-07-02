/* Description
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example
Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
return ["2", "4->49", "51->74", "76->99"].
*/

//LintCode 641
/*Medium*/

/**
 * MissingRanges163
 */
import java.util.*;

public class MissingRanges163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addRange(result, lower, upper);
            return result;
        }

        addRange(result, lower, (long) nums[0] - 1);

        for (int i = 1; i < nums.length; i++) {
            addRange(result, (long) nums[i - 1] + 1, (long) nums[i] - 1);
        }
        addRange(result, (long) nums[nums.length - 1] + 1, upper);

        return result;
    }

    void addRange(List<String> result, long lower, long upper) {
        if (lower > upper) {
            return;
        }
        if (lower == upper) {
            result.add(lower + "");
            return;
        }
        result.add(lower + "->" + upper);
    }

    public static void main(String[] args) {
        int[] nums = { 2147483647 };
        int lower = 0;
        int upper = 2147483647;
        System.out.println(new MissingRanges163().findMissingRanges(nums, lower, upper));
    }
}