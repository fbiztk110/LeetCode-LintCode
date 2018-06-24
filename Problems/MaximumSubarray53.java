/* Description:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

//LintCode 41
/*Easy*/

/**
 * MaximumSubarray53
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 9 };
        System.out.println(new MaximumSubarray53().maxSubArray(test));
    }
}