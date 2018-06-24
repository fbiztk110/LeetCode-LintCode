/*  Description:
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000]. */

//LintCode 868
/*Easy*/
/**
 * MaximumAverageSubarrayI643
 */
public class MaximumAverageSubarrayI643 {
    public double findMaxAverage(int[] nums, int k){
        if(nums.length == 0 || k > nums.length){
            return 0;
        }
        double max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - k + 1; i++){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += nums[j];
            }
            double average = (double)sum/k;
            max = Math.max(average, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("The maximum average subarray of length " + k + " is: " + new MaximumAverageSubarrayI643().findMaxAverage(arr, k));
    }
    
}
