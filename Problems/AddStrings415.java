import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/* Description:
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

//LintCode 655
/*Easy*/
public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        String result = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a, b;
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }
            if (j >= 0) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + carry;
            result = (char) (sum % 10 + '0') + result;
            carry = sum / 10;
        }
        if (carry == 1) {
            return "1" + result;
        } else {
            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(new AddStrings415().addStrings("199", "1"));
    }

}