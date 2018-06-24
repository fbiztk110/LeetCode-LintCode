/* LintCode 81 Description
Numbers keep coming, return the median of numbers at every time a new number added. 

Clarification
What's the definition of Median?

Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge
Total run time in O(nlogn).
*/

/* LeetCode Description
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2 */

import java.util.Collections;
import java.util.PriorityQueue;

// LintCode 81
/*Hard*/
public class FindMedianFromDataStream295 {
    // Solution for LintCode
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] solution(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            addNums(maxHeap, minHeap, nums[i]);
            result[i] = maxHeap.peek();
        }

        return result;
    }

    private void addNums(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() - maxHeap.size() > 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Solution LeetCode
    /** initialize your data structure here. */
    public PriorityQueue<Integer> minHeap, maxHeap;

    public FindMedianFromDataStream295() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek();
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
     * obj.findMedian();
     */

}