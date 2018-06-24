/*Description:
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example1:
Given time = "19:34", return "19:39".
Explanation: 
The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example2:
Given time = "23:59", return "22:22".
Explanation: 
The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
*/

//LintCode 862
/*Medium*/
public class NextClosestTime681 {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String solution(String time) {
        // write your code here
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        
        while(true){
            if(++min == 60){
                min = 0;
                ++hour;
                hour %= 24;
            }
            String result = String.format("%02d:%02d", hour, min);
            Boolean check = true;
            for(int i = 0; i < result.length(); ++i){
                if(time.indexOf(result.charAt(i)) < 0){
                    check = false;
                    break;
                }
            }
            if(check){
                return result;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("The result of 19:34 is: " + new NextClosestTime681().solution("19:34"));
        System.out.println("The result of 22:22 is: " + new NextClosestTime681().solution("22:22"));
        System.out.println("The result of 23:59 is: " + new NextClosestTime681().solution("23:59"));
    }
}