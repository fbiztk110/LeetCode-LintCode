/* Description:
Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.

It's guaranteed that the size of the array is greater or equal to k.

*/

//LintCode 617
/*Hard*/
/**
 * MaximumAverageSubarrayII644
 */
public class MaximumAverageSubarrayII644 {
    public double maxAverage(int[] nums, int k) {
        // write your code here
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;  
        for(int i : nums) {  
            min = Math.min(min, i);  
            max = Math.max(max, i);  
        }  
          
        double lo = min, hi = max;  
        while(hi-lo > 1e-6) {  
            double mid = (lo+hi)/2.0;  
            if(ok(nums, k ,mid))  
                lo = mid;  
            else  
                hi = mid;  
        }  
          
        return lo;  
    }  
  
    private boolean ok(int[] nums, int k, double mid) {  
        // 数组每个数减去mid，转换为：连续子数组累加大于0  
        double[] t = new double[nums.length];  
        for(int i=0; i<nums.length; i++)  
            t[i] = nums[i] - mid;  
          
        double sum = 0;  
        for(int i=0; i<k; i++)   sum += t[i];  
        if(sum >= 0) return true;  
          
        double min = 0, sum2 = 0;  
        for(int i=k; i<t.length; i++) {  
            sum2 += t[i-k];  
            sum += t[i];  
            min = Math.min(min, sum2);  
              
            if(sum - min >= 0)   return true;      
        }  
          
        return false;  

    }
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648};
        int k = 2;
        System.out.println(new MaximumAverageSubarrayII644().maxAverage(nums,k));
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println(new MaximumAverageSubarrayII644().maxAverage(nums1, k1));
    }
    
}