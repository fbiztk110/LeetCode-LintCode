import java.util.LinkedList;

/* Description
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example
MovingAverage m = new MovingAverage(3);
m.next(1) = 1 // return 1.00000
m.next(10) = (1 + 10) / 2 // return 5.50000
m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
*/

//LintCode 642
/*Easy*/

/**
 * MovingAverageFromDataStream346
 */
import java.util.*;
public class MovingAverageFromDataStream346 {
    private Queue<Integer> que;
    private double sum;
    private int size;

    /*
     * @param size: An integer
     */public MovingAverageFromDataStream346(int size) {
        // do intialization if necessary
        que = new LinkedList<Integer>();
        this.size = size;
        sum = 0.0;
    }

    /*
     * @param val: An integer
     * 
     * @return:
     */
    public double next(int val) {
        // write your code here
        sum += val;
        if (que.size() == size) {
            sum -= que.poll();
        }
        que.offer(val);
        return sum / que.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream346 m = new MovingAverageFromDataStream346(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}