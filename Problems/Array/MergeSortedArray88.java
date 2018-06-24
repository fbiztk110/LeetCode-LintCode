/* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

//LintCode 64
/*Easy*/
/**
 * MergeSortedArray88
 */

import java.util.*;

public class MergeSortedArray88 {
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int x = A.length;
        int y = B.length;
        if (x > m) {
            x = m;
        }
        if (y > n) {
            y = n;
        }
        for (int i = 0; i < m; i++) {
            A[i] = A[i];
        }
        for (int j = m, k = 0; j < m + n; j++, k++) {
            A[j] = B[k];
        }
        Arrays.sort(A);
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] B = { 2, 4, 6 };
        int n = 3;
        mergeSortedArray(A, m, B, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(A[i]);
        }
    }
}