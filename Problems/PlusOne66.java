/* Description
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

//LintCode 407
/*Easy*/

/**
 * PlusOne66
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    private static void print(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
    }

    public static void main(String[] args) {
        int[] digits = { 1, 2, 3 };
        int[] digits1 = { 9, 9, 9 };
        int[] digits2 = { 4, 3, 2, 1 };

        print(plusOne(digits));
        System.out.println("");
        print(plusOne(digits1));
        System.out.println("");
        print(plusOne(digits2));
    }
}