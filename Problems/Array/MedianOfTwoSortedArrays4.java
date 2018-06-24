/* Description:
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.
*/
/*
index: 0  1  2  3  4  5
         L1   R1
num1:  3  5 | 8  9          4 cut1
num2:  1  2  7 | 10 11 12   6 cut2
            L2   R2

            L1 L2 R1   R2
num3:  1 2 3 5 7 | 8 9 10 11 12

num3 -> num1 + num2 => num1

L1 <= R2
L2 <= R1

L1 > R2 cut1 << (cutL, cut1 - 1)
L2 > R1 cut2 >> (cut1 + 1, cutR)
*/

//LintCode 65
/*Hard*/
/**
 * MedianOfTwoSortedArrays4
 */

public class MedianOfTwoSortedArrays4 {
    //Time Complexity O(log(min(m,n)))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cutL = 0;
        int cutR = nums1.length;
        int cut1 = nums1.length / 2;
        int cut2 = len / 2 - cutL;

        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1, L2, R1, R2;
            if (cut1 == 0) {
                L1 = Integer.MIN_VALUE;
            } else {
                L1 = nums1[cut1 - 1];
            }
            if (cut2 == 0) {
                L2 = Integer.MIN_VALUE;
            } else {
                L2 = nums2[cut2 - 1];
            }
            if (cut1 == nums1.length) {
                R1 = Integer.MAX_VALUE;
            } else {
                R1 = nums1[cut1];
            }
            if (cut2 == nums2.length) {
                R2 = Integer.MAX_VALUE;
            } else {
                R2 = nums2[cut2];
            }
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    if (L1 > L2) {
                        L1 = L1;
                    } else {
                        L1 = L2;
                    }
                    if (R1 < R2) {
                        R1 = R1;
                    } else {
                        R1 = R2;
                    }
                    return (L1 + R1) / 2;
                } else {
                    if (R1 < R2) {
                        R1 = R1;
                    } else {
                        R1 = R2;
                    }
                    return R1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(nums1, nums2));
        int[] nums3 = { 1, 2, 3, 4, 5, 6 };
        int[] nums4 = { 2, 3, 4, 5 };
        System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(nums3, nums4));
    }
}